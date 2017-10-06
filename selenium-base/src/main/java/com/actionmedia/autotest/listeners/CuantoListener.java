package com.actionmedia.autotest.listeners;

import com.actionmedia.autotest.listeners.cuanto.CuantoAdapterException;
import com.actionmedia.autotest.listeners.cuanto.api.CuantoConnector;
import com.actionmedia.autotest.listeners.cuanto.api.TestOutcome;
import com.actionmedia.autotest.listeners.cuanto.api.TestResult;
import com.actionmedia.autotest.listeners.cuanto.api.TestRun;
import com.actionmedia.autotest.listeners.cuanto.listener.testng.TestNgListener;
import com.actionmedia.autotest.listeners.cuanto.listener.testng.TestNgListenerArguments;
import com.actionmedia.autotest.spring.SeleniumSettings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Listener for Cuanto - test tracking and analysis tool.
 * User: n.tyukavkin
 * Date: 05.10.13
 */
public class CuantoListener extends TestNgListener {

    private static final Log LOGGER = LogFactory.getLog(CuantoListener.class);

    private static final String CUANTO_URL = "http://192.168.70.181:8090/cuanto/";
    private TestNgListenerArguments arguments;
    private static Long testRunId;
    private String projectName = "";
    private static final Object syncObject = new Object();
    private static final ThreadLocal<Long> configDuration =
            new ThreadLocal<Long>() {
                @Override
                protected Long initialValue() {
                    return 0L;
                }
            };
    private static final SeleniumSettings SELENIUM_SETTINGS = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/context-selenium.xml"}).getBean(SeleniumSettings.class);

    public CuantoListener() throws CuantoAdapterException, URISyntaxException {
        try {
            arguments = new TestNgListenerArguments();
            arguments.setCuantoUrl(new URI(CUANTO_URL));
            arguments.setIncludeConfigDuration(true);
            arguments.setCreateTestRun(true);
            TestNgListener.setTestNgListenerArguments(arguments);
        } catch (URISyntaxException e) {
            LOGGER.error("URISyntaxException occurs", e);
        }
    }

    /**
     * Overrides method onStart to check whether tests are launched using testNG xml
     * and thus results should be stored to Cuanto
     *
     * @param iTestContext - all information about test run
     */
    @Override
    public void onStart(ITestContext iTestContext) {
        try {
            setCuantoProjectName(iTestContext);
        } catch (RuntimeException e) {
            return;
        }
        TestNgListener.setTestNgListenerArguments(arguments);
        super.onStart(iTestContext);
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        createTestOutcome(iTestResult, TestResult.Pass);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        createTestOutcome(iTestResult, TestResult.Fail);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        createTestOutcome(iTestResult, TestResult.Skip);
    }

    private void createTestOutcome(ITestResult testCaseResult, TestResult cuantoTestResult) {
        IClass testClass = testCaseResult.getTestClass();
        String testCaseName = testCaseResult.getName();
        String packageName = testClass.getRealClass().getName();
        Object[] testCaseParameters = testCaseResult.getParameters();

        TestOutcome testOutcome = TestOutcome.newInstance(packageName, testCaseName, testCaseParameters, cuantoTestResult);

        String[] tags = testCaseResult.getMethod().getGroups();
        long duration = testCaseResult.getEndMillis() - testCaseResult.getStartMillis();

        TestNgListenerArguments arguments = getTestNgListenerArguments();
        duration += configDuration.get();
        configDuration.set(0L);

        String notes = "Шаги:\n";
        for (String result : Reporter.getOutput(testCaseResult)) {
            if (result.contains(".png")) {
                continue;
            }
            notes = notes + result.replaceAll("<.*?>", "") + "\n";
        }

        if (cuantoTestResult == TestResult.Fail) {
            String errorMessage = String.format("%s %s %s %s %s %s",
                    testCaseResult.getThrowable().getMessage() + "\n",
                    "____________________________________________________________\n",
                    notes + "\n",
                    "____________________________________________________________\n",
                    "Stacktrace:\n",
                    getTestOutput(testCaseResult));

            testOutcome.setTestOutput(errorMessage);
        } else if (cuantoTestResult == TestResult.Pass) {
            testOutcome.setTestOutput(notes);
        } else if (cuantoTestResult == TestResult.Skip) {
            testOutcome.setTestOutput(getTestOutput(testCaseResult));
        }


        testOutcome.addTags(Arrays.asList(tags));
        testOutcome.setDuration(duration);

        // because the user may have modified the Cuanto url or the test run arguments,
        // lazily create the cuanto connector and determine the test run to which to submit this test outcome
        TestRun testRun = null;
        CuantoConnector cuanto = null;
        synchronized (syncObject) {
            String projectKey = getProjectKey();
            String cuantoUrl = getCuantoUrl().toString();
            cuanto = CuantoConnector.newInstance(cuantoUrl, projectKey);
            testRun = determineTestRunId(cuanto, arguments);
        }

        cuanto.addTestOutcome(testOutcome, testRun);
    }

    private TestRun determineTestRunId(CuantoConnector cuanto, TestNgListenerArguments args) {
        if (testRunId == null && isCreateTestRun()) {
            testRunId = createTestRun(cuanto, getProjectKey());
            args.setTestRunId(testRunId);
            setTestNgListenerArguments(args);
        }

        if (testRunId == null) {
            return null;
        }

        TestRun testRun = cuanto.getTestRun(testRunId);

        Map<String, String> testProperties = getTestProperties();
        if (testProperties != null) {
            for (Map.Entry<String, String> testPropertyEntry : testProperties.entrySet())
                testRun.addTestProperty(testPropertyEntry.getKey(), testPropertyEntry.getValue());
        }

        Map<String, String> links = getLinks();
        if (links != null) {
            for (Map.Entry<String, String> linkEntry : links.entrySet())
                testRun.addLink(linkEntry.getValue(), linkEntry.getKey());
        }

        cuanto.updateTestRun(testRun);
        return testRun;
    }

    private Long createTestRun(CuantoConnector cuanto, String cuantoProjectKey) {
        TestRun testRun = new TestRun(cuantoProjectKey);
        testRun.setDateExecuted(new Date());
        testRun.setNote("Created by " + this.getClass().getSimpleName());

        if (!projectName.isEmpty()) {
            if (projectName.equals("regression")) {
                testRun.addTestProperty("system", "OSS");
            }
            if (projectName.equals("systems")) {
                if (SELENIUM_SETTINGS.isRunBss()) {
                    testRun.addTestProperty("system", "BSS");
                }
                if (SELENIUM_SETTINGS.isRunKss()) {
                    testRun.addTestProperty("system", "KSS");
                }
                if (SELENIUM_SETTINGS.isRunUss()) {
                    testRun.addTestProperty("system", "USS");
                }
                if (SELENIUM_SETTINGS.isRunFss()) {
                    testRun.addTestProperty("system", "FSS");
                }
            }
        }

        String browser = SELENIUM_SETTINGS.getDriverName();
        if (browser != null && !browser.isEmpty()) {
            testRun.addTestProperty("browser", browser);
        }

        String environment = SELENIUM_SETTINGS.getEnvironment();
        if (environment != null && !environment.isEmpty()) {
            testRun.addTestProperty("environment", environment);
        }
        return cuanto.addTestRun(testRun);
    }

    private Long createTestRun(String projectKey) {
        synchronized (syncObject) {
            CuantoConnector cuantoConnector = CuantoConnector.newInstance(CUANTO_URL, projectKey);
            if (testRunId == null) {
                Long id = createTestRun(cuantoConnector, projectKey);
                testRunId = id;
                return id;
            } else {
                return testRunId;
            }
        }
    }

    private void setCuantoProjectName(ITestContext iTestContext) {
        if (projectName.isEmpty()) {
            projectName = iTestContext.getSuite().getName();
            arguments.setProjectKey(projectName);
            arguments.setTestRunId(createTestRun(projectName));
        }
    }

    private String getTestOutput(ITestResult testCaseResult) {
        return getStackTrace(testCaseResult.getThrowable());
    }

    private static String getStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        Writer stacktrace = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stacktrace);
        throwable.printStackTrace(printWriter);
        return stacktrace.toString();
    }
}

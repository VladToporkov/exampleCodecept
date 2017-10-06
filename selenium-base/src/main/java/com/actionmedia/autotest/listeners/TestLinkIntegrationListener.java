package com.actionmedia.autotest.listeners;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.*;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.screenshots.ScreenshotInfo;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.utils.TestMethodUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.testng.*;
import sun.misc.BASE64Encoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static com.actionmedia.autotest.screenshots.ScreenShotsPathsHolder.getScreenShotPathsForTest;
import static java.lang.String.format;

public class TestLinkIntegrationListener implements IInvokedMethodListener2 {

    private final Log logger = LogFactory.getLog(getClass());
    private static final Object SYNC_OBJECT = new Object();
    private static Build testBuild;
    private static TestLinkAPI testLinkAPI;

    @Override
    public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult testResult, ITestContext testContext) {
    }

    @Override
    public void afterInvocation(IInvokedMethod invokedMethod, ITestResult testResult, ITestContext testContext) {

        final TestCaseInfo testCaseInfo = getTestCaseInfo(invokedMethod, testContext);
        final Properties testLinkInfo = (Properties) testContext.getAttribute("testLinkInfo");

        if (testCaseInfo == null || testLinkInfo == null) {
            return;
        }

        if (!Boolean.parseBoolean(testLinkInfo.getProperty("testLink.using"))) {
            return;
        }

        disableCertificateValidation();

        final TestLinkAPI api = getTestLinkAPI(testLinkInfo);
        if (api == null) {
            return;
        }

        synchronized (SYNC_OBJECT) {
            final String testName = getTestName(testResult).split(".browser")[0];
            if (Boolean.parseBoolean(testLinkInfo.getProperty("testLink.createBuild"))) {
                Build build = createTestBuild(api, testLinkInfo);

                if (testResult.isSuccess() && !isPostponedFailed(testContext, testName)) {
                    reportTCResultToNewBuild(api, testCaseInfo, build, ExecutionStatus.PASSED, testResult);
                } else if (testResult.getStatus() == ITestResult.FAILURE) {
                    ReportTCResultResponse reportTCResultResponse = reportTCResultToNewBuild(api, testCaseInfo, build, ExecutionStatus.FAILED, testResult);
                    uploadScreenshotsByTCResult(api, getTestName(testResult), reportTCResultResponse);
                }
            } else {
                if (testResult.isSuccess() && !isPostponedFailed(testContext, testName)) {
                    reportTCResult(api, testCaseInfo, testLinkInfo, ExecutionStatus.PASSED);
                }
            }
        }
    }

    private Boolean isPostponedFailed(ITestContext testContext, String testName) {
        Boolean postponedFailed = (Boolean) testContext.getAttribute(format("%s postpone fail", testName));
        return postponedFailed != null ? postponedFailed : false;
    }

    @Override
    public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult testResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod invokedMethod, ITestResult testResult) {
    }

    protected String getTestName(ITestResult testResult) {
        return TestMethodUtils.getTestName(testResult);
    }

    private void uploadScreenshotsByTCResult(final TestLinkAPI api, final String testName, final ReportTCResultResponse reportTCResultResponse) {
        if (reportTCResultResponse != null) {
            for (ScreenshotInfo screenshotInfo : getScreenShotPathsForTest(testName)) {


                Reporter.log(screenshotInfo.getPath());
                Reporter.log(screenshotInfo.getMessage());

                System.out.println(screenshotInfo.getPath());
                System.out.println(screenshotInfo.getMessage());

                final File attachmentFile = new File(screenshotInfo.getPath());

                Reporter.log(attachmentFile.getAbsolutePath());
                try {
                    Reporter.log(attachmentFile.getCanonicalPath());
                } catch (IOException e) {
                    logger.error("IOException occurs", e);
                }


                final String fileContent = getFileContent(attachmentFile);

                if (fileContent != null && !isSuchScreenshotAlreadyUploaded(api, reportTCResultResponse.getExecutionId(), screenshotInfo)) {
                    uploadExecutionAttachment(api, reportTCResultResponse.getExecutionId(), attachmentFile.getName(),
                            fileContent, truncateMessage(screenshotInfo.getMessage()));
                }
            }
        }
    }

    private boolean isSuchScreenshotAlreadyUploaded(final TestLinkAPI api, final Integer executionId, final ScreenshotInfo screenshotInfo) {
        try {
            final Integer testCaseExternalId = null;
            //xmlrpc.class.php should be modified. Use 'executions' as fkTableName and disable checkTestCaseIdentity
            final Attachment[] testCaseAttachments = api.getTestCaseAttachments(executionId, testCaseExternalId);
            for (Attachment attachment : testCaseAttachments) {
                if (attachment.getTitle().equals(truncateMessage(screenshotInfo.getMessage()))) {
                    return true;
                }
            }
        } catch (TestLinkAPIException e) {
            logger.error("TestLinkAPIException occurs", e);
        }

        return false;
    }

    private String truncateMessage(final String message) {
        final String additionalInfoSectionBeginning = "Build info: version:";
        if (message.contains(additionalInfoSectionBeginning)) {
            return message.substring(0, message.indexOf(additionalInfoSectionBeginning)).replaceAll("\n", " ").trim();
        }

        return message;
    }

    private String getFileContent(final File attachmentFile) {
        try {
            final byte[] byteArray = FileUtils.readFileToByteArray(attachmentFile);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(byteArray);
        } catch (IOException e) {
            logger.error("IOException occurs", e);
        }

        return null;
    }

    private Attachment uploadExecutionAttachment(final TestLinkAPI api, final Integer executionId, final String filename, final String fileContent, final String title) {
        final String fileType = "image/png";

        Reporter.log(filename);
        System.out.println(filename);

        try {
            return api.uploadExecutionAttachment(executionId, title, null, filename, fileType, fileContent);
        } catch (TestLinkAPIException e) {
            logger.info("executionId - " + executionId);
            logger.info("title - " + title);
            logger.info("filename - " + filename);
            logger.info("fileType - " + fileType);
            logger.error("TestLinkAPIException occurs", e);
        }

        return null;
    }

    private ReportTCResultResponse reportTCResult(final TestLinkAPI api, final TestCaseInfo testCaseInfo, final Properties testLinkInfo, final ExecutionStatus status) {
        try {
            final TestCase testCase = api.getTestCaseByExternalId(testCaseInfo.getFullTestCaseExternalId(), testCaseInfo.getVersion());
            final TestPlan testPlan = api.getTestPlanByName(testLinkInfo.getProperty("testLink.testPlanName"), testLinkInfo.getProperty("testLink.projectName"));
            final Build build = getBuildForTestPlanByName(api, testPlan, testLinkInfo.getProperty("testLink.buildName"));
            Integer platformId = null;
            String platformName = null;

            final Platform[] platformIdListForPlan = api.getTestPlanPlatforms(testPlan.getId());

            final String platformParam = System.getenv("OSS_PLATFORMS");
            if (platformParam != null && !platformParam.isEmpty()) {
                for (Platform platform : platformIdListForPlan) {
                    if (platform.getName().equals(testCaseInfo.getPlatform())) {
                        platformId = platform.getId();
                        platformName = platform.getName();
                        break;
                    }
                }
            }

            final Integer testCaseExternalId = null;
            final String notes = "";
            final Boolean guess = Boolean.TRUE;
            final String bugId = "";
            final Map<String, String> customFields = new HashMap<String, String>(0);
            final Boolean overwrite = Boolean.FALSE;

            System.out.println("id - " + testCaseInfo.getFullTestCaseExternalId() + ", testCasePlatform - " + testCaseInfo.getPlatform() + ", contextPlatform - " + platformName);

            return api.reportTCResult(testCase.getId(), testCaseExternalId, testPlan.getId(), status, build.getId(), build.getName(), notes, guess, bugId, platformId, platformName, customFields, overwrite);
        } catch (TestLinkAPIException e) {
            logger.error("TestLinkAPIException occurs", e);
        }

        return null;
    }

    private Build createTestBuild(final TestLinkAPI api, final Properties testLinkInfo) {
        synchronized (SYNC_OBJECT) {
            if (testBuild == null) {

                String date = new DateTime().toDateTime().toString().split("\\.")[0];
                String projectName = testLinkInfo.getProperty("testLink.projectName");
                String testPlanName = testLinkInfo.getProperty("testLink.testPlanName");
                String browser = SeleniumHolder.getDriverName();
                String host = SeleniumHolder.getHost();
                String buildNotes = "url: '" + host + "' browser: '" + browser + "'";
                final TestPlan testPlan = api.getTestPlanByName(testPlanName, projectName);

                testBuild = api.createBuild(testPlan.getId(), testPlan.getProjectName() + " " + host.split(".actiondigital.ru")[0] + " " + " auto_" + date, buildNotes);
                return testBuild;
            } else {
                return testBuild;
            }
        }
    }

    private ReportTCResultResponse reportTCResultToNewBuild(final TestLinkAPI api, final TestCaseInfo testCaseInfo, Build build, final ExecutionStatus status, final ITestResult testResult) {
        final TestCase testCase = api.getTestCaseByExternalId(testCaseInfo.getFullTestCaseExternalId(), testCaseInfo.getVersion());
        Integer platformId = null;
        String platformName = null;
        final Integer testCaseExternalId = null;
        String notes = "";
        if (testResult != null) {
            for (String result : Reporter.getOutput(testResult)) {
                if (result.contains(".png")) {
                    continue;
                }
                notes = notes + result.replaceAll("<.*?>", "") + "\n";
            }
        }
        final Boolean guess = Boolean.TRUE;
        final String bugId = "";
        final Map<String, String> customFields = new HashMap<String, String>(0);
        final Boolean overwrite = Boolean.TRUE;
        try {
            return api.reportTCResult(testCase.getId(), testCaseExternalId, build.getTestPlanId(), status, build.getId(), build.getName(), notes, guess, bugId, platformId, platformName, customFields, overwrite);
        } catch (TestLinkAPIException e) {
            logger.info("TestCaseId - " + testCase.getId());
            logger.info("TestPlanId - " + build.getTestPlanId());
            logger.info("Status - " + status);
            logger.info("BuildId - " + build.getId());
            logger.info("BuildName - " + build.getName());
            logger.info("Notes - " + notes);
            logger.info("BugId - " + bugId);
            logger.info("CustomFields - " + customFields);

            logger.error("TestLinkAPIException occurs", e);
        }

        return null;
    }

    private TestLinkAPI getTestLinkAPI(Properties testLinkInfo) {
        synchronized (SYNC_OBJECT) {
            if (testLinkAPI == null) {
                final String url = testLinkInfo.getProperty("testLink.url");
                final String devKey = testLinkInfo.getProperty("testLink.devkey");

                TestLinkAPI api;
                URL testLinkURL;
                try {
                    testLinkURL = new URL(url);
                } catch (MalformedURLException mue) {
                    logger.error("MalformedURLException occurs", mue);
                    return null;
                }

                try {
                    api = new TestLinkAPI(testLinkURL, devKey);
                } catch (TestLinkAPIException te) {
                    logger.error("TestLinkAPIException occurs", te);
                    return null;
                }
                testLinkAPI = api;
                return testLinkAPI;
            } else {
                return testLinkAPI;
            }
        }
    }

    private void disableCertificateValidation() {
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            final SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        }
    }

    private Build getBuildForTestPlanByName(TestLinkAPI api, TestPlan testPlan, String buildName) {
        Build result = null;
        final Build[] allBuilds = api.getBuildsForTestPlan(testPlan.getId());
        for (Build build : allBuilds) {
            if (buildName.equals(build.getName())) {
                result = build;
                break;
            }
        }

        if (result == null) {
            result = api.getLatestBuildForTestPlan(testPlan.getId());
        }

        return result;
    }

    private TestCaseInfo getTestCaseInfo(final IInvokedMethod method, final ITestContext context) {
        final ITestNGMethod test = method.getTestMethod();

        final TestLink testLink = test.getConstructorOrMethod().getMethod().getAnnotation(TestLink.class);
        if (testLink == null) {
            return null;
        }

        Integer version;
        try {
            version = Integer.parseInt(testLink.testCaseVersion());
        } catch (NumberFormatException e) {
            logger.error("NumberFormatException occurs", e);
            return null;
        }

        String platform = String.valueOf(context.getAttribute("platform"));

        return new TestCaseInfo(testLink.testCaseId(), version, platform);
    }

    private static class TestCaseInfo {
        private String fullTestCaseExternalId;
        private Integer version;
        private String platform;

        private TestCaseInfo(String fullTestCaseExternalId, Integer version, String platform) {
            this.fullTestCaseExternalId = fullTestCaseExternalId;
            this.version = version;
            this.platform = platform;
        }

        String getFullTestCaseExternalId() {
            return fullTestCaseExternalId;
        }

        Integer getVersion() {
            return version;
        }

        String getPlatform() {
            return platform;
        }
    }
}

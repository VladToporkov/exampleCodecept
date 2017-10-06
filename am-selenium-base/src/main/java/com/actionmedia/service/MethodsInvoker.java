package com.actionmedia.service;

import com.actionmedia.annotations.AfterSuiteCustom;
import com.actionmedia.annotations.BeforeSuiteCustom;
import com.actionmedia.autotest.annotations.FireFoxOnly;
import com.actionmedia.autotest.selenium.AbstractSeleniumTest;
import com.actionmedia.autotest.selenium.FFDriverHolder;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.base.BaseTest;
import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang.ArrayUtils.contains;
import static org.apache.commons.lang.ArrayUtils.isEmpty;
import static org.testng.Reporter.log;

@Service
public class MethodsInvoker {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodsInvoker.class);
    private static final String UNABLE_TO_CREATE_TEST_CLASS_INSTANCE = "Unable to create test class instance. ";

    public <T extends Annotation> void invokeSuiteMethodsByAnnotation(final Class<T> annotationClass, final ITestContext testContext) {
        final List<XmlClass> suiteClasses = getAllClassesFromTestContext(testContext);
        for (XmlClass xmlClass : suiteClasses) {
            final TestClassContext testClassContext = new TestClassContext(xmlClass.getSupportClass(), null, annotationClass,
                    testContext.getIncludedGroups(), testContext.getExcludedGroups());
            invokeMethodsByAnnotation(testClassContext);
        }
    }

    public <T extends Annotation> void invokeGroupMethodsByAnnotation(final Class<T> annotationClass, final ITestContext testContext) {
        final TestClassContext testClassContext = new TestClassContext(((TestRunner) testContext).getTest().getXmlClasses().get(0).getSupportClass(), null, annotationClass);
        invokeMethodsByAnnotation(testClassContext);
    }

    public <T extends Annotation> void invokeMethodsByAnnotation(final BaseTest testObject, final Class<T> annotationClass) {
        invokeMethodsByAnnotation(new TestClassContext(testObject.getClass(), testObject, annotationClass));
    }

    private void invokeMethodsByAnnotation(final TestClassContext context) {
        final Method[] methods = context.getTestClass().getMethods();
        for (Method method : methods) {
            if (isMethodShouldBeInvoked(method, context)) {
                BaseTest testInstance = context.getTestInstance();
                if (testInstance != null || (testInstance = createTestClassInstance(context.getTestClass())) != null) {
                    testInstance.getLoginData(method);
                    invokeMethod(testInstance, method);
                }
            }
        }
    }

    private List<XmlClass> getAllClassesFromTestContext(final ITestContext context) {
        final List<XmlClass> classes = new ArrayList<XmlClass>();
        for (XmlTest xmlTest : context.getSuite().getXmlSuite().getTests()) {
            classes.addAll(xmlTest.getClasses());
        }

        return classes;
    }

    private boolean isMethodShouldBeInvoked(final Method method, final TestClassContext context) {
        final Annotation methodAnnotation = method.getAnnotation(context.getAnnotationToInvokeMethod());
        if (methodAnnotation == null) {
            return false;
        }

        boolean alwaysRun = getAlwaysRunFromAnnotation(methodAnnotation);
        if (alwaysRun) {
            return true;
        }

        final String[] groups = getGroupsFromAnnotation(methodAnnotation);
        for (String group : groups) {
            if (contains(context.getExcludedGroups(), group)) {
                return false;
            }
        }

        for (String group : groups) {
            if (contains(context.getIncludedGroups(), group)) {
                return true;
            }
        }

        return isEmpty(context.getExcludedGroups()) && isEmpty(context.getIncludedGroups());
    }

    private String[] getGroupsFromAnnotation(final Annotation methodAnnotation) {
        if (methodAnnotation.annotationType() == BeforeSuiteCustom.class) {
            return ((BeforeSuiteCustom) methodAnnotation).groups();
        }

        if (methodAnnotation.annotationType() == AfterSuiteCustom.class) {
            return ((AfterSuiteCustom) methodAnnotation).groups();
        }

        return new String[0];
    }

    private boolean getAlwaysRunFromAnnotation(final Annotation methodAnnotation) {
        if (methodAnnotation.annotationType() == BeforeSuiteCustom.class) {
            return ((BeforeSuiteCustom) methodAnnotation).alwaysRun();
        }

        return methodAnnotation.annotationType() != AfterSuiteCustom.class || ((AfterSuiteCustom) methodAnnotation).alwaysRun();
    }

    protected <T extends BaseTest> T createTestClassInstance(final Class<T> testClass) {
        try {
            final String[] locations = (String[]) ArrayUtils.addAll(BaseTest.class.getAnnotation(ContextConfiguration.class).locations(),
                    AbstractSeleniumTest.class.getAnnotation(ContextConfiguration.class).locations());
            final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);

            final T instance = applicationContext.getAutowireCapableBeanFactory().createBean(testClass);
            final TestContextManager testContextManager = new TestContextManager(testClass);
            testContextManager.prepareTestInstance(instance);
            return instance;
        } catch (BeansException e) {
            log(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE + e.getMessage());
            LOGGER.error(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE, e);
        } catch (IllegalStateException e) {
            log(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE + e.getMessage());
            LOGGER.error(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE, e);
        } catch (Exception e) {
            log(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE + e.getMessage());
            LOGGER.error(UNABLE_TO_CREATE_TEST_CLASS_INSTANCE, e);
        }

        return null;
    }

    private void invokeMethod(final BaseTest instance, final Method method) {
        final WebDriver mainDriver = SeleniumHolder.getWebDriver();

        if (method.getAnnotation(FireFoxOnly.class) != null) {
            SeleniumHolder.setWebDriver(FFDriverHolder.getFirefoxDriver());
        }

        try {
            method.invoke(instance);
        } catch (Throwable e) {
            instance.takeScreenshot(e.getMessage(), method.getName());
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String errorMessage = format("Precondition method '%s' failed ", method.getName()) + "\n " + result.toString();
            instance.setPostponedTestFail(errorMessage);
            log(errorMessage);

        } finally {
            SeleniumHolder.setWebDriver(mainDriver);
        }
    }

    private static final class TestClassContext {
        private final Class testClass;
        private final BaseTest testInstance;
        private final Class<? extends Annotation> annotationClassToInvokeMethods;
        private String[] includedGroups;
        private String[] excludedGroups;

        private TestClassContext(Class testClass, BaseTest testInstance, Class<? extends Annotation> annotationClassToInvokeMethods) {
            this.testClass = testClass;
            this.testInstance = testInstance;
            this.annotationClassToInvokeMethods = annotationClassToInvokeMethods;
        }

        private TestClassContext(Class testClass, BaseTest testInstance, Class<? extends Annotation> annotationClassToInvokeMethods,
                                 String[] newIncludedGroups, String[] newExcludedGroups) {
            this.testClass = testClass;
            this.testInstance = testInstance;
            this.annotationClassToInvokeMethods = annotationClassToInvokeMethods;
            if (newExcludedGroups == null) {
                this.excludedGroups = new String[0];
            } else {
                this.excludedGroups = Arrays.copyOf(newExcludedGroups, newExcludedGroups.length);
            }
            if (newIncludedGroups == null) {
                this.includedGroups = new String[0];
            } else {
                this.includedGroups = Arrays.copyOf(newIncludedGroups, newIncludedGroups.length);
            }
        }

        public Class getTestClass() {
            return testClass;
        }

        public BaseTest getTestInstance() {
            return testInstance;
        }

        public Class<? extends Annotation> getAnnotationToInvokeMethod() {
            return annotationClassToInvokeMethods;
        }

        public String[] getIncludedGroups() {
            return includedGroups;
        }

        public String[] getExcludedGroups() {
            return excludedGroups;
        }
    }
}

package com.actionmedia.autotest.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseEvent;
import ru.yandex.qatools.allure.model.Label;
import ru.yandex.qatools.allure.model.LabelName;
import ru.yandex.qatools.allure.model.TestCaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ntyukavkin
 * Date: 06.10.2015
 * Time: 11:05
 */
public class AllureSetTestContextListener implements ITestListener {

    private Allure lifecycle = Allure.LIFECYCLE;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        final String packageName = iTestResult.getTestClass().getName();
        final String testName = iTestResult.getName();

        final List<Label> labelList = new ArrayList<Label>();

        String platform = iTestResult.getTestContext().getCurrentXmlTest().getParameter("platform");
        if (platform != null && !platform.isEmpty()) {
            labelList.add(new Label().withName(LabelName.FEATURE.value()).withValue(platform));
        }

        lifecycle.fire(new TestCaseEvent() {
            @Override
            public void process(TestCaseResult context) {
                context.setName(packageName + ":" + testName);
                context.setTitle(testName);

                labelList.addAll(context.getLabels());

                context.setLabels(labelList);
            }
        });
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
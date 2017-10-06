package com.actionmedia.tests.functional.loadtests;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 13.07.2014
 * Time: 15:42
 */
public class LoadMainPageTest extends LoadTestsBase {

    private static final Object[][] urls = new Object[][]{
            {"http://bss-prok1.1glp.ru"},
            {"http://kss-prok1.1glp.ru"},
            {"http://uss-prok1.1glp.ru"},
            {"http://fss-prok1.1glp.ru"},
            {"http://bss-prok2.1glp.ru"},
            {"http://kss-prok2.1glp.ru"},
            {"http://uss-prok5.1glp.ru"},
            {"http://fss-prok2.1glp.ru"}
    };
    private static final int COUNT = 5;
    private List<String> runUrlList = new ArrayList<String>();
    private WebDriver driver;

    @DataProvider(name = "provider")
    public Object[][] provider() {
        return urls;
    }

    @BeforeSuite
    public void setStartTime() {
        startTime = new DateTime();
    }

    @Test(dataProvider = "provider", invocationCount = COUNT)
    public void openMainPage(String url) {
        String errorMessage = null;
        driver = firefox();
        driver.manage().deleteAllCookies();
        DateTime startTime = new DateTime();
        try {
            driver.get(url);
            waitForLoad(driver);
        } catch (Throwable e) {
            errorMessage = "Ошибка при открытии: " + url;
        }
        DateTime endTime = new DateTime();

        double timeToLoad = (double) (endTime.getMillis() - startTime.getMillis()) / 1000;

        System.out.println("URL:" + url + " time to load - " + timeToLoad);

        runUrlList.add(url);
        RunResult runResult = new RunResult(getNumberOfRun(runUrlList, url), startTime, endTime, errorMessage);
        setRunResult(url, runResult);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @AfterSuite
    public void write() {
        writeToFile(COUNT);
    }
}

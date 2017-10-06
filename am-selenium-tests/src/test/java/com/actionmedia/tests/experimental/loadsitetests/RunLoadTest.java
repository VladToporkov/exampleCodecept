package com.actionmedia.tests.experimental.loadsitetests;

import com.actionmedia.autotest.spring.SeleniumSettings;
import org.joda.time.DateTime;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 07.12.2014
 * Time: 19:10
 */
public class RunLoadTest {

    private static final SeleniumSettings SELENIUM_SETTINGS = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/context-selenium.xml"}).getBean(SeleniumSettings.class);

    private static final Object[][] urls = new Object[][]{
            {"http://bss-prok1.1glp.ru"},
            {"http://bu.bss-prok1.1glp.ru"},
            {"http://u.bss-prok1.1glp.ru"},
            {"http://vip.bss-prok1.1glp.ru"},
            {"http://kss-prok1.1glp.ru"},
            {"http://vip.kss-prok1.1glp.ru"},
            {"http://bu.kss-prok1.1glp.ru"},
            {"http://uss-prok1.1glp.ru"},
            {"http://fss-prok5.1glp.ru"}
    };

    private List<RunResult> runResultList = new ArrayList<RunResult>();

    @DataProvider(name = "provider")
    public Object[][] provider() {
        return urls;
    }

    @Test(dataProvider = "provider")
    public void openSite(String url) {
        RunResult runResult = new RunResult(url);
        WebDriver driver = null;
        try {
            driver = firefox();
            DateTime startTime = new DateTime();
            driver.get(runResult.getUrl());
            waitForLoad(driver);
            DateTime endTime = new DateTime();

            runResult.setStartTime(startTime);
            runResult.setEndTime(endTime);
        } catch (Throwable ignored) {
            String errorMessage = "Ошибка при открытии: " + runResult.getUrl();
            runResult.setErrorMessage(errorMessage);
        }

        runResultList.add(runResult);
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

    @AfterSuite
    public void writeResultsToFile() {
        Utils.writeToFile(runResultList);
    }

    private static boolean waitForLoad(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        return webDriverWait.until(isPageReloaded());
    }

    private static ExpectedCondition<Boolean> isPageReloaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return $.active==0");
            }
        };
    }

    protected WebDriver firefox() throws MalformedURLException {
        final FirefoxProfile profile;
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        profile = new FirefoxProfile();
        profile.setPreference("dom.max_chrome_script_run_time", 999);
        profile.setPreference("dom.max_script_run_time", 999);
        profile.setPreference("network.cookie.cookieBehavior", 0);
        profile.setPreference("dom.ipc.plugins.enabled", false);
        profile.setPreference("browser.cache.disk.enable", false);
        profile.setPreference("browser.cache.memory.enable", false);
        profile.setPreference("browser.cache.offline.enable", false);
        profile.setPreference("network.http.use-cache", false);

        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        return new RemoteWebDriver(new URL(SELENIUM_SETTINGS.getGridHubUrl()), capabilities);
    }
}

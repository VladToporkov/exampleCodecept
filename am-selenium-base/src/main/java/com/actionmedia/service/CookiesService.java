package com.actionmedia.service;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.actionmedia.autotest.selenium.SeleniumHolder.getWebDriver;

@Service
public class CookiesService {

    private final Log logger = LogFactory.getLog(getClass());

    public void deleteAllCookies() {
        WebDriver driver = getWebDriver();
        if (driver != null) {
            driver.manage().deleteAllCookies();
//            try {
//                driver.manage().deleteAllCookies();
//            } catch (NoSuchWindowException e) {
//                logger.error("Exception occurs", e);
//                trySwitchToMainWindowAndDeleteAllCookies();
//            } catch (UnreachableBrowserException ignored) {
//                logger.error("UnreachableBrowserException occurs", ignored);
//                trySwitchToMainWindowAndDeleteAllCookies();
//            }
        }
    }

    private void trySwitchToMainWindowAndDeleteAllCookies() {
//        switchToMainWindow();
        getWebDriver().manage().deleteAllCookies();
//        try {
//            getWebDriver().manage().deleteAllCookies();
//        } catch (Exception e) {
//            logger.error("Exception occurs", e);
//        }
    }

    private void switchToMainWindow() {
        final WebDriver driver = getWebDriver();
        if (driver != null) {
            final Set<String> windowHandlers = driver.getWindowHandles();
            if (!windowHandlers.isEmpty()) {
                driver.switchTo().window(windowHandlers.iterator().next());
            }
        }
    }
}

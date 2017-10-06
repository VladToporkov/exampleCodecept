package com.actionmedia.autotest;

import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.elements.EnabledElement;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static com.actionmedia.autotest.ExpectedConditions2.*;
import static com.actionmedia.autotest.ExpectedConditions2.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WebDriverAwareElementFinder implements ElementFinder {
    public static final int INVOCATION_COUNT = 5;
    private WebDriver driver;
    private WebDriverWait wait;
    private final Log logger = LogFactory.getLog(getClass());

    public WebDriverAwareElementFinder(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        this.driver = webDriver;
        this.wait = webDriverWait;
    }

    @Override
    public WebElement findElementBy(final By locator) {
        return driver.findElement(locator);
    }

    @Override
    public WebElement findElementBy(final SearchContext searchContext, final By locator) {
        return searchContext.findElement(locator);
    }

    @Override
    public List<WebElement> findElementsBy(final By locator) {
        return driver.findElements(locator);
    }

    @Override
    public List<WebElement> findElementsBy(final SearchContext searchContext, final By locator) {
        return searchContext.findElements(locator);
    }

    @Override
    public Boolean waitForTextToBePresentInElement(final By locator, final String text) {
        return waitFor(ExpectedConditions.textToBePresentInElement(locator, text));
    }

    @Override
    public WebElement waitForPresenceOfElementLocatedBy(final By locator) {
        return waitFor(presenceOfElementLocated(locator));
    }

    private boolean isElementStale(WebElement element) {
        try {
            element.getTagName();
            return false;
        } catch (StaleElementReferenceException e) {
            logger.error("StaleElementReferenceException occurs", e);
            return true;
        }
    }

    @Override
    public WebElement waitForPresenceOfElementLocatedBy(final By locator, long timeout) {
        return waitFor(presenceOfElementLocated(locator), timeout);
    }

    @Override
    public WebElement waitForVisibilityOfElementLocatedBy(final By locator) {
        return waitFor(visibilityOfElementLocated(locator));
    }

    @Override
    public EnabledElement waitForElementToBeEnable(EnabledElement element) {
        return waitFor(ExpectedConditions2.enablingOfElement(element));
    }

    @Override
    public WebElement waitForElementToBeEnable(final By locator) {
        return waitFor(ExpectedConditions2.enablingOfElementLocated(locator));
    }

    @Override
    public WebElement waitForElementToBeClickable(final By locator) {
        return waitFor(elementToBeClickable(locator));
    }

    @Override
    public List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By locator) {
        waitFor(ExpectedConditions2.presenceOfAllElementsLocatedBy(locator));
        return findElementsBy(locator);
    }

    @Override
    public List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By locator, long timeoutInSec) {
        waitFor(ExpectedConditions2.presenceOfAllElementsLocatedBy(locator), timeoutInSec);
        return findElementsBy(locator);
    }

    @Override
    public boolean elementExists(final By locator) {
        return !findElementsBy(locator).isEmpty();
    }

    @Override
    public boolean isTextPresentInElement(final By locator, final String text) {
        return ExpectedConditions.textToBePresentInElement(locator, text).apply(driver);
    }

    @Override
    public Boolean waitForStalenessOf(final WebElement webElement) {
        return waitFor(stalenessOf(webElement));
    }

    @Override
    public void waitForWindowToBeAppearedAndSwitchToIt(final String title) {
        final String windowHandle = waitFor(appearingOfWindow(title));
        driver.switchTo().window(windowHandle);

    }

    @Override
    public void waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(final String fullTitle) {
        final String windowHandle = waitFor(appearingOfWindowByPartialTitle(fullTitle));
        driver.switchTo().window(windowHandle);
    }

    @Override
    public void waitForNewPopUpWindowAndSwitchToIt(WebElement webElement) {
        final Set<String> currentWindowHandles = driver.getWindowHandles();
        webElement.click();
        final String windowHandle = waitFor(appearingOfWindowWithNewTitle(currentWindowHandles));
        driver.switchTo().window(windowHandle);
    }

    @Override
    public void closeCurrentBrowserWindow() {
        driver.close();
    }

    @Override
    public void waitForWindowToBeAppearedByUrlAndSwitchToIt(final String url) {
        final String windowHandle = waitFor(appearingOfWindowByUrl(url));
        driver.switchTo().window(windowHandle);
    }

    @Override
    public void waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(final String url) {
        final String windowHandle = waitFor(appearingOfWindowByPartialUrl(url));
        driver.switchTo().window(windowHandle);
    }

    @Override
    public Boolean waitForTextToBePresentIn(final WebElement element, final String text) {
        return waitFor(textToBePresentInElement(element, text));
    }

    @Override
    public Boolean waitForTextToBePresentIn(WebElement element) {
        return waitFor(textToBePresentInElement(element));
    }

    @Override
    public void waitForPresenceOf(final WebElement element) {
        waitFor(ExpectedConditions2.presenceOf(element));
    }

    @Override
    public WebElement waitForInvisibilityOfElementLocatedBy(final By locator) {
        return waitFor(ExpectedConditions2.invisibleOf(locator));
    }

    @Override
    public WebElement waitForInvisibilityOfElementLocatedBy(final WebElement element) {
        return waitFor(ExpectedConditions2.invisibleOf(element));
    }

    @Override
    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(final By locator) {
        return waitFor(ExpectedConditions2.visibilityOfAllElementsLocatedBy(locator));
    }

    @Override
    public void waitForPresenceOf(final Element element) {
        waitFor(ExpectedConditions2.presenceOf(element));
    }

    private <T> T waitFor(final ExpectedCondition<T> condition) {
        return wait.until(condition);
    }

    private <T> T waitFor(final ExpectedCondition<T> condition, final long timeout) {
        WebDriverWait customWait = new WebDriverWait(driver, timeout);
        return customWait.until(condition);
    }

    @Override
    public void setTimeout(final long timeout) {
        wait = new WebDriverWait(driver, timeout);
    }

    @Override
    public void waitForReloadingPage() {
        waitFor(ExpectedConditions2.isPageReloaded());
    }
}

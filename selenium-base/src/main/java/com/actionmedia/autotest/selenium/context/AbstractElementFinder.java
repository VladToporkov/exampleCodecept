package com.actionmedia.autotest.selenium.context;

import com.actionmedia.autotest.ElementFinder;
import com.actionmedia.autotest.WebDriverAwareElementFinder;
import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.elements.EnabledElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

import static com.actionmedia.autotest.selenium.elements.upgrade.OurWebElementImpl.wrap;

public class AbstractElementFinder {

    private final Log logger = LogFactory.getLog(getClass());

    private ElementFinder elementFinder;

    public void init(final WebDriver driver, Long timeout) {
        elementFinder = new WebDriverAwareElementFinder(driver, new WebDriverWait(driver, timeout));
    }

    protected final WebElement findElementBy(final By locator) {
        return wrap(elementFinder.findElementBy(locator), locator);
    }

    protected final WebElement findElementBy(final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.findElementBy(locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    public final WebElement findElementByNoThrow(final By locator) {
        try {
            return wrap(elementFinder.findElementBy(locator), locator);
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected final WebElement findElementByNoThrow(final SearchContext searchContext, final By locator) {
        try {
            return wrap(elementFinder.findElementBy(searchContext, locator), locator);
        } catch (Exception e) {
            return null;
        }
    }

    protected final WebElement findElementBy(final SearchContext searchContext, final By locator) {
        return wrap(elementFinder.findElementBy(searchContext, locator), locator);
    }

    protected final WebElement findElementBy(final SearchContext searchContext, final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.findElementBy(searchContext, locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final List<WebElement> findElementsBy(final By locator) {
        return wrap(elementFinder.findElementsBy(locator), locator);
    }

    protected final List<WebElement> findElementsBy(final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.findElementsBy(locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    public final List<WebElement> findElementsByNoThrow(final By locator) {
        try {
            return findElementsBy(locator);
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected final List<WebElement> findElementsByNoThrow(final SearchContext searchContext, final By locator) {
        try {
            return findElementsBy(searchContext, locator);
        } catch (WebDriverException e) {
            return null;
        }
    }

    protected final List<WebElement> findElementsBy(final SearchContext searchContext, final By locator) {
        return wrap(elementFinder.findElementsBy(searchContext, locator), locator);
    }

    public WebElement waitForPresenceOfElementLocatedBy(final By locator) {
        return wrap(elementFinder.waitForPresenceOfElementLocatedBy(locator), locator);
    }

    public final WebElement waitForPresenceOfElementLocatedBy(final By locator, long timeout) {
        return wrap(elementFinder.waitForPresenceOfElementLocatedBy(locator, timeout), locator);
    }

    protected final WebElement waitForPresenceOfElementLocatedBy(final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.waitForPresenceOfElementLocatedBy(locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final WebElement waitForVisibilityOfElementLocatedBy(final By locator) {
        return wrap(elementFinder.waitForVisibilityOfElementLocatedBy(locator), locator);
    }

    protected final WebElement waitForVisibilityOfElementLocatedBy(final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.waitForVisibilityOfElementLocatedBy(locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
            return null;
        }
    }

    protected final WebElement waitForInvisibilityOfElementLocatedBy(final By locator) {
        return wrap(elementFinder.waitForInvisibilityOfElementLocatedBy(locator), locator);
    }

    protected final WebElement waitForInvisibilityOfElementLocatedBy(final WebElement element) {
        return elementFinder.waitForInvisibilityOfElementLocatedBy(element);
    }

    public final List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By locator) {
        return wrap(elementFinder.waitForPresenceOfAllElementsLocatedBy(locator), locator);
    }

    public final List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By locator, long timeoutInSec) {
        return wrap(elementFinder.waitForPresenceOfAllElementsLocatedBy(locator, timeoutInSec), locator);
    }

    protected final List<WebElement> waitForPresenceOfAllElementsLocatedBy(final By locator, String errorMessage) {
        try {
            return waitForPresenceOfAllElementsLocatedBy(locator);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final List<WebElement> waitForVisibilityOfAllElementsLocatedBy(final By locator) {
        return wrap(elementFinder.waitForVisibilityOfAllElementsLocatedBy(locator), locator);
    }

    protected final List<WebElement> waitForVisibilityOfAllElementsLocatedBy(final By locator, String errorMessage) {
        try {
            return waitForVisibilityOfAllElementsLocatedBy(locator);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final WebElement waitForElementToBeClickable(final By locator) {
        return wrap(elementFinder.waitForElementToBeClickable(locator), locator);
    }

    protected final WebElement waitForElementToBeClickable(final By locator, final String errorMessage) {
        try {
            return wrap(elementFinder.waitForElementToBeClickable(locator), locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final EnabledElement waitForElementToBeEnabled(final EnabledElement element) {
        return elementFinder.waitForElementToBeEnable(element);
    }

    protected final WebElement waitForElementToBeEnabled(final By locator) {
        return wrap(elementFinder.waitForElementToBeEnable(locator), locator);
    }

    protected final WebElement waitForElementToBeEnabled(final By locator, final String errorMessage) {
        try {
            return waitForElementToBeEnabled(locator);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
        return null;
    }

    protected final Boolean waitForTextToBePresentInElement(final By locator, final String text) {
        return elementFinder.waitForTextToBePresentInElement(locator, text);
    }

    protected final void waitForWindowToBeAppearedAndSwitchToIt(final String title) {
        elementFinder.waitForWindowToBeAppearedAndSwitchToIt(title);
    }

    protected final void waitForWindowToBeAppearedAndSwitchToIt(final String title, String errorMessage) {
        try {
            elementFinder.waitForWindowToBeAppearedAndSwitchToIt(title);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
    }

    protected final void waitForWindowToBeAppearedByUrlAndSwitchToIt(final String url) {
        elementFinder.waitForWindowToBeAppearedByUrlAndSwitchToIt(url);
    }

    protected final void waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(final String url) {
        elementFinder.waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(url);
    }

    protected final void waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(final String url, String errorMessage) {
        try {
            elementFinder.waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(url);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
    }

    protected final void waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(final String fullTitle, String errorMessage) {
        try {
            elementFinder.waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(fullTitle);
        } catch (WebDriverException e) {
            fail(errorMessage);
        }
    }

    protected final void waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(final String fullTitle) {
        elementFinder.waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(fullTitle);
    }

    protected final void clickButtonAndWaitForNewPopUpWindowAndSwitchToIt(WebElement webElement) {
        elementFinder.waitForNewPopUpWindowAndSwitchToIt(webElement);
    }

    protected final void closeBrowserWindow() {
        elementFinder.closeCurrentBrowserWindow();
    }

    protected final boolean isTextPresentInElement(final By locator, final String text) {
        return elementFinder.isTextPresentInElement(locator, text);
    }

    protected final boolean elementExists(final By locator) {
        return elementFinder.elementExists(locator);
    }

    protected final void waitForPresenceOf(final WebElement element) {
        elementFinder.waitForPresenceOf(element);
    }

    protected final void waitForPresenceOf(final Element element) {
        elementFinder.waitForPresenceOf(element);
    }

    protected final void waitForPresenceOf(final WebElement element, final String errorMessage) {
        try {
            waitForPresenceOf(element);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
    }

    protected final void waitForPresenceOf(final Element element, final String errorMessage) {
        try {
            waitForPresenceOf(element);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
    }

    protected final Boolean waitForTextToBePresentIn(final WebElement element, final String text) {
        return elementFinder.waitForTextToBePresentIn(element, text);
    }

    protected final Boolean waitForTextToBePresentIn(final WebElement element) {
        return elementFinder.waitForTextToBePresentIn(element);
    }

    protected final void waitForTextToBePresentInWithErrorMessage(final WebElement element, final String errorMessage) {
        try {
            elementFinder.waitForTextToBePresentIn(element);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
    }

    protected final Boolean waitForStalenessOf(final WebElement webElement) {
        try {
            return elementFinder.waitForStalenessOf(webElement);
        } catch (UnreachableBrowserException e) {
            return true;
        }
    }

    protected final Boolean waitForStalenessOf(final WebElement webElement, String errorMessage) {
        try {
            return waitForStalenessOf(webElement);
        } catch (TimeoutException e) {
            fail(errorMessage);
        }
        return false;
    }

    public static void fail(final String errorMessage) {
        Reporter.log(getErrMsg(errorMessage));
        throw new AssertionError(removeTags(errorMessage));
    }

    protected final void fail(final String errorMessage, Throwable cause) {
        Reporter.log(getErrMsg(errorMessage) + cause.getMessage());
        throw new Error(removeTags(errorMessage) + cause.getMessage(), cause);
    }

    protected final void setTimeout(final long timeout) {
        elementFinder.setTimeout(timeout);
    }

    private static String getErrMsg(String errMsg) {
        if (errMsg.contains("font")) {
            return errMsg;
        } else {
            return "ERROR: " + errMsg;
        }
    }

    private static String removeTags(String errMsg) {
        String[] errMsgArr = errMsg.split("expected");
        if (errMsgArr.length > 1) {
            return errMsgArr[0].replaceAll("<.*?>", "") + "expected" + errMsgArr[1];
        } else {
            return errMsgArr[0];
        }
    }

    protected boolean isElementFromListDisplayed(List<WebElement> elementList) {
        for (WebElement element : elementList) {
            if (element.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}

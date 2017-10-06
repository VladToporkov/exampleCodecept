package com.actionmedia.autotest.selenium.context;

import com.actionmedia.autotest.event.postpone.failure.PostponedFailureEvent;
import com.actionmedia.autotest.selenium.ParamsProvider;
import com.actionmedia.autotest.selenium.ReportAnnotationsWrapperCreator;
import com.actionmedia.autotest.selenium.elements.WebElementWrapper;
import com.actionmedia.autotest.selenium.ext.ExtendedFieldDecorator;
import com.actionmedia.autotest.selenium.ext.internal.DefaultElementFactory;
import com.actionmedia.autotest.spring.SeleniumSettings;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Step;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.actionmedia.autotest.selenium.elements.upgrade.OurWebElementImpl.wrapParent;


public abstract class AbstractPageElement<P extends AbstractPageElement> extends AbstractElementFinder implements IPageElement, ErrorSender {

    private final Log logger = LogFactory.getLog(getClass());

    public static final int TIMEOUT = 5;
    private WebDriver driver;

    @Autowired
    private HelperRegistry registry;

    @Autowired
    private ParamsProvider parameterProvider;

    @Autowired
    private ParamsProvider parameterProviderForGroup;

    @Autowired
    private PostponedFailureEvent postponeFailureEvent;

    @Autowired
    private Long timeout;

    @Autowired
    private SeleniumSettings settings;

    private DefaultElementFactory elementFactory;

    public WebDriver getDriver() {
        return driver;
    }

    public HelperRegistry getRegistry() {
        return registry;
    }

    /**
     * Method is called by framework to complete navigation to the helper.
     * It is the best place to execute your wait-expressions to ensure that page has been completely loaded.
     */
    public void handleRedirect() {
    }

    public ParamsProvider getParameterProviderForGroup() {
        return parameterProviderForGroup;
    }

    public final void init(final WebDriver driver) {
        super.init(driver, timeout);
        this.driver = driver;
        elementFactory = new DefaultElementFactory();
        initFindByAnnotations(this);
        init();
    }

    protected Long getTimeout() {
        return timeout;
    }

    protected SeleniumSettings getSettings() {
        return settings;
    }

    protected void init() {
    }

    protected final <E> E initFindByAnnotations(final E abstractPageElement) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver, elementFactory, this), abstractPageElement);
        return abstractPageElement;
    }

    protected final <E extends IPage> E redirectTo(final Class<E> target) {
        waitForReloadingPage();
        final E page = getHelper(target);
        page.handleRedirect();
        return page;
    }

    protected final <E extends IPage> E redirectToWithoutWait(final Class<E> target) {
        final E page = getHelper(target);
        page.handleRedirect();
        return page;
    }

    protected Boolean waitForReloadingPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        try {
            return webDriverWait.until(isPageReloaded());
        } catch (TimeoutException e) {
            try {
                return webDriverWait.until(isPageReloaded());
            } catch (TimeoutException e1) {
                return getReloadingErrorReport();
            }
        } catch (WebDriverException e) {
            return getReloadingErrorReport();
        }
    }

    private Boolean getReloadingErrorReport() {
        if ((Boolean) executeScript("return $.active==1")) {
            return true;
        } else {
            fail("Страница не открылась в течении " + timeout + " секунд. Урл документа: " + getCurrentUrl());
            return false;
        }
    }

    private ExpectedCondition<Boolean> isElementAbsent(final By by) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return findElementByNoThrow(by) == null;
            }
        };
    }

    private ExpectedCondition<Boolean> isPageReloaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {
                    waitFewSecond(5000);
                    return executeScript("return document.readyState").equals("complete");
//                    } else {
//                        return (Boolean) executeScript("return $.active==0");
//                    }
                } catch (TimeoutException e) {
                    logger.info("TimeoutException occurs");
                    return false;
                } catch (UnreachableBrowserException e) {
                    logger.info("UnreachableBrowserException occurs");
                    return false;
                } catch (WebDriverException e) {
                    logger.info("WebDriverException occurs");
                    return false;
                }
            }
        };
    }

    protected Boolean waitForDocumentReloaded(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isDocumentLoaded(element));
    }

    private ExpectedCondition<Boolean> isDocumentLoaded(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return !element.getAttribute("class").contains("empty");
            }
        };
    }

    protected Boolean waitForAttributeUpdate(WebElement element, String value) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isAttributeUpdate(element, value));
    }

    protected Boolean waitForAttributeUpdate(WebElement element, String value, long timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isAttributeUpdate(element, value));
    }

    protected Boolean waitForAttributeUpdate(WebElement element, String attributeName, String value) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isAttributeUpdate(element, attributeName, value));
    }

    protected Boolean waitForAttributeUpdate(WebElement element, String attributeName, String value, boolean isAbsent) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isAttributeUpdate(element, attributeName, value, isAbsent));
    }

    protected Boolean waitForAttributeUpdate(WebElement element, String attributeName, String value, long timeout, boolean isAbsent) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(isAttributeUpdate(element, attributeName, value, isAbsent));
    }

    private ExpectedCondition<Boolean> waitImageLoaded(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return isImageLoaded(element);
            }
        };
    }

    private ExpectedCondition<Boolean> isAttributeUpdate(final WebElement element, final String value) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return element.getAttribute("class").contains(value);
            }
        };
    }

    private ExpectedCondition<Boolean> isAttributeUpdate(final WebElement element, final String attributeName, final String value, final boolean isAbsent) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                if (isAbsent) {
                    return !element.getAttribute(attributeName).contains(value);
                } else {
                    return element.getAttribute(attributeName).contains(value);
                }
            }
        };
    }

    private ExpectedCondition<Boolean> isAttributeUpdate(final WebElement element, final String attributeName, final String value) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                return element.getAttribute(attributeName).contains(value);
            }
        };
    }

    protected final <E extends IPage> E getHelper(final Class<E> target) {
        final E helper = getRegistry().getPageHelper(target);
        helper.init(getDriver());
        return ReportAnnotationsWrapperCreator.getReportingProxy(target, helper);
    }

    protected final <E extends IComponent> E getComponent(final Class<E> target) {
        final E helper = getRegistry().getBean(target);
        helper.init(getDriver());
        return ReportAnnotationsWrapperCreator.getReportingProxy(target, helper);
    }

    protected final <E extends IPage> E navigateTo(final Class<E> target, final String url) {
        getDriver().get(url);
        return redirectTo(target);
    }

    protected final <E extends IPage> E navigateTo(final Class<E> target) {
        getDriver().get(getSettings().createUrl());
        return redirectTo(target);
    }

    protected final <E extends IComponent> E redirectTo(final Class<E> target, final ComponentProvider componentProvider) {
        final E component = getHelper(target, componentProvider);
        component.handleRedirect();
        return component;
    }

    protected final <E extends IComponent> E getHelper(final Class<E> target, final ComponentProvider componentProvider) {
        final E helper = getRegistry().getComponentHelper(target);
        helper.init(getDriver());
        helper.setComponentProvider(componentProvider);
        return helper;
    }

    protected final String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void openUrl(String url) {
        openUrl(url, false);
    }

    protected void openUrl(String url, boolean isWaitForReloading) {
        driver.navigate().to(url);
        if (isWaitForReloading) {
            waitForReloadingPage();
        }
    }

    public P refreshPage() {
        driver.navigate().refresh();
        waitForReloadingPage();
        return (P) this;
    }

    public P returnToBack() {
        driver.navigate().back();
        waitForReloadingPage();
        return (P) this;
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    protected void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    protected void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or window.
     *
     * @param script - The JavaScript to execute
     * @param args   - The arguments to the script. May be empty
     * @return Boolean, Long, String, List or WebElement. Or null.
     */
    protected final Object executeScript(final String script, final Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    /**
     * Check if image loaded
     *
     * @param image - image element
     * @return true if image loaded correctly
     */
    protected final boolean isImageLoaded(final WebElement image) {
        final Boolean loaded = (Boolean) executeScript("return arguments[0].complete", image);
        final Long naturalWidth = (Long) executeScript("return arguments[0].naturalWidth", image);

        return !(loaded == null || !loaded || naturalWidth == null || naturalWidth.equals(Long.valueOf(0)));
    }

    public WebElement getParentElement(final WebElement webElement) {
        return wrapParent(webElement);
    }

    protected WebElementWrapper getWebElementWrapper(final WebElement wrappedElement) {
        return new WebElementWrapper(wrappedElement);
    }

    protected void waitForImageLoadedWithErrorMessage(WebElement image, String errorMessage) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, timeout);
            customWait.until(waitImageLoaded(image));
        } catch (TimeoutException e) {
            setPostponedTestFail(errorMessage);
        }
    }

    protected <T> void assertThat(T actual, Matcher<? super T> matcher, String errorMessage) {
        try {
            MatcherAssert.assertThat(actual, matcher);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(getErrorMessage(errorMessage) + ((!((List<WebElement>) actual).isEmpty() && ((List<WebElement>) actual).get(0) instanceof WebElement) ? getTextFromWebElementList((List<WebElement>) actual) : actual));
        }
    }

    protected <T> void postponedAssertThat(T actual, Matcher<? super T> matcher, String errorMessage) {
        try {
            MatcherAssert.assertThat(actual, matcher);
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            setPostponedTestFail(getErrorMessage(errorMessage) + ((!((List<WebElement>) actual).isEmpty() && ((List<WebElement>) actual).get(0) instanceof WebElement) ? getTextFromWebElementList((List<WebElement>) actual) : actual));
        }
    }

    protected void clearParameter(final String key) {
        parameterProvider.remove(key);
    }

    protected void setParameter(final String key, final Object value) {
        parameterProvider.put(key, value);
    }

    protected Object getParameter(final String key) {
        return parameterProvider.get(key);
    }

    protected final Object getParameterForGroup(final String key) {
        return parameterProviderForGroup.get(key);
    }

    protected void setParameterForGroup(final String key, final Object value) {
        parameterProviderForGroup.put(key, value);
    }

    public void setPostponedTestFail(final String message) {
        if (message.contains("ERROR")) {
            postponeFailureEvent.fire(message);
        } else {
            postponeFailureEvent.fire(getErrorMessage(message));
        }
    }

    public void setPostponedTestFailWithoutScreen(final String message) {
        if (message.contains("ERROR")) {
            postponeFailureEvent.fireWithoutScreen(message);
        } else {
            postponeFailureEvent.fireWithoutScreen(getErrorMessage(message));
        }
    }

    @Step("{0}")
    public P report(final String message) {
        Reporter.log(message);
        return (P) this;
    }

    @Step("{0}")
    public P error(final String message) {
        Reporter.log("ERROR: " + message);
        return (P) this;
    }

    @Step("{0}")
    public P warning(final String message) {
        Reporter.log("Warning: " + message);
        return (P) this;
    }

    @Step("{0}")
    public P success(final String message) {
        Reporter.log("SUCCESS: " + message);
        return (P) this;
    }

    public ErrorSender getErrorSender() {
        return this;
    }

    protected void clickRandomElementInList(final List<WebElement> list) {
        getRandomElementInList(list).click();
    }

    public <T> T getRandomElementInList(final List<T> list) {
        if (!list.isEmpty()) {
            return getRandomElementsInList(list, 1).get(0);
        }
        fail("List is null or empty! It's impossible to get random element!");
        return null;
    }

    /**
     * Открыть url в новом окне
     * @param url - url страницы
     */
    public void openInNewWindow(String url) {
        executeScript("window.open(arguments[0])", url);
        waitForWindowToBeAppearedByUrlAndSwitchToIt(url);
    }

    protected <T> List<T> getRandomElementsInList(final List<T> sourceList, final int itemNumberToSelect) {
        final ArrayList<T> resultArray = new ArrayList<T>(sourceList.size());
        resultArray.addAll(sourceList);
        Collections.shuffle(resultArray);

        if (sourceList.size() <= itemNumberToSelect) {
            return resultArray;
        }

        return resultArray.subList(0, itemNumberToSelect);
    }

    public List<String> getTextFromWebElementList(final List<WebElement> webElementList) {
        final List<String> resultList = new ArrayList<String>();
        for (WebElement eachElement : webElementList) {
            resultList.add(eachElement.getText());
        }
        return resultList;
    }

    protected List<String> getTextFromWebElementListWithoutSpaces(final List<WebElement> webElementList) {
        final List<String> resultList = new ArrayList<String>();
        for (WebElement eachElement : webElementList) {
            resultList.add(eachElement.getText().trim());
        }
        return resultList;
    }

    protected void assertNotNull(Object object, String errorMessage) {
        try {
            Assert.assertNotNull(object, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertWebElementIsAbsent(By by, String errorMessage) {
        assertNull(getElementByNoThrow(by), getErrorMessage(errorMessage));
    }

    private WebElement getElementByNoThrow(By by) {
        try {
            return waitForPresenceOfElementLocatedBy(by, TIMEOUT);
        } catch (TimeoutException e) {
            logger.error("TimeoutException occurs", e);
            return null;
        }
    }

    protected void assertWebElementIsPresent(By by, String errorMessage) {
        assertNotNull(getElementByNoThrow(by), getErrorMessage(errorMessage));
    }

    protected void assertNull(Object object, String errorMessage) {
        try {
            Assert.assertNull(object, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    public void assertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertEquals(actual, expected, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertNotEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertNotEquals(actual, expected, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void assertContains(String actual, String expected, String errorMessage) {
        try {
            Assert.assertTrue(expected.contains(actual), getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.error("AssertionError occurs", e);
            fail(e.getMessage());
        }
    }

    protected void postponedAssertNotNull(Object object, String errorMessage) {
        try {
            Assert.assertNotNull(object, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertNull(Object object, String errorMessage) {
        try {
            Assert.assertNull(object, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertTrue(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertFalse(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void postponedAssertFalseWithoutScreen(boolean condition, String errorMessage) {
        try {
            Assert.assertFalse(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFailWithoutScreen(e.getMessage());
        }
    }

    protected void postponedAssertTrueWithoutScreen(boolean condition, String errorMessage) {
        try {
            Assert.assertTrue(condition, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFailWithoutScreen(e.getMessage());
        }
    }

    public void postponedAssertEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertEquals(actual, expected, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    public void postponedAssertEqualsText(WebElement elementWithText, Object expected) {
        String errorMessage;
        try {
            errorMessage = "Не соответсвует текст: " + elementWithText.getText() + " Ожидалось: " + expected;
            Assert.assertEquals(elementWithText.getText().trim(), expected, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        } catch (NullPointerException npe) {
            logger.info("NullPointerException occurs");
            setPostponedTestFail(npe.getMessage());
        }
    }

    public void postponedAssertNotEquals(Object actual, Object expected, String errorMessage) {
        try {
            Assert.assertNotEquals(actual, expected, getErrorMessage(errorMessage));
        } catch (AssertionError e) {
            logger.info("AssertionError occurs");
            setPostponedTestFail(e.getMessage());
        }
    }

    protected void clickOkButtonInConfirm() {
        try {
            Alert alert = waitForAlertPresence();
            alert.accept();
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        }
    }

    protected void clickCancelButtonInConfirm() {
        try {
            Alert alert = waitForAlertPresence();
            alert.dismiss();
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        }
    }

    protected void checkConfirmText(String confirmText) {
        assertEquals(waitForAlertPresence().getText(), confirmText, "Alert text is incorrect.");
    }

    protected void clickOkButtonInConfirm(int timeoutForConfirm) {
        try {
            Alert alert = waitForAlertPresence(timeoutForConfirm);
            alert.accept();
        } catch (Exception e) {
            logger.error("Exception occurs", e);
        }
    }

    protected Alert waitForAlertPresence() {
        return (new WebDriverWait(driver, timeout)).until(ExpectedConditions.alertIsPresent());
    }

    protected Alert waitForAlertPresence(int timeoutForAlert) {
        return (new WebDriverWait(driver, timeoutForAlert)).until(ExpectedConditions.alertIsPresent());
    }

    protected void waitFewSecond(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            logger.error("InterruptedException occurs", e);
        }
    }

    private String getErrorMessage(String errMsg) {
        return "ERROR: " + errMsg;
    }
}

package com.actionmedia.autotest.selenium.elements.upgrade;

import com.actionmedia.autotest.ElementFinder;
import com.actionmedia.autotest.WebDriverAwareElementFinder;
import com.actionmedia.autotest.selenium.SeleniumHolder;
import com.actionmedia.autotest.selenium.context.AbstractElementFinder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;


/**
 * User: n.tyukavkin
 * Date: 07.02.2015
 * Time: 15:41
 */
public class OurWebElementImpl implements OurWebElement, Locatable {

    public WebElement wrappedElement;
    private Locator locator;
    private ElementFinder elementFinder;
    public static final Logger LOGGER = LoggerFactory.getLogger(OurWebElementImpl.class);
    //The duration in milliseconds to sleep between polls. (default value in selenium is 500)
    private static final long SLEEP_IN_MILLISECONDS = 1000;
    private static final long WAIT_TIME_OUT_IN_SECONDS = 5;
    private int repeatLocateElementCounter;
    private static final int MAX_NUMBER_OF_REPEAT_LOCATE_ELEMENT = 20;


    public void init(final WebDriver driver, Long timeout) {
        elementFinder = new WebDriverAwareElementFinder(driver, new WebDriverWait(driver, timeout, SLEEP_IN_MILLISECONDS));
    }

    public static WebElement wrap(WebElement element, Locator locator) {
        return new OurWebElementImpl(element, locator);
    }

    public static WebElement wrap(WebElement element, By by) {
        return new OurWebElementImpl(element, new FindElementLocator(getDriver(), by));
    }

    public static WebElement wrapParent(WebElement element) {
        OurWebElement ourWebElement = (OurWebElement) element;
        return new OurWebElementImpl(getParentElement(ourWebElement.getWrappedWebElement()), new FindParentElementLocator(getDriver(), ourWebElement.getLocator().getByLocator()));
    }

    private static WebElement getParentElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].parentNode", element);
    }

    public static List<WebElement> wrap(List<WebElement> elements, SearchContext searchContext, By by) {
        List<WebElement> result = new ArrayList<WebElement>(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            result.add(wrap(element, new FindElementsLocator(searchContext, by, i)));
        }
        return result;
    }

    public static List<WebElement> wrap(List<WebElement> elements, By by) {
        List<WebElement> result = new ArrayList<WebElement>(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            result.add(wrap(element, new FindElementsLocator(getDriver(), by, i)));
        }
        return result;
    }

    public OurWebElementImpl(WebElement element, Locator locator) {
        this.wrappedElement = element instanceof OurWebElement ? ((OurWebElement) element).getWrappedWebElement() : element;
        this.locator = locator;
        this.repeatLocateElementCounter = 0;
        if (elementFinder == null) {
            init(getDriver(), WAIT_TIME_OUT_IN_SECONDS);
        }
    }

    @Override
    public WebElement getWrappedWebElement() {
        return wrappedElement;
    }

    @Override
    public void click() {
        try {
            try {
                if (isIE()) {
                    clickInIE();
                } else {
                    wrappedElement.click();
                    elementFinder.waitForReloadingPage();
                }
            } catch (StaleElementReferenceException e) {
                closePopup();
                againLocate();
                click();
            } catch (ElementNotVisibleException needToScroll) {
                LOGGER.error("*****ERROR*****ElementNotVisibleException***** during click! Scrolling to element and trying again ---Locator=" + locator.getByLocator());
                closePopup();
                increment();
                clickUseJS();
            } catch (InvalidElementStateException e) {
                closePopup();
                againLocate();
                click();
            } catch (TimeoutException ignored) {
            } catch (WebDriverException ignoredOrNeedToScroll) {
                LOGGER.error("*****ERROR*****WebDriverException ignoredOrNeedToScroll***** during click!-----Locator=" + locator.getByLocator());
                againLocate();
                clickUseJS();
            }
        } catch (Exception e) {
            LOGGER.error("*****FATAL ERROR*****Exception***** DURING CLICK LOGIC. SHOULD BE REFACTORED!!!! -----Locator=" + locator.getByLocator());
        }
    }

    @Override
    public void submit() {
        wrappedElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        wrappedElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        try {
            wrappedElement.clear();
        } catch (StaleElementReferenceException e) {
            againLocate();
            clear();
        } catch (InvalidElementStateException e) {
            againLocate();
            clear();
        }
    }

    @Override
    public String getTagName() {
        try {
            return wrappedElement.getTagName();
        } catch (StaleElementReferenceException e) {
            againLocate();
            return getTagName();
        } catch (InvalidElementStateException e) {
            againLocate();
            return getTagName();
        }
    }

    @Override
    public String getAttribute(String s) {
        try {
            return wrappedElement.getAttribute(s);
        } catch (StaleElementReferenceException e) {
            againLocate();
            return getAttribute(s);
        } catch (InvalidElementStateException e) {
            againLocate();
            return getAttribute(s);
        }
    }

    @Override
    public boolean isSelected() {
        try {
            return wrappedElement.isSelected();
        } catch (StaleElementReferenceException e) {
            againLocate();
            return isSelected();
        } catch (InvalidElementStateException e) {
            againLocate();
            return isSelected();
        }
    }

    @Override
    public boolean isEnabled() {
        return wrappedElement.isEnabled();
    }

    @Override
    public String getText() {
        try {
            return wrappedElement.getText();
        } catch (StaleElementReferenceException e) {
            againLocate();
            return getText();
        } catch (InvalidElementStateException e) {
            againLocate();
            return getText();
        }
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wrap(finds(by), this, by);
    }

    @Override
    public WebElement findElement(By by) {
        return wrap(find(by), new FindElementLocator(this, by));
    }

    @Override
    public boolean isDisplayed() {
        try {
            return wrappedElement.isDisplayed();
        } catch (StaleElementReferenceException e) {
            againLocate();
            return isDisplayed();
        } catch (InvalidElementStateException e) {
            againLocate();
            return isDisplayed();
        }
    }

    @Override
    public Point getLocation() {
        try {
            return wrappedElement.getLocation();
        } catch (StaleElementReferenceException e) {
            againLocate();
            return getLocation();
        }
    }

    @Override
    public Dimension getSize() {
        return wrappedElement.getSize();
    }

    @Override
    public String getCssValue(String s) {
        return wrappedElement.getCssValue(s);
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) getWrappedWebElement()).getCoordinates();
    }

    protected void againLocate() {
        wrappedElement = locator.locate();
        increment();
    }

    private void increment() {
        if (repeatLocateElementCounter > MAX_NUMBER_OF_REPEAT_LOCATE_ELEMENT) {
            AbstractElementFinder.fail("Cannot interact properly with element with locator '" + locator.getByLocator() + "'" + (!wrappedElement.isDisplayed() ? " Element was not displayed!" : ""));
        } else {
            repeatLocateElementCounter++;
        }
    }

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

    protected static WebDriver getDriver() {
        return SeleniumHolder.getWebDriver();
    }

    protected void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToElementLocation(WebElement element) {
        executeScript("scroll(" + (element.getLocation().getX() + element.getSize().getWidth()) + "," + element.getLocation().getY() + ");");
    }

    private Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    private void clickInIE() {
        waitFewSecond(1000);
//        wrappedElement.click();
        clickUseJS();
        elementFinder.waitForReloadingPage();
        waitFewSecond(1000);
    }

    @Override
    public Locator getLocator() {
        return locator;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && wrappedElement != null && wrappedElement.equals(o) ||
                this == o || o != null && wrappedElement != null && (o instanceof OurWebElementImpl) && wrappedElement.equals(((OurWebElementImpl) o).getWrappedElement());
    }

    @Override
    public int hashCode() {
        return wrappedElement != null ? wrappedElement.hashCode() : 0;
    }

    private boolean isIE() {
        return SeleniumHolder.getDriverName().equals("ie");
    }

    private void waitFewSecond(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException occurs", e);
        }
    }

    private void clickUseJS() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", wrappedElement);
        elementFinder.waitForReloadingPage();
    }

    private WebElement find(By by) {
        try {
            return wrappedElement.findElement(by);
        } catch (StaleElementReferenceException e) {
            againLocate();
            return wrappedElement.findElement(by);
        } catch (UndeclaredThrowableException e) {
            if (((InvocationTargetException) e.getUndeclaredThrowable()).getTargetException() instanceof NoSuchElementException) {
                return wrappedElement.findElement(by);
            }
            againLocate();
            return wrappedElement.findElement(by);
        }
    }

    private List<WebElement> finds(By by) {
        try {
            return wrappedElement.findElements(by);
        } catch (StaleElementReferenceException e) {
            againLocate();
            return wrappedElement.findElements(by);
        } catch (UndeclaredThrowableException e) {
            if (((InvocationTargetException) e.getUndeclaredThrowable()).getTargetException() instanceof NoSuchElementException) {
                return wrappedElement.findElements(by);
            }
            againLocate();
            return wrappedElement.findElements(by);
        }
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        if (getDriver().getClass() == RemoteWebDriver.class) {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            return ((TakesScreenshot) augmentedDriver).getScreenshotAs(outputType);
        } else {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(outputType);
        }
    }

    public Rectangle getRect(){
        return wrappedElement.getRect();
    }

    private void closePopup() {
        List<WebElement> popUpCloseList3 = elementFinder.findElementsBy(By.cssSelector("[title='Закрыть']"));
        for (WebElement popUpClose : popUpCloseList3) {
            if (popUpClose.isDisplayed()) {
                try {
                    popUpClose.click();
                } catch (WebDriverException ignored) {
                }
            }
        }
    }
}

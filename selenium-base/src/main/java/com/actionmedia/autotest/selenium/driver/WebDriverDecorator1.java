package com.actionmedia.autotest.selenium.driver;

import com.google.common.base.Function;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Collections2.transform;
import static java.lang.String.format;
import static org.testng.collections.Lists.newArrayList;

public class WebDriverDecorator1 extends WebDriverDecorator {

    private final Log logger = LogFactory.getLog(getClass());

    private final Function<WebElement, WebElement> toFrameAwareWebElements;
    private ThreadLocal<String> mainWindowHandle = new ThreadLocal<String>();

    public WebDriverDecorator1(final WebDriver driver) {
        super(driver);
        toFrameAwareWebElements = new FrameAwareWebElementTransformer1(driver);
        mainWindowHandle.set(driver.getWindowHandle());
    }

    @Override
    public String getCurrentUrl() {
        switchToDefaultContext();
        return getDriver().getCurrentUrl();
    }

    @Override
    public List<WebElement> findElements(final By by) {
        List<WebElement> found = driverFindElements(by);
        return newArrayList(transform(found, toFrameAwareWebElements));
    }

    @Override
    public WebElement findElement(final By by) {
        try {
            return findElements(by).get(0);
        } catch (IndexOutOfBoundsException e) {
            logger.info("IndexOutOfBoundsException occurs");
            throw new NoSuchElementException("Unable to locate element " + by + e);
        }
    }

    @Override
    public void close() {
        getDriver().close();
        switchToMainWindow();
    }

    @Override
    public TargetLocator switchTo() {
        return new FramesTransparentTargetLocator(getDriver().switchTo());
    }

    private List<WebElement> driverFindElements(By by) {
        try {
            return getDriver().findElements(by);
        } catch (NoSuchWindowException e) {
            logger.error("NoSuchWindowException occurs", e);
            //chrome driver throws this exception if current window is closed
            switchToMainWindow();
            try {
                return getDriver().findElements(by);
            } catch (Exception e1) {
                logger.error("Exception occurs", e1);
                return new ArrayList<WebElement>();
            }
        } catch (WebDriverException e) {
            logger.error("WebDriverException occurs", e);
            //this exception can be thrown if current frame is already detached.
            return new ArrayList<WebElement>();
        } catch (Exception e) {
            logger.error("Exception occurs", e);
            //In some cases IE driver can throw InvalidSelectorException or NullPointerException
            return new ArrayList<WebElement>();
        }
    }

    private void switchToDefaultContext() {
        try {
            getDriver().switchTo().defaultContent();
        } catch (WebDriverException e) {
            logger.error("WebDriverException occurs", e);
            switchToMainWindow();
            getDriver().switchTo().defaultContent();
        }
    }

    private void switchToMainWindow() {
        try {
            switchTo().window(mainWindowHandle.get());
        } catch (SwitchToWindowException e) {
            logger.error("SwitchToWindowException occurs", e);
            switchTo().window(getDriver().getWindowHandles().iterator().next());
        }
    }

    private static class FramesTransparentTargetLocator implements TargetLocator {
        private final TargetLocator targetLocator;

        public FramesTransparentTargetLocator(final TargetLocator targetLocator) {
            this.targetLocator = targetLocator;
        }

        @Override
        public WebDriver frame(final int index) {
            return this.targetLocator.frame(index);
        }

        @Override
        public WebDriver frame(final String nameOrId) {
            return this.targetLocator.frame(nameOrId);
        }

        @Override
        public WebDriver frame(final WebElement frameElement) {
            return this.targetLocator.frame(frameElement);
        }

        @Override
        public WebDriver parentFrame() {
            return this.targetLocator.parentFrame();
        }

        @Override
        public WebDriver window(final String nameOrHandle) {
            try {
                return targetLocator.window(nameOrHandle);
            } catch (NoSuchWindowException e) {
                throw new SwitchToWindowException(format("Unable switch to window by handler: '%s'", nameOrHandle), e);
            } catch (NullPointerException e) {
                throw new SwitchToWindowException("Unable to switch to window: handler is null", e);
            }
        }

        @Override
        public WebDriver defaultContent() {
            return targetLocator.defaultContent();
        }

        @Override
        public WebElement activeElement() {
            return targetLocator.activeElement();
        }

        @Override
        public Alert alert() {
            return targetLocator.alert();
        }
    }
}

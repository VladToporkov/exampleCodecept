package com.actionmedia.autotest;

import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.elements.EnabledElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public final class ExpectedConditions2 {

    /**
     * private constructor for utils class
     */
    private ExpectedConditions2() {
    }

    public static ExpectedCondition<Boolean> childrenElementsCount(final WebElement parent, final By locator, final int expectedChildrenCount) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return parent.findElements(locator).size() == expectedChildrenCount;
            }
        };
    }

    public static ExpectedCondition<Boolean> presenceOfAllElementsLocatedBy(final By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return !driver.findElements(locator).isEmpty();
            }
        };
    }

    public static ExpectedCondition<WebElement> enablingOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(final WebDriver driver) {
                return elementIfEnable(driver.findElement(locator));
            }
        };
    }

    private static WebElement elementIfEnable(final WebElement element) {
        return element.isEnabled() ? element : null;
    }

    private static WebElement elementIfInvisible(final WebElement element) {
        return !element.isDisplayed() ? element : null;
    }

    public static ExpectedCondition<String> appearingOfWindow(final String title) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                final String initialHandle = driver.getWindowHandle();
                for (final String each : driver.getWindowHandles()) {
                    driver.switchTo().window(each);
                    if (driver.getTitle().equals(title)) {
                        driver.switchTo().window(initialHandle);
                        return each;
                    }
                }
                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    public static ExpectedCondition<String> appearingOfWindowByPartialTitle(final String fullTitle) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                final String initialHandle = driver.getWindowHandle();
                for (final String each : driver.getWindowHandles()) {
                    driver.switchTo().window(each);
                    if (fullTitle.contains(driver.getTitle().split("\\(")[0].trim())) {
                        driver.switchTo().window(initialHandle);
                        return each;
                    }
                }
                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    public static ExpectedCondition<String> appearingOfWindowWithNewTitle(final Set<String> oldTitle) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                Set<String> windowHandles = driver.getWindowHandles();
                if (windowHandles.containsAll(oldTitle)) {
                    windowHandles.removeAll(oldTitle);
                    if (!windowHandles.isEmpty()) {
                        return windowHandles.iterator().next();
                    }
                }
                return null;
            }
        };
    }

    public static ExpectedCondition<String> appearingOfWindowByUrl(final String url) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                final String initialHandle = driver.getWindowHandle();
                for (final String each : driver.getWindowHandles()) {
                    driver.switchTo().window(each);
                    try {
                        if (url.equals(URLDecoder.decode(driver.getCurrentUrl(), "UTF-8"))) {
                            driver.switchTo().window(initialHandle);
                            return each;
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    public static ExpectedCondition<String> appearingOfWindowByPartialUrl(final String url) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(final WebDriver driver) {
                final String initialHandle = driver.getWindowHandle();
                for (final String each : driver.getWindowHandles()) {
                    driver.switchTo().window(each);
                    if (driver.getCurrentUrl().contains(url)) {
                        driver.switchTo().window(initialHandle);
                        return each;
                    }
                }
                driver.switchTo().window(initialHandle);
                return null;
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element, final String text) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return element.getText().contains(text);
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return !element.getText().isEmpty();
            }
        };
    }

    public static ExpectedCondition<Boolean> presenceOf(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                return element.isDisplayed();
            }
        };
    }

    public static ExpectedCondition<WebElement> invisibleOf(final By locator) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(final WebDriver driver) {
                return elementIfInvisible(driver.findElement(locator));
            }
        };
    }

    public static ExpectedCondition<WebElement> invisibleOf(final WebElement element) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(final WebDriver driver) {
                return elementIfInvisible(element);
            }
        };
    }

    public static ExpectedCondition<Boolean> presenceOf(final Element element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver driver) {
                element.isVisible();
                return true;
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> visibilityOfAllElementsLocatedBy(final By locator) {
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(final WebDriver driver) {
                final List<WebElement> found = driver.findElements(locator);
                for (final WebElement each : found) {
                    if (!each.isDisplayed()) {
                        return null;
                    }
                }
                return isNotEmpty(found) ? found : null;
            }
        };
    }

    public static ExpectedCondition<EnabledElement> enablingOfElement(final EnabledElement element) {
        return new ExpectedCondition<EnabledElement>() {
            @Override
            public EnabledElement apply(@Nullable WebDriver webDriver) {
                return element.isEnabled() ? element : null;
            }
        };
    }

    public static ExpectedCondition<Boolean> isPageReloaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                try {
//                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return $.active==0");
                } catch (TimeoutException e) {
                    return false;
                } catch (UnreachableBrowserException e) {
                    return false;
                } catch (WebDriverException e) {
                    return false;
                }
            }
        };
    }
}
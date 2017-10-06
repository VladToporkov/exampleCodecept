package com.actionmedia.autotest;

import com.actionmedia.autotest.selenium.elements.Element;
import com.actionmedia.autotest.selenium.elements.EnabledElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementFinder {

    WebElement findElementBy(By locator);

    WebElement findElementBy(SearchContext searchContext, By locator);

    List<WebElement> findElementsBy(By locator);

    List<WebElement> findElementsBy(SearchContext searchContext, final By locator);

    Boolean waitForTextToBePresentInElement(By locator, String text);

    WebElement waitForPresenceOfElementLocatedBy(By locator);

    WebElement waitForVisibilityOfElementLocatedBy(By locator);

    WebElement waitForElementToBeClickable(By locator);

    EnabledElement waitForElementToBeEnable(EnabledElement element);

    WebElement waitForElementToBeEnable(By locator);

    List<WebElement> waitForPresenceOfAllElementsLocatedBy(By locator);

    boolean elementExists(By locator);

    boolean isTextPresentInElement(By locator, String text);

    Boolean waitForStalenessOf(WebElement webElement);

    void waitForPresenceOf(Element element);

    void waitForWindowToBeAppearedAndSwitchToIt(String title);

    void waitForWindowToBeAppearedByUrlAndSwitchToIt(String url);

    void waitForWindowToBeAppearedByPartialTitleAndSwitchToIt(String fullTitle);

    void waitForNewPopUpWindowAndSwitchToIt(WebElement webElement);

    void closeCurrentBrowserWindow();

    Boolean waitForTextToBePresentIn(WebElement element, String text);

    Boolean waitForTextToBePresentIn(WebElement element);

    void waitForPresenceOf(WebElement element);

    WebElement waitForInvisibilityOfElementLocatedBy(By locator);

    WebElement waitForInvisibilityOfElementLocatedBy(WebElement element);

    List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator);

    void setTimeout(long timeout);

    void waitForWindowToBeAppearedByPartialUrlAndSwitchToIt(String url);

    void waitForReloadingPage();

    WebElement waitForPresenceOfElementLocatedBy(By locator, long timeout);

    List<WebElement> waitForPresenceOfAllElementsLocatedBy(By locator, long timeout);
}

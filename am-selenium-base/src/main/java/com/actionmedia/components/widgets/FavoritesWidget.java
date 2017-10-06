package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Pavel on 07/04/16.
 */
@Component
public class FavoritesWidget extends BasePage<FavoritesWidget> {

    @FindBy(id = "widget-my-documents")
    @Wait
    @CacheLookup
    private WebElement widget;

    private final String titleText = "Избранное";

    @Step("Проверяется что виджет Избранное отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет " + titleText + " не отображается");
    }

    @Step("Проверяется что виджет Избранное отображается")
    public void checkWidgetIsNotPresent() {
        WebElement widget = findElementByNoThrow(By.id("widget-my-documents"));
        postponedAssertTrue(widget == null || !widget.isDisplayed(), "Виджет " + titleText + " отображается");
    }

    @Step("Проверяется, что отображается заголовок виджета")
    public void checkTitleIsPresent() {
        WebElement titleLink = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertEqualsText(titleLink, titleText);
    }

    @Step("Проверяется, что Отображается текст Вы еще не добавили ни одного документа")
    public void checkTextFadeIsPresent() {
        WebElement fadeText = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li"));
        postponedAssertEqualsText(fadeText, "Вы ещё не добавили ни одного документа.");
    }

    @Step("Проверяется, что Отображаются пять ссылок на виджете")
    public void checkFiveLinksArePresent() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector(".list_viewtype_fade li"));
        postponedAssertTrue(links != null && links.size() == 5, "Пять ссылок в виджете не отображаются");
    }

    @Step("Нажать первую ссылку на документ в виджете")
    public void clickOnFirstDocumentLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(1) a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.findElement(By.tagName("ins")).click();
        waitForReloadingPage();
    }

    @Step("Нажать первую ссылку на документ в виджете")
    public void clickOnSecondDocumentLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(2) a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.findElement(By.tagName("ins")).click();
        waitForReloadingPage();
    }

    @Step("Нажать первую ссылку на документ в виджете")
    public void clickOnThirdDocumentLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(3) a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.findElement(By.tagName("ins")).click();
        waitForReloadingPage();
    }

    @Step("Нажать первую ссылку на документ в виджете")
    public void clickOnFourthDocumentLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(4) a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.findElement(By.tagName("ins")).click();
        waitForReloadingPage();
    }

    @Step("Нажать первую ссылку на документ в виджете")
    public void clickOnFifthDocumentLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(5) a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, link.getAttribute("href"));
        link.findElement(By.tagName("ins")).click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Избранное")
    public void clickOnFavoritesTitleLink() {
        WebElement titleLink = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        titleLink.click();
        waitForReloadingPage();
    }
}

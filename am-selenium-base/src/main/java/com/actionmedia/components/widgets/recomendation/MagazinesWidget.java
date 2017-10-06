package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.Link;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel on 21/02/16.
 */
@Component
public class MagazinesWidget extends Widget {

    @FindBy(id = "widget-press")
    @Wait
    @ErrorMessage("Виджет Журналы и книги не найден")
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что виджет Журналы и книги отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Журналы и книги не отображается");
    }

    @Step("Проверяется, что виджет Журналы и книги отображается")
    public void checkWidgetIsNotPresent() {
        WebElement widget = findElementByNoThrow(By.id("widget-press"));
        postponedAssertTrue(widget == null || !widget.isDisplayed(), "Виджет Журналы и книги отображается");
    }

    @Step("Проверяется, что отображается заголовок виджета")
    public void checkTitleIsPresent() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertNotNull(title, "Заголовок виджета не найден");
        postponedAssertTrue(title.isDisplayed(), "Заголовок виджета не найден");
    }

    @Step("Проверяется, что отображаются обложки журналов")
    public void checkMagazinesCoversIsPresent() {
        List<WebElement> covers = getCovers();
        postponedAssertFalse(covers.isEmpty(), "Обложки журналов не найдены");
    }

    @Step("Проверяется, что журналы и книги не повторяются")
    public void checkMagazinesAreNotRepeated() {
        List<WebElement> covers = getCovers();
        List<String> srcImgCovers = new ArrayList<String>();
        for (WebElement cover : covers) {
            srcImgCovers.add(cover.findElement(By.xpath("./img")).getAttribute("src"));
        }
        int beforeRemove = srcImgCovers.size();
        //remove all repeated links to covers images
        Set<String> notRepeatedSet = new HashSet<String>();
        notRepeatedSet.addAll(srcImgCovers);
        srcImgCovers.clear();
        srcImgCovers.addAll(notRepeatedSet);
        int afterRemove = srcImgCovers.size();
        postponedAssertEquals(afterRemove, beforeRemove, "Журналы и книги имеют повторения по ссылкам на обложки");
    }

    @Step("Проверяется, что у свежего номера журнала отображается Красная галочка")
    public void checkRedMarkerForNewMagazine() {
        List<WebElement> covers = getCovers();
        WebElement firstMagazine = covers.get(0);
        WebElement redMarker = findElementBy(firstMagazine, By.xpath("./following-sibling::span"), "Красный маркер не найден");
        postponedAssertTrue(redMarker.isDisplayed(), "Маркер не отображается для первого журнала");
        postponedAssertEquals(redMarker.getCssValue("background-color"), "rgba(229, 0, 0, 1)", "Маркер не красного цвета");
        WebElement checkMark = findElementByNoThrow(redMarker, By.cssSelector(".ico"));
        postponedAssertTrue(checkMark.isDisplayed(), "Галочка не отображена");
    }

    @Step("Проверяется, что отображается текст Свежий номер")
    public void checkTextNewMagazineIsPresent() {
        List<WebElement> covers = getCovers();
        WebElement firstMagazine = covers.get(0);
        String linkToFirstMagazine = firstMagazine.getAttribute("href");

        WebElement notice = findElementByNoThrow(widget, By.cssSelector(".widget__title-notice"));
        String noticeText = notice.getText();

        WebElement linkToDocument = findElementByNoThrow(notice, By.tagName("a"));
        String linkToDocumentNotice = linkToDocument.getAttribute("href");

        postponedAssertTrue(notice.isDisplayed(), "Текст Свежий номер не отображается");
        postponedAssertTrue(noticeText.contains("Свежий номер"), "Текст Свежий номер не представлен в тексте: " + noticeText);

        postponedAssertEquals(linkToFirstMagazine, linkToDocumentNotice, "Ссылки на журнал и в тексте Свежий номер " + "не совпадают");
    }

    @Step("Нажать на ссылку заголовка Журналы и книги")
    public void clickOnTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        scrollToElementLocationWithout200px(title);
        title.click();
        waitForReloadingPage();
    }

    @Step("Нажать на ссылку Свежий номер")
    public void clickOnNotice() {
        WebElement linkToDocument = findElementByNoThrow(widget, By.cssSelector(".widget__title-notice a"));
        setParameter(SearchResultHelper.DOCUMENT_URL, linkToDocument.getAttribute("href"));
        linkToDocument.click();
    }

    @Step("Проверить ссылки на журналы")
    public void checkMagazinesLinks() {
        List<WebElement> covers = getCovers();
        List<Link> documentLinks = new ArrayList<Link>();
        for (WebElement cover : covers) {
            documentLinks.add(new Link(cover.getAttribute("href"), cover.getAttribute("title")));
        }
        checkLinks(documentLinks);
    }

    @Step("Проверить количество обложек при разных разрешениях экрана")
    public void checkMagazinesCoversWithVariantResolutions() {
        Dimension maxDimension = getDriver().manage().window().getSize();
        if (maxDimension.getWidth() > 1366) {
            setSizeWindows(1366, maxDimension.getHeight());
            for (WebElement cover : getCovers()) {
                postponedAssertTrue(cover.isDisplayed(), "Обложка:" + cover.getAttribute("title") + " не отображается виджете при разрешении экрана 1366px");
            }
        }
        if (maxDimension.getWidth() > 1280) {
            setSizeWindows(1280, maxDimension.getHeight());
            for (WebElement cover : getCovers().subList(0, 5)) {
                postponedAssertTrue(cover.isDisplayed(), "Обложка:" + cover.getAttribute("title") + " не отображается виджете при разрешении экрана 1280");
            }
            for (WebElement cover : getCovers().subList(6, 6)) {
                postponedAssertFalse(cover.isDisplayed(), "Обложка:" + cover.getAttribute("title") + " отображается виджете при разрешении экрана 1280, но должна быть скрыта");
            }
        }
        if (maxDimension.getWidth() > 1024) {
            setSizeWindows(1024, maxDimension.getHeight());
            for (WebElement cover : getCovers().subList(0, 3)) {
                postponedAssertTrue(cover.isDisplayed(), "Обложка:" + cover.getAttribute("title") + " не отображается виджете при разрешении экрана 1024");
            }
            for (WebElement cover : getCovers().subList(4, 6)) {
                postponedAssertFalse(cover.isDisplayed(), "Обложка:" + cover.getAttribute("title") + " отображается виджете при разрешении экрана 1024, но должна быть скрыта");
            }
        } else {
            setPostponedTestFailWithoutScreen("Проверка на количество обложек не пройдена, разрешение браузера меньше чем 1024 px");
        }
        maximize();
    }

    private List<WebElement> getCovers() {
        List<WebElement> covers = findElementsBy(widget, By.cssSelector("ul.list a"));
        if (covers.isEmpty()) {
            setPostponedTestFail("Обложки журналов не найдены");
        }
        return covers;
    }
}

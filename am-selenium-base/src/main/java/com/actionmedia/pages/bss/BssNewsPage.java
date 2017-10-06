package com.actionmedia.pages.bss;

import com.actionmedia.pages.interfaces.INewsPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.NewsPageHelper;
import com.actionmedia.util.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 15:52
 */
@Component
public class BssNewsPage extends BssBasePage<BssNewsPage> implements INewsPage {

    public BssNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }

    public BssNewsPage checkLinksOnNewsPage() {
        getHelper(NewsPageHelper.class).checkLinksOnNewsPage();
        return this;
    }

    public BssNewsPage checkDateAreSortedDescending() {
        getHelper(NewsPageHelper.class).checkDateAreSortedDescending();
        return this;
    }

    public BssNewsPage checkNewsAreNotEmpty() {
        getHelper(NewsPageHelper.class).checkNewsAreNotEmpty();
        return this;
    }

    public BssNewsPage checkNewsBlockAreNotRepeated() {
        getHelper(NewsPageHelper.class).checkNewsBlockAreNotRepeated();
        return this;
    }

    public BssNewsPage checkNewsScrolling() {
        getHelper(NewsPageHelper.class).checkNewsScrolling();
        return this;
    }

    @Step("Проверяется что открыт документ 'RSS обновления разделов'")
    public BssNewsPage checkRssDocumentPageIsOpened(String expectedUrl) {
        String currentUrl = getCurrentUrl();
        postponedAssertTrue(currentUrl.contains(expectedUrl), "Документ 'RSS обновления разделов' не открыт.");
        return this;
    }

    @Step("Проверяется что документ 'RSS обновления разделов' не пустой")
    public BssNewsPage checkRssDocumentIsNotEmpty() {
        checkEmptyDocumentHeader();
        checkEmptyDocument();
        return this;
    }

    @Step("Открыть раздел 'Новости'")
    public BssNewsPage clickNewsSection() {
        clickSectionButton(By.cssSelector("[data-filter='news']"));
        return this;
    }

    @Step("Открыть раздел 'Рекомендации'")
    public BssNewsPage clickRecomendSection() {
        clickSectionButton(By.cssSelector("[data-filter='recommendations']"));
        return this;
    }

    @Step("Открыть раздел 'Правовая База'")
    public BssNewsPage clickLawBaseSection() {
        clickSectionButton(By.cssSelector("[data-filter='law']"));
        return this;
    }

    @Step("Открыть раздел 'Формы'")
    public BssNewsPage clickFormsSection() {
        clickSectionButton(By.cssSelector("[data-filter='forms']"));
        return this;
    }

    @Step("Открыть раздел 'Справочник'")
    public BssNewsPage clickDictionarySection() {
        clickSectionButton(By.cssSelector("[data-filter='handbook']"));
        return this;
    }

    @Step("Открыть раздел 'Журналы и Книги'")
    public BssNewsPage clickMagazinesSection() {
        clickSectionButton(By.cssSelector("[data-filter='press']"));
        return this;
    }

    @Step("Открыть раздел 'Видео'")
    public BssNewsPage clickVideosSection() {
        clickSectionButton(By.cssSelector("[data-filter='videos']"));
        return this;
    }

    @Step("Открыть раздел 'Сервисы'")
    public BssNewsPage clickServicesSection() {
        clickSectionButton(By.cssSelector("[data-filter='services']"));
        return this;
    }

    @Step("Открыть раздел 'RSS обновления разделов'")
    public BssNewsPage clickRssLink() {
        WebElement menu = waitForPresenceOfElementLocatedBy(By.id("newspaper"));
        menu.findElement(By.cssSelector(".newspaper-rss-link")).click();
        waitForReloadingPage();
        return this;
    }

    @Step("Открыть случайный документ из газеты")
    public BssDocumentPage clickRandomDocument() {
        WebElement newsPaper = mainContentElement.findElement(By.id("newspaper"));
        List<WebElement> docList = newsPaper.findElements(By.cssSelector(".title-link"));
        WebElement randomDoc = getRandomElementInList(docList);
        randomDoc.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть случайный документ из газеты")
    public BssDocumentPage clickRandomDocumentByModuleExclude(String[] excludedModule) {
        WebElement result = mainContentElement.findElement(By.id("newspaper"));
        List<WebElement> docList = result.findElements(By.cssSelector(".title-link"));
        List<WebElement> newDocList = new ArrayList<WebElement>();
        for (WebElement doc : docList) {
            String moduleText = doc.getAttribute("href").split("/#/document/")[1].split("/")[0];
            if (!TestUtils.isElementContainsInArray(moduleText, excludedModule)) {
                newDocList.add(doc);
            }
        }
        WebElement randomDoc = getRandomElementInList(newDocList);
        randomDoc.click();
        return redirectTo(BssDocumentPage.class);
    }

    @Step("Открыть последний документ из найденных в газете")
    public BssDocumentPage clickLastDocumentByModule(String module) {
        getHelper(NewsPageHelper.class).clickLastDocumentByModuleId(module);
        return redirectTo(BssDocumentPage.class);
    }

    private void clickSectionButton(By by) {
        WebElement menu = waitForPresenceOfElementLocatedBy(By.id("newspaper-menu"));
        menu.findElement(by).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }

    @Step("Проверяется открытие раздела 'Правовая база'")
    public BssNewsPage checkLawBaseNewsSection() {
        getHelper(NewsPageHelper.class).checkLawBaseNewsSection();
        return this;
    }
}

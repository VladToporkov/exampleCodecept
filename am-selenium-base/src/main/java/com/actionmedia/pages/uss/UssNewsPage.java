package com.actionmedia.pages.uss;

import com.actionmedia.pages.interfaces.INewsPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.NewsPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:15
 */
@Component
public class UssNewsPage extends UssBasePage<UssNewsPage> implements INewsPage {

    public UssNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }

    public UssNewsPage checkNewsScrolling() {
        getHelper(NewsPageHelper.class).checkNewsScrolling();
        return this;
    }

    public UssNewsPage checkDateAreSortedDescending() {
        getHelper(NewsPageHelper.class).checkDateAreSortedDescending();
        return this;
    }

    public UssNewsPage checkDateAreSortedDescendingForOneYear() {
        getHelper(NewsPageHelper.class).checkDateAreSortedDescendingForOneYear();
        return this;
    }

    public UssNewsPage checkDateAreSortedDescendingForFirstNumberOfDate(int numberOfDate) {
        getHelper(NewsPageHelper.class).checkDateAreSortedDescendingForFirstNumberOfDate(numberOfDate);
        return this;
    }

    public UssNewsPage checkNewsBlockAreNotRepeated() {
        getHelper(NewsPageHelper.class).checkNewsBlockAreNotRepeated();
        return this;
    }

    public UssNewsPage checkNewsAreNotEmpty() {
        getHelper(NewsPageHelper.class).checkNewsAreNotEmpty();
        return this;
    }

    public UssNewsPage checkLinksOnNewsPage() {
        getHelper(NewsPageHelper.class).checkLinksOnNewsPage();
        return this;
    }

    @Step("Открыть раздел Ответы на странице Новое у юристов")
    public UssNewsPage clickRecomendSection() {
        clickSectionButton(By.cssSelector("[data-filter='recommendations']"));
        return this;
    }

    @Step("Открыть раздел Правовая база на странице Новое у юристов")
    public UssNewsPage clickLawBaseSection() {
        clickSectionButton(By.cssSelector("[data-filter='law']"));
        return this;
    }

    @Step("Открыть раздел Формы на странице Новое у юристов")
    public UssNewsPage clickFormsSection() {
        clickSectionButton(By.cssSelector("[data-filter='forms']"));
        return this;
    }

    @Step("Открыть раздел Справочник на странице Новое у юристов")
    public UssNewsPage clickDictionarySection() {
        clickSectionButton(By.cssSelector("[data-filter='handbook']"));
        return this;
    }

    @Step("Открыть раздел Журналы и книги на странице Новое у юристов")
    public UssNewsPage clickMagazinesSection() {
        clickSectionButton(By.cssSelector("[data-filter='press']"));
        return this;
    }

    @Step("Открыть раздел Видео на странице Новое у юристов")
    public UssNewsPage clickVideosSection() {
        clickSectionButton(By.cssSelector("[data-filter='videos']"));
        return this;
    }

    @Step("Открыть раздел Мастера на странице Новое у юристов")
    public UssNewsPage clickWizardsSection() {
        clickSectionButton(By.cssSelector("[data-filter='wizards']"));
        return this;
    }

    @Step("Открыть раздел Мастера на странице Новое у юристов")
    public UssNewsPage clickServiceSection() {
        clickSectionButton(By.cssSelector("[data-filter='services']"));
        return this;
    }

    private void clickSectionButton(By by) {
        WebElement menu = waitForPresenceOfElementLocatedBy(By.id("newspaper-menu"));
        menu.findElement(by).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }
    @Step("Проверяется открытие раздела 'Правовая база'")
    public UssNewsPage checkLawBaseNewsSection() {
        getHelper(NewsPageHelper.class).checkLawBaseNewsSection();
        return this;
    }

    @Step("Открыть раздел 'Новости'")
    public UssNewsPage clickNewsSection() {
        clickSectionButton(By.cssSelector("[data-filter='news']"));
        return this;
    }

    public UssDocumentPage clickLastDocumentByModule(String module) {
        getHelper(NewsPageHelper.class).clickLastDocumentByModuleId(module);
        return redirectTo(UssDocumentPage.class);
    }
}

package com.actionmedia.pages.kss;

import com.actionmedia.pages.bss.BssDocumentPage;
import com.actionmedia.pages.interfaces.INewsPage;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.NewsPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class KssNewsPage extends KssBasePage<KssNewsPage> implements INewsPage {

    public KssNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }

    public KssNewsPage checkNewsScrolling() {
        getHelper(NewsPageHelper.class).checkNewsScrolling();
        return this;
    }

    public KssNewsPage checkDateAreSortedDescending() {
        getHelper(NewsPageHelper.class).checkDateAreSortedDescending();
        return this;
    }

    public KssNewsPage checkNewsBlockAreNotRepeated() {
        getHelper(NewsPageHelper.class).checkNewsBlockAreNotRepeated();
        return this;
    }

    public KssNewsPage checkNewsAreNotEmpty() {
        getHelper(NewsPageHelper.class).checkNewsAreNotEmpty();
        return this;
    }

    public KssNewsPage checkLinksOnNewsPage() {
        getHelper(NewsPageHelper.class).checkLinksOnNewsPage();
        return this;
    }

    @Step("Открыть раздел Ответы на странице Новое в работе")
    public KssNewsPage clickAnswersSection() {
        clickSectionButton(By.cssSelector("[data-filter='answers']"));
        return this;
    }

    @Step("Открыть раздел Правовая база на странице Новое в работе")
    public KssNewsPage clickLawBaseSection() {
        clickSectionButton(By.cssSelector("[data-filter='law']"));
        return this;
    }

    @Step("Открыть раздел Формы на странице Новое в работе")
    public KssNewsPage clickFormsSection() {
        clickSectionButton(By.cssSelector("[data-filter='forms']"));
        return this;
    }

    @Step("Открыть раздел Справочник на странице Новое в работе")
    public KssNewsPage clickDictionarySection() {
        clickSectionButton(By.cssSelector("[data-filter='handbook']"));
        return this;
    }

    @Step("Открыть раздел Журналы и книги на странице Новое в работе")
    public KssNewsPage clickMagazinesSection() {
        clickSectionButton(By.cssSelector("[data-filter='press']"));
        return this;
    }

    @Step("Открыть раздел Видео на странице Новое в работе")
    public KssNewsPage clickVideosSection() {
        clickSectionButton(By.cssSelector("[data-filter='videos']"));
        return this;
    }

    @Step("Открыть раздел Мастера на странице Новое в работе")
    public KssNewsPage clickWizardsSection() {
        clickSectionButton(By.cssSelector("[data-filter='wizards']"));
        return this;
    }

    private void clickSectionButton(By by) {
        WebElement menu = waitForPresenceOfElementLocatedBy(By.id("newspaper-menu"));
        menu.findElement(by).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }
    @Step("Проверяется открытие раздела 'Правовая база'")
    public KssNewsPage checkLawBaseNewsSection() {
        getHelper(NewsPageHelper.class).checkLawBaseNewsSection();
        return this;
    }

    @Step("Открыть раздел 'Новости'")
    public KssNewsPage clickNewsSection() {
        clickSectionButton(By.cssSelector("[data-filter='news']"));
        return this;
    }

    public KssDocumentPage clickLastDocumentByModule(String module) {
        getHelper(NewsPageHelper.class).clickLastDocumentByModuleId(module);
        return redirectTo(KssDocumentPage.class);
    }
}

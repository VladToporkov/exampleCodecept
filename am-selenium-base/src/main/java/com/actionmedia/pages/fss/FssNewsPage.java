package com.actionmedia.pages.fss;

import com.actionmedia.pages.interfaces.INewsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.NewsPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Shman4ik on 12.01.2015.
 */
@Component
public class FssNewsPage  extends FssBasePage<FssNewsPage> implements INewsPage {

    @Step("Проверяется открытие раздела 'Правовая база'")
    public FssNewsPage checkLawBaseNewsSection() {
        getHelper(NewsPageHelper.class).checkLawBaseNewsSection();
        return this;
    }

    @Step("Открыть раздел 'Новости'")
    public FssNewsPage clickNewsSection() {
        clickSectionButton(By.cssSelector("[data-filter='news']"));
        return this;
    }

    private void clickSectionButton(By by) {
        WebElement menu = waitForPresenceOfElementLocatedBy(By.id("newspaper-menu"));
        menu.findElement(by).findElement(By.tagName("a")).click();
        waitForReloadingPage();
    }

    public FssDocumentPage clickLastDocumentByModule(String module) {
        getHelper(NewsPageHelper.class).clickLastDocumentByModuleId(module);
        return redirectTo(FssDocumentPage.class);
    }

    public FssNewsPage checkNewsIsPresent() {
        getHelper(NewsPageHelper.class).checkNewsIsPresent();
        return this;
    }
}

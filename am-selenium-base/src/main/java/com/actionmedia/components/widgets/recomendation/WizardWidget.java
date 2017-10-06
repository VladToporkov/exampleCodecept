package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 21/07/16.
 */
@Component
public class WizardWidget  extends Widget {

    @FindBy(id = "widget-wizard")
    @ErrorMessage("Виджет мастера не найден")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что отображаются 5 мастеров")
    public void checkFiveLinksArePresent() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("li > a"));
        postponedAssertTrue(links != null && links.size() == 5, "Ссылки на мастера не отображаются, или ссылок не 5");
    }

    @Step("Отображается заголовок виджета")
    public void checkWidgetHasTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(title != null && title.isDisplayed(), "Заговок виджета не отображается");
    }

    @Step("Отображается общее количество решений в разделе")
    public void checkSolutionsCountIsPresent() {
        WebElement solutionsCount = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
        postponedAssertTrue(solutionsCount != null && solutionsCount.isDisplayed(), "Общее количество решений не " +
                "отображено в шапке виджета");
    }

    @Step("Нажимается ссылка первого решения")
    public void clickOnFirstSolution() {
        clickOnSolutionLink(1);
    }

    @Step("Нажимается ссылка второго решения")
    public void clickOnSecondSolution() {
        clickOnSolutionLink(2);
    }

    @Step("Нажимается ссылка третьего решения")
    public void clickOnThirdSolution() {
        clickOnSolutionLink(3);
    }

    @Step("Нажимается ссылка четвертого решения")
    public void clickOnFourthSolution() {
        clickOnSolutionLink(4);
    }

    @Step("Нажимается ссылка пятого решения")
    public void clickOnFifthSolution() {
        clickOnSolutionLink(5);
    }

    private void clickOnSolutionLink(int i) {
        WebElement estimatorLink = findElementBy(widget, By.cssSelector(String.format("li:nth-of-type(%d) > a", i)));
        setParameter(SearchResultHelper.DOCUMENT_URL, estimatorLink.getAttribute("href"));
        estimatorLink.click();
        waitForReloadingPage();
    }

    public WebElement getWidget() {
        return widget;
    }

    @Step("Нажимается на ссылку в заголовке")
    public void clickOnTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title a"));
        if (title != null) {
            title.click();
            waitForReloadingPage();
        }
    }
}


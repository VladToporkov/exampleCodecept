package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
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
public class EstimatorWidget extends Widget {

    @FindBy(id = "widget-estimator")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что отображаются 5 расчетчиков")
    public void checkFiveLinksArePresent() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("li > a"));
        postponedAssertTrue(links != null && links.size() == 5, "Ссылки на расчетчики не отображаются, или ссылок не 5");
    }

    @Step("Проверяется, что отображено количество расчетчиков в шапке виджета")
    public void checkEstimatorsCountIsPresent() {
        WebElement widgetCount = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
        postponedAssertTrue(widgetCount != null && widgetCount.isDisplayed(), "Количество расчетчиков не отображается");
    }

    @Step("Нажимается на ссылку в заголовке")
    public void clickOnTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title a"));
        if (title != null) {
            title.click();
            waitForReloadingPage();
        }
    }

    @Step("Нажимается ссылка на первый расчетчик")
    public void clickOnFirstEstimatorLink() {
        clickOnEstimatorLink(1);
    }

    @Step("Нажимается ссылка на второй расчетчик")
    public void clickOnSecondEstimatorLink() {
        clickOnEstimatorLink(2);
    }

    @Step("Нажимается ссылка на третий расчетчик")
    public void clickOnThirdEstimatorLink() {
        clickOnEstimatorLink(3);
    }

    @Step("Нажимается ссылка на четвертый расчетчик")
    public void clickOnFourthEstimatorLink() {
        clickOnEstimatorLink(4);
    }

    @Step("Нажимается ссылка на пятый расчетчик")
    public void clickOnFifthEstimatorLink() {
        clickOnEstimatorLink(5);
    }

    private void clickOnEstimatorLink(int i) {
        WebElement estimatorLink = findElementBy(widget, By.cssSelector(String.format("li:nth-of-type(%d) > a", i)));
        setParameter(SearchResultHelper.DOCUMENT_URL, estimatorLink.getAttribute("href"));
        estimatorLink.click();
        waitForReloadingPage();
    }

    public WebElement getWidget() {
        return widget;
    }

}

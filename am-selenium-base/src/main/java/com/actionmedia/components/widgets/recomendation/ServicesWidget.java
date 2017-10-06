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
 * Created by Pavel on 22/07/16.
 */
@Component
public class ServicesWidget extends Widget {

    @FindBy(css = "article.widget_content_services")
    @ErrorMessage("Виджет Сервисы не отображается")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что отображаются ссылки на сервисы (3 шт)")
    public void checkThreeLinksArePresent() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("ul li > a"));
        postponedAssertTrue(links != null, "Ссылки на сервисы не отображены");
        if (links != null) {
            int countLinks = 0;
            for (WebElement link: links) {
                if (link.isDisplayed()) {
                    countLinks++;
                }
            }
            postponedAssertEquals(countLinks, 3, "Ссылок на сервисы не 3");
        }
    }

    @Step("Проверить, что заголовок виджета сервисы отображается")
    public void checkTitleIsPresent() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(title != null && title.isDisplayed(), "Заголовок виджета сервисы отображается");
    }

    @Step("Нажать на ссылку Финансовый анализ виджета Сервисы")
    public void clickOnFinanceLink() {
        WebElement firstLink = findElementByNoThrow(widget, By.cssSelector(".list__item_order_1 a"));
        if (firstLink != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, firstLink.getAttribute("href"));
            firstLink.click();
            waitForReloadingPage();
        } else {
            postponedAssertTrue(firstLink != null && firstLink.isDisplayed(), "Ссылка финансовый анализ не " +
                    "отображена, или у нее поменялся локатор");
        }
    }

    @Step("Нажать на ссылку Финансовый анализ виджета Сервисы")
    public void clickOnBudgetLink() {
        WebElement secondLink = findElementByNoThrow(widget, By.cssSelector(".list__item_order_2 a"));
        if (secondLink != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, secondLink.getAttribute("href"));
            secondLink.click();
            waitForReloadingPage();
        } else {
            postponedAssertTrue(secondLink != null && secondLink.isDisplayed(), "Ссылка бюджетирование не " +
                    "отображена, или у нее поменялся локатор");
        }
    }

    @Step("Нажать на ссылку Финансовый анализ виджета Сервисы")
    public void clickOnExcelLink() {
        WebElement thirdLink = findElementByNoThrow(widget, By.cssSelector(".list__item_order_3 a"));
        if (thirdLink != null) {
            setParameter(SearchResultHelper.DOCUMENT_URL, thirdLink.getAttribute("href"));
            executeScript("arguments[0].setAttribute('target','_self')", thirdLink);
            thirdLink.click();
            waitForReloadingPage();
        } else {
            postponedAssertTrue(thirdLink != null && thirdLink.isDisplayed(), "Ссылка Excel не " +
                    "отображена, или у нее поменялся локатор");
        }
    }

    @Step("Нажать на ссылку Excel")
    public void clickOnTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        if (title != null) {
            title.click();
            waitForReloadingPage();
        }
    }
}

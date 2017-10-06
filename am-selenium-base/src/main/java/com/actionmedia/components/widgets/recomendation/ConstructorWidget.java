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
 * Created by Pavel on 01/07/16.
 */
@Component
public class ConstructorWidget extends Widget {

    @FindBy(id = "widget-constructor")
    @Wait
    @ErrorMessage("Виджет Конструктор документов не найден")
    @CacheLookup
    private WebElement widget;

    private static int documentNumber = 0;

    @Step("Проверяется, что виджет Семинар отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Конструктор документов не отображается");
    }

    @Step("Проверяется, что виджет Семинар не отображается")
    public void checkWidgetIsNotPresent() {
        WebElement widget = findElementByNoThrow(By.id("widget-constructor"));
        postponedAssertTrue(widget == null || !widget.isDisplayed(), "Виджет Конструктор документов отображается");
    }

    @Step("Проверить, что отображаются ссылки на сервисы")
    public void checkServicesItemsArePresent() {
        List<WebElement> items = findElementsByNoThrow(widget, By.cssSelector("li > a"));
        postponedAssertTrue(items != null && items.size() > 0, "Ссылки на сервисы не отображаются");
    }

    @Step("Нажать на следующую ссылку в виджете")
    public boolean clickOnNextServicesItem() {
        List<WebElement> items = findElementsByNoThrow(widget, By.cssSelector("li > a"));
        int maxSize = items.size();
        if (documentNumber < maxSize) {
            WebElement item = items.get(documentNumber++);
            setParameter(SearchResultHelper.DOCUMENT_URL, item.getAttribute("href"));
            executeScript("arguments[0].setAttribute('target','_self')", item);
            item.click();
            waitForReloadingPage();
            return true;
        } else {
            return false;
        }
    }

    @Step("Нажимается ссылка Конструктор документов")
    public void clickOnWidgetTitle() {
        WebElement titleLink = findElementByNoThrow(widget, By.cssSelector("h3 a.widget__title-text"));
        if (titleLink != null && titleLink.isDisplayed()) {
            setParameter(SearchResultHelper.DOCUMENT_URL, titleLink.getAttribute("href"));
            executeScript("arguments[0].setAttribute('target','_self')", titleLink);
            titleLink.click();
            waitForReloadingPage();
        }
    }

    public WebElement getWidget() {
        return widget;
    }
}

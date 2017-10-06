package com.actionmedia.components.widgets.lawbase;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Pavel on 29/05/16.
 */
@Component
public class BudgetWidget extends Widget {

    @FindBy(css = ".widget_content_budget-code")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что отображается 8 ссылок на кодексы")
    public void checkWidgetHasEightLinks() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li"));
        postponedAssertTrue(links != null && getVisibleLinks(links) == 8, "Отображено не 8 ссылок");
    }

    @Step("Проверяется, что отображается 6 ссылок на кодексы")
    public void checkWidgetHasSixLinks() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li"));
        postponedAssertTrue(links != null && getVisibleLinks(links) == 6, "Отображено не 6 ссылок");
    }

    @Step("Проверяется, что отображается 4 ссылки на кодексы")
    public void checkWidgetHasFourLinks() {
        List<WebElement> links = findElementsByNoThrow(widget, By.cssSelector("div > .list li"));
        postponedAssertTrue(links != null && getVisibleLinks(links) == 4, "Отображено не 4 ссылок");
    }

    public WebElement getWidget() {
        return widget;
    }

}

package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 30/06/16.
 */
@Component
public class EstimatorsWidget extends Widget {

    @FindBy(id = "widget-estimator")
    @Wait
    @ErrorMessage("Виджет Расчетчики не найден")
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что виджет Расчетчики отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Расчетчики не отображается");
    }

    @Step("Проверяется, что виджет Расчетчики не отображается")
    public void checkWidgetIsNotPresent() {
        WebElement widget = findElementByNoThrow(By.id("widget-school"));
        postponedAssertTrue(widget == null || !widget.isDisplayed(), "Виджет Расчетчики отображается");
    }
}
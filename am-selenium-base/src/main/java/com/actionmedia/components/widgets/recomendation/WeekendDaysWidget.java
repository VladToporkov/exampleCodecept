package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 29/06/16.
 */
@Component
public class WeekendDaysWidget extends Widget {

    @FindBy(id = "widget-annonce-2")
    @ErrorMessage("Виджет Количество Выходных дней не найден")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что виджет Количество Выходных дней отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Количество Выходных дней не отображается");
    }
}

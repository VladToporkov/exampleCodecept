package com.actionmedia.components.widgets.lawbase;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 21/06/16.
 */
@Component
public class ProfstandartsWidget extends Widget {

    @FindBy(css = ".widget_content_profstandarts")
    @Wait
    @CacheLookup
    private WebElement widget;

    public void checkTitleHasWordProfstandarts() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(title != null && title.getText().contains("Профстандарты"),
                "Слово Профстандарты не найдено в заголовке виджета:" + title.getText());
    }

    public void checkTitleHasNoticeNew() {
        WebElement notice = findElementByNoThrow(widget, By.cssSelector(".widget__title-notice"));
        postponedAssertEqualsText(notice, "НОВОЕ");
    }

    public void checkCountProfstandartsIsPresent() {
        WebElement count = findElementByNoThrow(widget, By.cssSelector(".widget__count"));
        postponedAssertTrue(count != null && count.isDisplayed(), "Количество принятых стандартов не отображается в виджете");
    }

    public void checkLinkAllAcceptedIsPresent() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_more a"));
        postponedAssertEqualsText(link, "Все принятые");
    }

    public void checkLinkHRIsPresent() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(1) a"));
        postponedAssertEqualsText(link, "Специалист по HR");
    }

    public void checkLinkSpecialistSafetyIsPresent() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(2) a"));
        postponedAssertEqualsText(link, "Специалист по охране труда");
    }

    public void checkLinkRecruiterIsPresent() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector(".list_viewtype_fade li:nth-of-type(3) a"));
        postponedAssertEqualsText(link, "Рекрутер");
    }

    public WebElement getWidget() {
        return widget;
    }

}

package com.actionmedia.components.widgets;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.pages.helpers.SearchResultHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 11/04/16.
 */
@Component
public class BannerBlock extends BasePage<BannerBlock> {

    @FindBy(css = ".enseigne_viewtype_super a")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется что Баннер отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Баннер не отображается");
    }

    @Step("Нажать на ссылку в баннере")
    public void clickOnBanner() {
        executeScript("arguments[0].setAttribute('target','_self')", widget);
        setParameter(SearchResultHelper.DOCUMENT_URL, widget.getAttribute("href"));
        widget.click();
        waitForReloadingPage();
    }


    @Step("Проверить отображение баннера при разрешении 1024px")
    public void checkBannerTextWithScreenResolution1024px() {
        setSizeWindows(1000, 500);
        WebElement text = findElementByNoThrow(widget, By.cssSelector(".enseigne__text"));
        int width = text.getSize().getWidth();
        postponedAssertTrue(width > 240 && width < 270, "Баннер вылез за рамки проверочных размеров:" + "240<widht<270, but width: " + width);
        maximize();
    }

    @Step("Проверить отображение баннера при разрешении 1280px")
    public void checkBannerTextWithScreenResolution1280px() {
        if (getDriver().manage().window().getSize().getWidth() < 1200) {
            report("Размер окна браузера меньше чем 1280, проверка не может быть пройдена");
            return;
        }
        setSizeWindows(1200, 500);
        WebElement text = findElementByNoThrow(widget, By.cssSelector(".enseigne__text"));
        int width = text.getSize().getWidth();
        postponedAssertTrue(width > 250 && width < 280, "Баннер вылез за рамки проверочных размеров:" + "250<widht<280, but width:  " + width);
        maximize();
    }

    @Step("Проверить отображение баннера при разрешении 1366px")
    public void checkBannerTextWithScreenResolution1366px() {
        if (getDriver().manage().window().getSize().getWidth() < 1366) {
            report("Размер окна браузера меньше чем 1366, проверка не может быть пройдена");
            return;
        }
        setSizeWindows(1300, 500);
        WebElement text = findElementByNoThrow(widget, By.cssSelector(".enseigne__text"));
        int width = text.getSize().getWidth();
        postponedAssertTrue(width > 250 && width < 310, "Баннер вылез за рамки проверочных размеров:" + "250<widht<310, but width:  " + width);
        maximize();
    }
}

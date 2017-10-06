package com.actionmedia.components.widgets.recomendation;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.base.BasePage;
import com.actionmedia.components.widgets.Widget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 20/02/16.
 */
@Component
public class VideoWidget extends Widget {

    @FindBy(id = "widget-video")
    @ErrorMessage("Виджет видео не найден")
    @Wait
    @CacheLookup
    private WebElement widget;

    @Step("Проверяется, что виджет видео отображается")
    public void checkWidgetIsPresent() {
        postponedAssertTrue(widget.isEnabled() && widget.isDisplayed(), "Виджет Видео не отображается");
    }

    @Step("Проверяется, что виджет видео не отображается")
    public void checkWidgetIsNotPresent() {
        WebElement widget = findElementByNoThrow(By.id("widget-video"));
        postponedAssertTrue(widget == null || !widget.isDisplayed(), "Виджет Видео отображается");
    }

    @Step("Проверяется, что виджет видео не пустой")
    public void checkVideoPreviewIsPresent() {
        WebElement videoPreview = findElementByNoThrow(widget, By.cssSelector(".video__image"));
        postponedAssertNotNull(videoPreview, "Bидеопревью в блоке 'Видео' не найдено");
        if (videoPreview != null) {
            assertTrue(videoPreview.getTagName().equals("a"), "Ссылка для видео не найдена");
            assertNotNull(videoPreview.getAttribute("style"), "Фон для видео не отображается");
            postponedAssertTrue(videoPreview.getAttribute("style").contains("background-image:") && videoPreview.getAttribute("style").contains("system/content/feature/image/"), "Фон для видео не отображается");
        }
    }

    @Step("Проверяется, что у виджета не виден заголовок")
    public void checkHasNoTitle() {
        WebElement title = findElementByNoThrow(widget, By.cssSelector(".widget__title-text"));
        postponedAssertTrue(title == null || !title.isDisplayed(), "Заголовок видео виджета отображается");
    }

    @Step("Проверяется, что на фоне виджета отображается скришот из видео")
    public void checkScreenshotIsPresent() {
        WebElement videoLink = findElementByNoThrow(widget, By.cssSelector(".widget__in > a.link"));
        String style = videoLink.getAttribute("style");
        postponedAssertTrue(style.contains("background-image:") && style.contains("system/content/feature/image/"), "Скриншот из видео не отображается");
    }

    @Step("Проверяется, что отображается заголовок видеосеминара (ссылка)")
    public void checkLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector("u.link__in"));
        postponedAssertTrue(link.isDisplayed(), "Заголовок видеосеминара не отображается");
        postponedAssertFalse(link.getText().isEmpty(), "Заголовок видеосеминара пустой");
    }

    @Step("Проверяется, что отображается длительность видеосеминара")
    public void checkVideoDuration() {
        WebElement videoDuration = findElementByNoThrow(widget, By.cssSelector(".videos__time"));
        postponedAssertTrue(videoDuration.isDisplayed(), "Длительность видеосеминара не отображается");
    }

    @Step("Нажать на скриншот из видео")
    public void clickOnScreenshot() {
        WebElement videoLink = findElementBy(widget, By.cssSelector(".widget__in > a.link"));
        videoLink.click();
        waitForReloadingPage();
    }

    @Step("Нажать на заголовок видео")
    public void clickOnLink() {
        WebElement link = findElementByNoThrow(widget, By.cssSelector("u.link__in"));
        link.click();
        waitForReloadingPage();
    }
}

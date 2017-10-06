package com.actionmedia.components.popups;

import com.actionmedia.autotest.selenium.annotations.ErrorMessage;
import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractComponent;
import com.actionmedia.autotest.selenium.elements.Button;
import com.actionmedia.autotest.selenium.elements.CheckBox;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Pavel on 29/02/16.
 */
@Component
public class PredemoPopup extends BasePage<PredemoPopup> {

    @FindBy(id = "popup_content_predemo")
    @Wait
    @ErrorMessage("Предемо popup не отображается")
    @CacheLookup
    private WebElement widget;

    @Step("Проверить, что появилась форма Предемо")
    public void checkPopupIsPresent() {
        postponedAssertTrue(widget != null && widget.isDisplayed(), "Всплывающее окно Предемо не отображается");
    }

    @Step("Проверить, что отображается текст формы")
    public void checkContentHasText() {
        WebElement content = findElementByNoThrow(widget, By.cssSelector("#popup_content_predemo .popup_content"));
        postponedAssertFalse(content.getText().isEmpty(), "Предемо не имеет контента или он пустой");
    }

    @Step("Проверить, что отобрается поле ФИО")
    public void checkTextFieldFullNameIsPresent() {
        WebElement inputFullName = findElementByNoThrow(widget, By.id("fullName"));
        postponedAssertTrue(inputFullName != null && inputFullName.isDisplayed(), "Поле ФИО не отображается");
    }

    @Step("Проверить, что отображается поле Эл. почта")
    public void checkTextFieldEmailIsPresent() {
        WebElement inputEmail = findElementByNoThrow(widget, By.cssSelector("#popup_content_predemo #email"));
        postponedAssertTrue(inputEmail != null && inputEmail.isDisplayed(), "Поле Эл. почта не отображается");
    }

    @Step("Проверить, что отображется чекбокс Подписка, он выбран и текст соответствует")
    public void checkCheckBoxSubscribe(String text) {
        WebElement checkBoxSubscribe = findElementByNoThrow(widget, By.name("subscribe"));
        postponedAssertTrue(checkBoxSubscribe != null && checkBoxSubscribe.isDisplayed(), "Чекбокс Подписка не отображается");
        if (checkBoxSubscribe != null) {
            postponedAssertTrue(checkBoxSubscribe.isSelected(), "Чекбокс Подписка не выбран по умолчанию");
            WebElement subscribeTextElement = findElementBy(By.xpath("//*[@name='subscribe']/../span"));
            postponedAssertEquals(subscribeTextElement.getText(), text, "Текст Подписки не совпадает");
        }
    }

    @Step("Проверить, что отображается кнопка Получить доступ")
    public void checkButtonGetAccess() {
        WebElement buttonGetAccess = findElementByNoThrow(widget, By.id("button-enter"));
        postponedAssertTrue(buttonGetAccess != null && buttonGetAccess.isDisplayed(), "Кнопка Получить доступ не видна");
        if (buttonGetAccess != null) {
            postponedAssertTrue(buttonGetAccess.isEnabled(), "Кнопка Получить доступ не активна");
            postponedAssertEquals(buttonGetAccess.getAttribute("value"), "Получить доступ",
                    "Текст на кнопке не совпадает");
        }
    }

    @Step("Проверить, что Отображается крестик (закрыть форму)")
    public void checkButtonClose() {
        WebElement iconClose = findElementByNoThrow(widget, By.cssSelector("#popup_content_predemo .popup__close"));
        postponedAssertTrue(iconClose != null && iconClose.isDisplayed(), "Иконка Крестик (закрыть форму) не отображается");
    }

    @Step("Нажать на кнопку Крестик")
    public void clickOnIconClose() {
        WebElement iconClose = findElementByNoThrow(widget, By.cssSelector("#popup_content_predemo .popup__close"));
        iconClose.click();
        waitForReloadingPage();
    }

    @Step("Проверить, что кнопка Получить доступ не видна")
    public void checkButtonGetAccessIsNotPresent() {
        WebElement buttonGetAccess = findElementByNoThrow(widget, By.id("button-enter"));
        postponedAssertFalse(buttonGetAccess.isDisplayed(), "Кнопка Получить доступ видна");
    }

    public int getYPositionForGetAccessButton() {
        Object value = executeScript("return document.getElementById('button-enter').getBoundingClientRect().top");
        if (value instanceof Double) {
            return ((Double) value).intValue();
        } else if (value instanceof Long) {
            return ((Long) value).intValue();
        } else {
            try {
                return (Integer) value;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Не получилось взять верхнее положение кнопки Получить демодоступ");
            }
        }
    }

    @Step("Проверить, что отображается фото")
    public void checkBackgroundPhoto(String photoName) {
        WebElement backgroundPhoto = findElementBy(widget, By.cssSelector(".popup__in"));
        String backgroundPhotoName = backgroundPhoto.getCssValue("background-image");
        postponedAssertTrue(backgroundPhotoName.contains(photoName), "Название фото:" + photoName + " не найдено в " +
                "стиле css background:" + backgroundPhotoName);
    }

    @Step("Проверить, что отображается лого")
    public void checkBackgroundLogo(String logoName) {
        String backgroundLogoName = hookForGettingLogo();
        postponedAssertTrue(backgroundLogoName.contains(logoName), "Название лого:" + logoName + " не найдено в " +
                "стиле css background-image:" + backgroundLogoName);
    }

    public void hookForScrolling() {
        executeScript("arguments[0].scrollTop = arguments[1];", widget, 500);
    }

    private String hookForGettingLogo() {
        return (String) executeScript("return window.getComputedStyle(document.querySelector('" +
                "#popup_content_predemo .popup__in'),':before').getPropertyValue('background-image')");
    }
}

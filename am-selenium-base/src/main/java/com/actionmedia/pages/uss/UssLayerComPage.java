package com.actionmedia.pages.uss;

import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 19.11.2014
 * Time: 22:42
 */
@Component
public class UssLayerComPage extends UssBasePage<UssLayerComPage> {

    @Step("Проверяется что ссылка в личный кабинет отображается на странице layercom.ru")
    public UssLayerComPage checkLinkToProfileIsPresent() {
        WebElement header = waitForPresenceOfElementLocatedBy(By.cssSelector(".rx-userbar"));
        WebElement linkToProfile = findElementByNoThrow(header, By.cssSelector("[href*='/uracademy/profile/']"));
        postponedAssertNotNull(linkToProfile, "Ссылка в личный кабинет не найдена на странице layercom.ru");
        if (linkToProfile != null) {
            postponedAssertTrue(linkToProfile.isDisplayed(), "Ссылка в личный кабинет не отображается на странице layercom.ru");
        }
        return this;
    }

    @Step("Нажать на кнопку 'Вход'")
    public UssLayerComPage clickEnterButton() {
        waitForPresenceOfElementLocatedBy(By.cssSelector(".rx-button-branded"), "Кнопка 'Вход' не найдена на странице layercom.ru").click();
        return this;
    }

    @Step("Ввести логин")
    public UssLayerComPage inputEmail(String email) {
        WebElement emailField = waitForPresenceOfElementLocatedBy(By.name("login"), "Поля для логина не найдено на странице layercom.ru");
        getWebElementWrapper(emailField).getTextField().clearAndType(email);
        return this;
    }

    @Step("Ввести пароль")
    public UssLayerComPage inputPassword(String password) {
        WebElement passwordField = waitForPresenceOfElementLocatedBy(By.name("pass"), "Поля для пароля не найдено на странице layercom.ru");
        getWebElementWrapper(passwordField).getTextField().clearAndType(password);
        return this;
    }

    @Step("Нажать на кнопку 'Войти'")
    public UssLayerComPage clickLoginButton() {
        waitForPresenceOfElementLocatedBy(By.id("rx-form-submit"), "Кнопка 'Войти' не найдена на странице layercom.ru").click();
        waitForReloadingPage();
        return this;
    }

    @Step("Нажать на кнопку 'Выход'")
    public UssLayerComPage clickLogoutButton() {
        waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='Account/LogOut']"), "Кнопка 'Выход' не найдена").click();
        waitForReloadingPage();
        return this;
    }
}

package com.actionmedia.pages.id2;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 11.11.2014
 * Time: 1:15
 */
@Component
public class Id2BasePage<P extends BasePage> extends BasePage<P> {

    @Step("Ввести логин")
    public Id2BasePage inputLogin(String login) {
        TextField loginField = getWebElementWrapper(waitForPresenceOfElementLocatedBy(By.id("rx-user-field"))).getTextField();
        loginField.clearAndType(login);
        return this;
    }

    @Step("Ввести пароль")
    public Id2BasePage inputPassword(String password) {
        TextField passwordField = getWebElementWrapper(waitForPresenceOfElementLocatedBy(By.id("rx-pass-field"))).getTextField();
        passwordField.clearAndType(password);
        return this;
    }

    @Step("Нажать кнопку 'Войти'")
    public Id2BasePage clickLogin() {
        waitForPresenceOfElementLocatedBy(By.id("rx-form-submit")).click();
        waitForReloadingPage();
        return this;
    }

    public boolean isLoginErrorPresent() {
        WebElement page = waitForPresenceOfElementLocatedBy(By.cssSelector(".page"));
        WebElement emptyUser = findElementByNoThrow(page, By.id("rx-hint-empty-user"));
        WebElement wrongUser = findElementByNoThrow(page, By.id("rx-hint-wrong-user"));
        WebElement notSubmittedUser = findElementByNoThrow(page, By.id("rx-hint-notsubmitted-user"));
        WebElement emptyPass = findElementByNoThrow(page, By.id("rx-hint-empty-pass"));
        WebElement wrongPass = findElementByNoThrow(page, By.id("rx-hint-wrong-pass"));
        WebElement errorRemindPass = findElementByNoThrow(page, By.id("rx-hint-error-remind-pass"));
        return emptyUser != null && !emptyUser.isDisplayed() ||
                wrongUser != null && !wrongUser.isDisplayed() ||
                notSubmittedUser != null && !notSubmittedUser.isDisplayed() ||
                emptyPass != null && !emptyPass.isDisplayed() ||
                wrongPass != null && !wrongPass.isDisplayed() ||
                errorRemindPass != null && !errorRemindPass.isDisplayed();
    }

    public boolean isAboutMeLinkPresent() {
        WebElement page = waitForPresenceOfElementLocatedBy(By.cssSelector(".page"));
        WebElement aboutMeLink = findElementByNoThrow(page, By.cssSelector("[href*='/Personal/About']"));
        return aboutMeLink != null;
    }

    @Step("Выйти из id2")
    public Id2BasePage logout() {
        WebElement userName = findElementByNoThrow(By.id("id2-rx-user-buttontitle"));
        if (userName != null) {
            userName.click();
            waitForReloadingPage();
            WebElement logoutButton = waitForPresenceOfElementLocatedBy(By.cssSelector("id2-rx-user-informer-popup-header-link-exit"));
            logoutButton.click();
        }
        return this;
    }
}

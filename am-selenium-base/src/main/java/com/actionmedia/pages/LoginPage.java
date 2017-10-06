package com.actionmedia.pages;

import com.actionmedia.autotest.selenium.annotations.Wait;
import com.actionmedia.autotest.selenium.context.AbstractPage;
import com.actionmedia.autotest.selenium.context.Login;
import com.actionmedia.autotest.selenium.elements.CheckBox;
import com.actionmedia.autotest.selenium.elements.TextField;
import com.actionmedia.base.BasePage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import javax.annotation.Nullable;
import java.io.IOException;

@Component
public class LoginPage extends BasePage<LoginPage> {

    @Wait
    @FindBy(name = "email")
    private TextField emailField;

    @Wait
    @FindBy(name = "password")
    private TextField passwordField;

    @Wait
    @FindBy(id = "login-keep-enter")
    private CheckBox rememberCheckbox;

    @FindBy(id = "page-register")
    @Wait
    @CacheLookup
    WebElement regSection;

    public <T extends AbstractPage> T navigateTo(final Login loginParameter, final Class<T> target) {
        maximize();
        super.login.set(loginParameter);
        return navigateTo(target, loginParameter.getUrl());
    }

//    public void setLogin(Login login) {
//        this.login = login;
//    }

    public <T extends AbstractPage> T login(final Class<T> pageClass) {
        closePopUp();

        //TODO new login approach with send post and set cookies to driver
//        if (isUserLogged()) {
//            return redirectTo(pageClass);
//        }
//        getDriver().manage().deleteAllCookies();
//        try {
//            Connection.Response response = loginBySendPost(login.getUrl() + "/site/customer/login/");
//
//            if (!response.parse().text().startsWith("true")) {
//                response = loginBySendPost(login.getUrl().replace("//", "//www.") + "/site/customer/login/");
//            }
//
//            Map<String, String> cookies = response.cookies();
//
//            for (Map.Entry<String, String> cookie : cookies.entrySet()) {
//                getDriver().manage().addCookie(new Cookie(cookie.getKey(), cookie.getValue()));
//            }
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
        if (!isUserLogged()) {
//            waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='/site/customer/logout/']")).click();
            waitForPresenceOfElementLocatedBy(By.cssSelector("[href*='#/customer/auth/']")).click();
            waitForReloadingPage();
        }
        if (isUserLogged()) {
            return redirectTo(pageClass);
        }

        if (!isEnterTabSelected()) {
            clickEnterTab();
            waitForReloadingPage();
        }

        emailField.clearAndType(login.get().getUser());
        passwordField.clearAndType(login.get().getPassword());

        unSelectRememberCheckBox();
        clickLoginButton();
        if (isUserLoggedError()) {
            fail("Ошибка при логине");
        } else {
            if (waiForUserLogged()) {
                report("Пользователь '" + login.get().getUser() + "' залогинен");
            } else {
                fail("Пользователь '" + login.get().getUser() + "' не залогинен после " + getTimeout() + " секунд");
            }
        }
        closePopUp();
        return redirectTo(pageClass);
    }

    private Connection.Response loginBySendPost(String url) throws IOException {
        return Jsoup
                .connect(url)
                .ignoreHttpErrors(true)
                .timeout(0)
                .data("login", login.get().getUser())
                .data("password", login.get().getPassword())
                .data("isremember", "no")
                .method(Connection.Method.POST)
                .execute();
    }

    public <T extends AbstractPage> T login(final Class<T> pageClass, String email, String password) {
        login.set(new Login(getSettings()));
        login.get().setUser(email);
        login.get().setPassword(password);

        if (!getSettings().isRunFss() && !isEnterTabSelected()) {
            clickEnterTab();
            waitForReloadingPage();
        }

        emailField.clearAndType(login.get().getUser());
        passwordField.clearAndType(login.get().getPassword());

        unSelectRememberCheckBox();
        clickLoginButton();
        if (isUserLoggedError()) {
            fail("Ошибка при логине");
        }
        return redirectTo(pageClass);
    }

    public <T extends AbstractPage> T login(final Class<T> pageClass, String url) {
        openUrl(url);
        login(pageClass);
        return redirectTo(pageClass);
    }

    public <T extends AbstractPage> T openUrl(final Class<T> pageClass, String url) {
        openUrl(url);
        return redirectTo(pageClass);
    }

    public <T extends AbstractPage> T loginToKonsultantPlus(final Class<T> pageClass, String url, String login, String password) {
        openUrl(url);
        WebElement loginField = waitForVisibilityOfElementLocatedBy(By.name("login"));
        WebElement passwordField = waitForVisibilityOfElementLocatedBy(By.name("pwd"));
        WebElement checkBox = waitForVisibilityOfElementLocatedBy(By.id("storepassword"));

        getWebElementWrapper(loginField).getTextField().clearAndType(login);
        getWebElementWrapper(passwordField).getTextField().clearAndType(password);

        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        WebElement loginButton = waitForVisibilityOfElementLocatedBy(By.id("btnOk"));
        loginButton.click();
        return redirectTo(pageClass);
    }

    private void clickLoginButton() {
        waitForPresenceOfElementLocatedBy(By.id("customer-enter"), "Кнопка 'Войти' не найдена").click();
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (Throwable e) {
        }
    }

    private boolean isUserLoggedError() {
        WebElement authForm;
        authForm = mainContentElement;
        return findElementByNoThrow(authForm, By.cssSelector(".form-error")) != null && findElementBy(authForm, By.cssSelector(".form-error")).isDisplayed();
    }

    private boolean isEnterTabSelected() {
        WebElement tabMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector("#whiteboard [data-tab-name='auth']"), "Форма авторизации не найдена");
        return tabMenu.getAttribute("class").contains("active");
    }

    private void clickEnterTab() {
        WebElement tabMenu = waitForVisibilityOfElementLocatedBy(By.cssSelector("#whiteboard [data-tab-name='auth'] span"), "Форма авторизации не найдена");
        tabMenu.click();
    }

    private Boolean waiForUserLogged() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), getTimeout());
            wait.until(isUserLog());
            return true;
        } catch (TimeoutException e) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), getTimeout());
                wait.until(isUserLog());
                return true;
            } catch (TimeoutException e1) {
                return false;
            }
        }
    }

    private ExpectedCondition<Boolean> isUserLog() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(@Nullable WebDriver driver) {
                WebElement header = waitForVisibilityOfElementLocatedBy(By.id("header"), "Заголовок не найден");
                WebElement loginBtn = findElementByNoThrow(header, By.id("user-enter"));
                return loginBtn != null && !loginBtn.getText().equals("Вход и регистрация");
            }
        };
    }

    public LoginPage unSelectRememberCheckBox() {
        if (rememberCheckbox.isSelected()) {
            rememberCheckbox.click();
        }
        return this;
    }

    public LoginPage selectRememberCheckBox() {
        if (!rememberCheckbox.isSelected()) {
            rememberCheckbox.click();
        }
        return this;
    }

    @Step("Проверяется что открыта страница авторизации")
    public LoginPage checkLoginPageIsOpened() {
        WebElement access = findElementByNoThrow(mainLeftElement, By.cssSelector("#whiteboard"));
        postponedAssertNotNull(access, "Страница авторизации не открыта");
        if (access != null) {
            postponedAssertTrue(access.isDisplayed(), "Страница авторизации не открыта");
        }
        return this;
    }

    @Step("Открыть секцию Демодоступ")
    public LoginPage chooseDemoSection() {
        WebElement demoLinkSection = findElementBy(By.id("wf-demo"));
        if (!demoLinkSection.getAttribute("class").contains("pressed")) {
            demoLinkSection.click();
            waitForReloadingPage();
        }
        return this;
    }

    @Step("Открыть секцию Активация подписки")
    public LoginPage chooseActivateSubscribe() {
        WebElement activateSection = findElementBy(By.id("wf-activate"));
        if (!activateSection.getAttribute("class").contains("pressed")) {
            activateSection.click();
            waitForReloadingPage();
        }
        return this;
    }

    @Step("Ввести в поле Эл.почта:{0}")
    public LoginPage typeEmail(String email) {
        WebElement inputEmail = findElementBy(regSection, By.id("email"), "Элемент Email не найден");
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }

    @Step("Ввести в поле Пароль:{0}")
    public LoginPage typePassword(String password) {
        WebElement inputPassword = findElementBy(regSection, By.name("password2"), "Элемент Password не найден");
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Ввести в поле Фамилия:{0}")
    public LoginPage typeLastName(String lastName) {
        WebElement inputLastName = findElementBy(regSection, By.name("lastName"), "Элемент LastName не найден");
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        return this;
    }

    @Step("Ввести в поле Имя:{0}")
    public LoginPage typeFirstName(String firstName) {
        WebElement inputFirstName = findElementBy(regSection, By.name("firstName"), "Элемент firstName не найден");
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @Step("Ввести в поле Отчество:{0}")
    public LoginPage typeSecondName(String secondName) {
        WebElement inputSecondName = findElementBy(regSection, By.name("secondName"), "Элемент secondName не найден");
        inputSecondName.clear();
        inputSecondName.sendKeys(secondName);
        return this;
    }

    @Step("Ввести префикс мобильного телефона:{0}")
    public LoginPage typePhonePrefix(String prefix) {
        WebElement inputPrefix = findElementBy(regSection, By.name("mobilePhonePrefix"), "Элемент Префикс не найден");
        inputPrefix.clear();
        inputPrefix.sendKeys(prefix);
        return this;
    }

    @Step("Ввести номер мобильного телефона:{0}")
    public LoginPage typePhoneNumber(String number) {
        WebElement inputNumber = findElementBy(regSection, By.name("mobilePhoneNumber"), "Элемент Номер моб.телефона не найден");
        inputNumber.clear();
        inputNumber.sendKeys(number);
        return this;
    }

    @Step("Ввести код из СМС:{0}")
    public LoginPage typeSmsCode(String code) {
        WebElement inputCode = findElementBy(regSection, By.id("activationCode"), "Элемент Код из СМС не найден");
        inputCode.clear();
        inputCode.sendKeys(code);
        return this;
    }

    @Step("Ввести контрольные цифры:{0}")
    public LoginPage typeCaptchaCode(String code) {
        WebElement inputCode = findElementBy(regSection, By.id("captcha"), "Элемент Контрольные цифры не найден");
        inputCode.clear();
        inputCode.sendKeys(code);
        return this;
    }

    @Step("Проверить, что кнопка Получить демодоступ активна")
    public LoginPage checkGetDemoButtonIsEnabled() {
        WebElement demoButton = waitForElementToBeClickable(By.name("button-demo"), "Кнопка не активна");
        postponedAssertTrue(demoButton.isEnabled(), "Кнопка Получить демодоступ не активна");
        return this;
    }

    @Step("Проверить, что кнопка Получить демодоступ не активна")
    public LoginPage checkGetDemoButtonIsDisabled() {
        WebElement demoButton = findElementBy(regSection, By.name("button-demo"), "Кнопка не найдена");
        waitForAttributeUpdate(demoButton, "disabled");
        postponedAssertFalse(demoButton.isEnabled(), "Кнопка Получить демодоступ активна");
        return this;
    }

    @Step("Кликнуть и вывести курсор из всех полей, установить фокус на браузере")
    public LoginPage clickOnSomeFreePlace() {
        WebElement labelEmail = findElementBy(By.xpath("//*[@id='page-register']//*[@id='email']/preceding-sibling::span"));
        labelEmail.click();
        executeScript("window.focus()");
        waitForReloadingPage();
        return this;
    }

    @Step("Установить фокус в поле Фамилия")
    public LoginPage clickOnLastNameInput() {
        WebElement inputLastName = findElementBy(regSection, By.name("lastName"), "Элемент LastName не найден");
        inputLastName.click();
        return this;
    }

    @Step("Установить фокус в поле Имя")
    public LoginPage clickOnFirstNameInput() {
        WebElement inputFirstName = findElementBy(regSection, By.name("firstName"), "Элемент firstName не найден");
        inputFirstName.click();
        return this;
    }

    @Step("Установить фокус в поле Отчество")
    public LoginPage clickOnSecondNameInput() {
        WebElement inputSecondName = findElementBy(regSection, By.name("secondName"), "Элемент firstName не найден");
        inputSecondName.click();
        return this;
    }

    @Step("Проверить, что выводится ошибка:{0}")
    public LoginPage checkErrorText(String text) {
        WebElement labelErrorText = waitForPresenceOfElementLocatedBy(By.cssSelector(".form-error-text"));
        postponedAssertFalse(labelErrorText.getText().isEmpty(), "Ошибка пустая");
        postponedAssertEquals(labelErrorText.getText().trim(), text, "Ошибка написана неверно");
        return this;
    }

    @Step("Очистить поля Фамилия Имя Отчество")
    public LoginPage clearFieldsFullName() {
        WebElement inputLastName = findElementBy(regSection, By.name("lastName"), "Элемент LastName не найден");
        WebElement inputFirstName = findElementBy(regSection, By.name("firstName"), "Элемент firstName не найден");
        WebElement inputSecondName = findElementBy(regSection, By.name("secondName"), "Элемент firstName не найден");

        inputLastName.clear();
        inputFirstName.clear();
        inputSecondName.clear();
        return this;
    }

    @Step("Проверить, что ошибки не выводятся")
    public LoginPage checkErrorTextIsNotPresent() {
        WebElement labelErrorText = findElementByNoThrow(By.cssSelector(".form-error-text"));
        postponedAssertTrue(labelErrorText == null || labelErrorText.getText().isEmpty(), "Ошибка выводится");
        return this;
    }

    @Step("Установить галочку Вхожу в первый раз")
    public LoginPage checkEnterFirstTime() {
        CheckBox firstTime = getWebElementWrapper(findElementBy(By.id("first-time"))).getCheckBox();
        if (!firstTime.isSelected()) {
            firstTime.click();
            waitForReloadingPage();
        }
        return this;
    }

    @Step("Ввести Логин на вкладке Вход в систему")
    public LoginPage typeLogin() {
        emailField.clearAndType(login.get().getUser());
        return this;
    }

    @Step("Ввести Пароль на вкладке Вход в систему")
    public LoginPage typePassword() {
        passwordField.clearAndType(login.get().getPassword());
        return this;
    }

    @Step("Нажать на значок Глаз в поле пароля")
    public LoginPage clickOnEyeIconOnPasswordField() {
        WebElement passwordIcon = findElementBy(By.cssSelector(".form__item_content_password-show a"));
        passwordIcon.click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверить, что пароль стал видимым после нажатия на Глаз")
    public LoginPage checkPasswordBecameVisible() {
        WebElement password2 = findElementByNoThrow(By.name("password2"));
        postponedAssertNotNull(password2, "Пароль невидим");
        if (password2 != null) {
            String visiblePassword = password2.getAttribute("value");
            postponedAssertEquals(visiblePassword, login.get().getPassword(), "Пароли несовпадают");
        }
        return this;
    }

    @Step("Проверить, что стоит галочка входить автоматически")
    public LoginPage checkAutoLoggingIsActive() {
        postponedAssertTrue(rememberCheckbox.isSelected(), "Галочка Входить автоматически не стоит");
        return this;
    }

    @Step("Нажать на кнопку Войти и авторизоваться")
    public <T extends AbstractPage> T clickOnEnterButton(final Class<T> pageClass) {
        clickLoginButton();
        waiForUserLogged();
        return redirectTo(pageClass);
    }

    @Step("Проверить, что отображается поле Эл.почта")
    public LoginPage checkEmailFieldIsPresent() {
        WebElement email = findElementByNoThrow(regSection, By.name("email"));
        postponedAssertNotNull(email, "Поле Эл.почта не отображено");
        if (email != null) {
            postponedAssertTrue(email.isDisplayed(), "Поле Эл.почта не отображено");
        }
        return this;
    }

    @Step("Проверить, что отображается поле Пароль")
    public LoginPage checkPasswordFieldIsPresent() {
        WebElement password = findElementByNoThrow(regSection, By.name("password2"));
        postponedAssertNotNull(password, "Поле Пароль не отображено");
        if (password != null) {
            postponedAssertTrue(password.isDisplayed(), "Поле Пароль не отображено");
        }
        return this;
    }

    @Step("Проверить, что отображается поля ФИО")
    public LoginPage checkFullNameFieldsArePresent() {
        WebElement lastname = findElementByNoThrow(regSection, By.name("lastName"));
        postponedAssertNotNull(lastname, "Поле Фамилия не отображено");
        if (lastname != null) {
            postponedAssertTrue(lastname.isDisplayed(), "Поле Фамилия не отображено");
        }

        WebElement firstName = findElementByNoThrow(regSection, By.name("firstName"));
        postponedAssertNotNull(firstName, "Поле Имя не отображено");
        if (firstName != null) {
            postponedAssertTrue(firstName.isDisplayed(), "Поле Имя не отображено");
        }

        WebElement secondName = findElementByNoThrow(regSection, By.name("secondName"));
        postponedAssertNotNull(secondName, "Поле Отчество не отображено");
        if (secondName != null) {
            postponedAssertTrue(secondName.isDisplayed(), "Поле Отчество не отображено");
        }
        return this;
    }

    @Step("Проверить, что отображаются поля Моб.телефон")
    public LoginPage checkPhoneFieldsArePresent() {
        WebElement phoneCode = findElementByNoThrow(regSection, By.name("mobilePhoneCode"));
        postponedAssertNotNull(phoneCode, "Поле Код телефона не отображено");
        if (phoneCode != null) {
            postponedAssertTrue(phoneCode.isDisplayed(), "Поле Код телефона не отображено");
        }

        WebElement phonePrefix = findElementByNoThrow(regSection, By.name("mobilePhonePrefix"));
        postponedAssertNotNull(phonePrefix, "Поле Префикс телефона не отображено");
        if (phonePrefix != null) {
            postponedAssertTrue(phonePrefix.isDisplayed(), "Поле Префикс телефона не отображено");
        }

        WebElement phoneNumber = findElementByNoThrow(regSection, By.name("mobilePhoneNumber"));
        postponedAssertNotNull(phoneNumber, "Поле Номер телефона не отображено");
        if (phoneNumber != null) {
            postponedAssertTrue(phoneNumber.isDisplayed(), "Поле Номер телефона не отображено");
        }
        return this;
    }

    @Step("Проверить, что отображается поле Контрольные цифры")
    public LoginPage checkCaptchaFieldIsPresent() {
        WebElement captcha = findElementByNoThrow(regSection, By.id("captcha"));
        postponedAssertNotNull(captcha, "Поле Контрольные цифры не отображено");
        if (captcha != null) {
            postponedAssertTrue(captcha.isDisplayed(), "Поле Контрольные цифры не отображено");
        }
        return this;
    }

    @Step("Проверить, что отображается Капча")
    public LoginPage checkCaptchaImageIsPresent() {
        WebElement captchaImg = findElementByNoThrow(regSection, By.id("captcha-img"));
        postponedAssertNotNull(captchaImg, "Картинка каптча не отображена");
        if (captchaImg != null) {
            postponedAssertTrue(captchaImg.isDisplayed(), "Картинка каптча не отображена");
        }
        return this;
    }

    @Step("Проверить, что отображается кнопка Зарегистрироваться")
    public LoginPage checkRegistrationButtonIsPresent() {
        WebElement buttonReg = findElementByNoThrow(regSection, By.name("button-demo"));
        postponedAssertNotNull(buttonReg, "Кнопка Зарегистрироваться не отображена");
        if (buttonReg != null) {
            postponedAssertTrue(buttonReg.isDisplayed(), "Кнопка Зарегистрироваться не отображена");
            postponedAssertEquals(buttonReg.getText(), "Зарегистрироваться", "Текст на кнопке не совпадает");
        }
        return this;
    }
}

package com.actionmedia.pages.fss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.RightPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 17:48
 */
@Component
public class FssPersonalCabinetPage extends FssBasePage<FssPersonalCabinetPage> {

    private RightPanel rightPanel;

    @Override
    public void handleRedirect() {
        super.handleRedirect();
        rightPanel = getHelper(RightPanel.class, this);
    }

    @Step("Проверяются элементы на вкладке Персональные данные")
    public FssPersonalCabinetPage checkDefaultStatePersonalInfoTab() {
        checkPersonalInfoTabHeader();
        checkTabsIsPresent();
        checkPersonalInfoFields();
        return this;
    }

    @Step("Проверяются элементы на вкладке Изменить пароль")
    public FssPersonalCabinetPage checkDefaultStateChangePasswordTab() {
        checkChangePasswordTabHeader();
        checkTabsIsPresent();
        checkChangePasswordFields();
        return this;
    }

    @Step("Проверяются элементы на вкладке Активировать код")
    public FssPersonalCabinetPage checkDefaultStateActivationCodeTab() {
        checkActivationCodeTabHeader();
        checkTabsIsPresent();
        checkActivationCodeFields();
        return this;
    }

    public FssPersonalCabinetPage checkPersonalInfoTabHeader() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-data"));
        WebElement header = content.findElement(By.cssSelector(".doc-header"));
        postponedAssertEquals(header.getText(), "ПЕРСОНАЛЬНЫЕ ДАННЫЕ", "Неправильный заголовок страницы Персональные данные");
        return this;
    }

    public FssPersonalCabinetPage checkTabsIsPresent() {
        WebElement personalInfoTab = findElementByNoThrow(sidebarElement, By.cssSelector("[data-action='PPPersonalData']"));
        WebElement changePasswordTab = findElementByNoThrow(sidebarElement, By.cssSelector("[data-action='PPChangePassword']"));
        WebElement activationTab = findElementByNoThrow(sidebarElement, By.cssSelector("[data-action='PPActivateAccess']"));

        postponedAssertNotNull(personalInfoTab, "Вкладка Персональные данные не найдена");
        postponedAssertNotNull(changePasswordTab, "Вкладка Изменить пароль не найдена");
        postponedAssertNotNull(activationTab, "Вкладка Активировать код не найдена");

        postponedAssertTrue(personalInfoTab.isDisplayed(), "Вкладка Персональные данные не найдена");
        postponedAssertTrue(changePasswordTab.isDisplayed(), "Вкладка Изменить пароль не найдена");
        postponedAssertTrue(activationTab.isDisplayed(), "Вкладка Активировать код не найдена");
        return this;
    }

    public FssPersonalCabinetPage checkPersonalInfoFields() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-data"));

        WebElement loginField = findElementByNoThrow(content, By.id("login"));
        WebElement emailField = findElementByNoThrow(content, By.id("email"));
        WebElement lastNameField = findElementByNoThrow(content, By.id("lastName"));
        WebElement firstNameField = findElementByNoThrow(content, By.id("firstName"));
        WebElement secondNameField = findElementByNoThrow(content, By.id("secondName"));
        WebElement phonePrefixField = findElementByNoThrow(content, By.id("phonePrefix"));
        WebElement phoneNumberField = findElementByNoThrow(content, By.id("phoneNumber"));
        WebElement phonePostfixField = findElementByNoThrow(content, By.id("phonePostfix"));
        WebElement mobilePhonePrefixField = findElementByNoThrow(content, By.id("mobilePhonePrefix"));
        WebElement mobilePhoneNumberField = findElementByNoThrow(content, By.id("mobilePhoneNumber"));
        WebElement activationCodeField = findElementByNoThrow(content, By.id("activationCode"));
        WebElement companyField = findElementByNoThrow(content, By.id("company"));
        WebElement cityField = findElementByNoThrow(content, By.id("city"));
        WebElement addressField = findElementByNoThrow(content, By.id("address"));

        WebElement smsButton = findElementByNoThrow(content, By.id("button-sms"));
        WebElement saveButton = findElementByNoThrow(content, By.cssSelector("[value='Сохранить']"));
        WebElement activateButton = findElementByNoThrow(content, By.id("activate-code-btn"));
        WebElement subscribeButton = findElementByNoThrow(content, By.xpath("//a[text()='Подписаться']"));

        postponedAssertNotNull(loginField, "Поле для ввода логина не найдено");
        postponedAssertNotNull(emailField, "Поле для ввода email не найдено");
        postponedAssertNotNull(lastNameField, "Поле для ввода фамилии не найдено");
        postponedAssertNotNull(firstNameField, "Поле для ввода имени не найдено");
        postponedAssertNotNull(secondNameField, "Поле для ввода отчества не найдено");
        postponedAssertNotNull(phonePrefixField, "Поле для ввода кода телефона не найдено");
        postponedAssertNotNull(phoneNumberField, "Поле для ввода номера телефона не найдено");
        postponedAssertNotNull(phonePostfixField, "Поле для ввода добавочного номера телефона не найдено");
        postponedAssertNotNull(mobilePhonePrefixField, "Поле для ввода кода мобильного телефона не найдено");
        postponedAssertNotNull(mobilePhoneNumberField, "Поле для ввода номера мобильного телефона не найдено");
        postponedAssertNotNull(activationCodeField, "Поле для ввода кода активации не найдено");
        postponedAssertNotNull(companyField, "Поле для ввода компании не найдено");
        postponedAssertNotNull(cityField, "Поле для ввода города не найдено");
        postponedAssertNotNull(addressField, "Поле для ввода адреса не найдено");

        postponedAssertNotNull(smsButton, "Кнопка Подтвердить не найдена");
        postponedAssertNotNull(saveButton, "Кнопка Сохранить не найдена");
        postponedAssertNotNull(activateButton, "Кнопка Активировать не найдена");
        postponedAssertNotNull(subscribeButton, "Кнопка Подписаться не найдена");

        postponedAssertTrue(loginField.isDisplayed(), "Поле для ввода логина не отображается");
        postponedAssertTrue(emailField.isDisplayed(), "Поле для ввода email не отображается");
        postponedAssertTrue(lastNameField.isDisplayed(), "Поле для ввода фамилии не отображается");
        postponedAssertTrue(firstNameField.isDisplayed(), "Поле для ввода имени не отображается");
        postponedAssertTrue(secondNameField.isDisplayed(), "Поле для ввода отчества не отображается");
        postponedAssertTrue(phonePrefixField.isDisplayed(), "Поле для ввода кода телефона не отображается");
        postponedAssertTrue(phoneNumberField.isDisplayed(), "Поле для ввода номера телефона не отображается");
        postponedAssertTrue(phonePostfixField.isDisplayed(), "Поле для ввода добавочного номера телефона не отображается");
        postponedAssertTrue(mobilePhonePrefixField.isDisplayed(), "Поле для ввода кода мобильного телефона не отображается");
        postponedAssertTrue(mobilePhoneNumberField.isDisplayed(), "Поле для ввода номера мобильного телефона не отображается");
        postponedAssertTrue(activationCodeField.isDisplayed(), "Поле для ввода кода активации не отображается");
        postponedAssertTrue(companyField.isDisplayed(), "Поле для ввода компании не отображается");
        postponedAssertTrue(cityField.isDisplayed(), "Поле для ввода города не отображается");
        postponedAssertTrue(addressField.isDisplayed(), "Поле для ввода адреса не отображается");

        postponedAssertTrue(smsButton.isDisplayed(), "Кнопка Подтвердить не отображается");
        postponedAssertTrue(saveButton.isDisplayed(), "Кнопка Сохранить не отображается");
        postponedAssertTrue(activateButton.isDisplayed(), "Кнопка Активировать не отображается");
        postponedAssertTrue(subscribeButton.isDisplayed(), "Кнопка Подписаться не отображается");
        return this;
    }

    public FssPersonalCabinetPage checkChangePasswordTabHeader() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-change-password"));
        WebElement header = content.findElement(By.cssSelector(".doc-header"));
        postponedAssertEquals(header.getText(), "ИЗМЕНИТЬ ПАРОЛЬ", "Неправильный заголовок страницы Изменить пароль");
        return this;
    }

    public FssPersonalCabinetPage checkChangePasswordFields() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-change-password"));

        WebElement currentPassword = findElementByNoThrow(content, By.id("password"));
        WebElement newPassword = findElementByNoThrow(content, By.id("newpassword"));
        WebElement newPassword2 = findElementByNoThrow(content, By.id("newpassword2"));

        WebElement restorePassword = findElementByNoThrow(content, By.cssSelector(".show-password-restore"));
        WebElement showPassword = findElementByNoThrow(content, By.cssSelector(".toggle-password-visible"));
        WebElement changeButton = findElementByNoThrow(content, By.id("button-change"));

        postponedAssertNotNull(currentPassword, "Поле для ввода старого пароля не найдено");
        postponedAssertNotNull(newPassword, "Поле для ввода нового пароля не найдено");
        postponedAssertNotNull(newPassword2, "Поле для повтора нового пароля не найдено");

        postponedAssertNotNull(restorePassword, "Кнопка напомнить пароль не найдена");
        postponedAssertNotNull(showPassword, "Кнопка показать пароль не найдена");
        postponedAssertNotNull(changeButton, "Кнопка Изменить не найдена");

        postponedAssertTrue(currentPassword.isDisplayed(), "Поле для ввода старого пароля не отображается");
        postponedAssertTrue(newPassword.isDisplayed(), "Поле для ввода нового пароля не отображается");
        postponedAssertTrue(newPassword2.isDisplayed(), "Поле для повтора нового пароля не отображается");

        postponedAssertTrue(restorePassword.isDisplayed(), "Кнопка напомнить пароль не отображается");
        postponedAssertTrue(showPassword.isDisplayed(), "Кнопка показать пароль не отображается");
        postponedAssertTrue(changeButton.isDisplayed(), "Кнопка Изменить не отображается");
        return this;
    }

    public FssPersonalCabinetPage checkActivationCodeTabHeader() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-access"));
        WebElement header = content.findElement(By.cssSelector(".doc-header"));
        postponedAssertEquals(header.getText(), "АКТИВАЦИЯ КОДА ДОСТУПА", "Неправильный заголовок страницы Активация кода доступа");
        return this;
    }

    public FssPersonalCabinetPage checkActivationCodeFields() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.id("personal-page-access"));
        List<WebElement> codeFields = findElementsByNoThrow(content, By.cssSelector("[id*='code-part-']"));
        WebElement activationButton = findElementByNoThrow(content, By.id("button-activate"));
        postponedAssertNotNull(codeFields, "Поле для ввода кода доступа не найдено");
        postponedAssertNotNull(activationButton, "Кнопка Активировать не найдена");
        postponedAssertTrue(codeFields.size() == 5, "Количество полей для ввода кода не равно пяти");
        postponedAssertTrue(activationButton.isDisplayed(), "Кнопка Активировать не отображается");
        return this;
    }

    @Step("Открыть вкладку Персональные данные")
    public FssPersonalCabinetPage clickPersonalInfoTab() {
        WebElement personalInfo = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-action='PPPersonalData']"));
        personalInfo.click();
        return this;
    }

    @Step("Открыть вкладку Изменить пароль")
    public FssPersonalCabinetPage clickChangePasswordTab() {
        WebElement changePassword = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-action='PPChangePassword']"));
        changePassword.click();
        return this;
    }

    @Step("Открыть вкладку Активировать код")
    public FssPersonalCabinetPage clickActivationCodeTab() {
        WebElement activationCode = waitForVisibilityOfElementLocatedBy(By.cssSelector("[data-action='PPActivateAccess']"));
        activationCode.click();
        return this;
    }

    public FssPersonalCabinetPage checkAccessInfoInCollapsedIsDisplayed() {
        rightPanel.checkAccessInfoInCollapsedIsDisplayed();
        return this;
    }

    public FssPersonalCabinetPage checkAccessInfoIsCollapsedNotDisplayed() {
        rightPanel.checkAccessInfoIsCollapsedNotDisplayed();
        return this;
    }

    public FssPersonalCabinetPage checkAccessInfoInCollapsedContainsValue(String value) {
        rightPanel.checkAccessInfoInCollapsedContainsValue(value);
        return this;
    }

    public FssPersonalCabinetPage checkAccessInfoInExpandedContainsValue(String value) {
        rightPanel.checkAccessInfoInExpandedContainsValue(value);
        return this;
    }

    public FssPersonalCabinetPage checkAccessInfoInExpandedIsDisplayed() {
        rightPanel.checkAccessInfoInExpandedIsDisplayed();
        return this;
    }

    public FssPersonalCabinetPage checkViewedTabInCollapsedIsOpened() {
        rightPanel.checkViewedTabInCollapsedIsOpened();
        return this;
    }

    public FssPersonalCabinetPage checkViewedTabInExpandedIsOpened() {
        rightPanel.checkViewedTabInExpandedIsOpened();
        return this;
    }

    public FssPersonalCabinetPage checkViewedTabInCollapsedIsNotEmpty() {
        rightPanel.checkViewedTabInCollapsedIsNotEmpty();
        return this;
    }

    public FssPersonalCabinetPage checkActiveTabInExpandedIsNotEmpty() {
        rightPanel.checkActiveTabInExpandedIsNotEmpty();
        return this;
    }

    public FssPersonalCabinetPage clickAccessListTabInCollapsed() {
        rightPanel.clickAccessListTabInCollapsed();
        return this;
    }

    public FssPersonalCabinetPage clickAccessListTabInExpanded() {
        rightPanel.clickAccessListTabInExpanded();
        return this;
    }

    public FssPersonalCabinetPage clickViewedTabInCollapsed() {
        rightPanel.clickViewedTabInCollapsed();
        return this;
    }

    public FssPersonalCabinetPage clickViewedTabInExpanded() {
        rightPanel.clickViewedTabInExpanded();
        return this;
    }

    public FssPersonalCabinetPage openRandomItemInAccessList() {
        rightPanel.openRandomItemInAccessList();
        return this;
    }

    public FssPersonalCabinetPage closeRandomItemInAccessList() {
        rightPanel.closeRandomItemInAccessList();
        return this;
    }

    public FssPersonalCabinetPage clickExtendPopularBlock() {
        getHelper(FssHelpers.class).clickExtendPopularBlock();
        return this;
    }

    public FssPersonalCabinetPage closePopularBlock() {
        rightPanel.closePopularBlock();
        return this;
    }

    @Step("Нажать на кнопку 'Активировать'")
    public FssPersonalCabinetPage clickActivateButton() {
        WebElement content = getPage();
        WebElement activationButton = content.findElement(By.id("activate-code-btn"));
        activationButton.click();
        return this;
    }
}

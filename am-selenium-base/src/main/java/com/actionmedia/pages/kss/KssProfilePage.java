package com.actionmedia.pages.kss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.PersonInfo;
import com.actionmedia.pages.helpers.ProfileBasePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 18:10
 */
@Component
public class KssProfilePage extends KssBasePage<KssProfilePage> {

    @Step("Проверяется что блок Персональные данные отображается")
    public KssProfilePage checkPersonalInfoIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement personalInfoBlock = findElementByNoThrow(mainLeftElement, By.id("personal-data"));
        postponedAssertNotNull(personalInfoBlock, "Блок Персональные данные не найден");
        postponedAssertTrue(personalInfoBlock.isDisplayed(), "Блок Персональные данные не отображается");
        return this;
    }

    @Step("Проверяется что элементы в блоке Персональные данные отображаются")
    public KssProfilePage checkFieldsInPersonalInfoBlock() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement loginField;
        if (findElementByNoThrow(content, By.id("login")) != null) {
            loginField = findElementByNoThrow(content, By.id("login"));
        } else {
            WebElement loginText = content.findElement(By.xpath("//span[text()='Логин']"));
            loginField = findElementByNoThrow(getParentElement(loginText), By.cssSelector("[class*='form-']"));
        }

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

        WebElement positionField = findElementByNoThrow(content, By.id("position"));
        WebElement companyField = findElementByNoThrow(content, By.id("company"));
        WebElement activityField = findElementByNoThrow(content, By.id("activitySphere"));
        WebElement companySizeField = findElementByNoThrow(content, By.id("companySize"));

        WebElement smsButton = findElementByNoThrow(content, By.id("button-sms"));
        WebElement changeButton = findElementByNoThrow(content, By.id("button-change"));
        WebElement activateButton = findElementByNoThrow(content, By.cssSelector("[href*='#/customer/activate-code/']"));

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
        postponedAssertNotNull(positionField, "Поле для ввода должности не найдено");
        postponedAssertNotNull(activityField, "Поле для ввода сферы деятельности не найдено");
        postponedAssertNotNull(companySizeField, "Поле для ввода численности сотрудников не найдено");

        postponedAssertNotNull(smsButton, "Кнопка Подтвердить не найдена");
        postponedAssertNotNull(changeButton, "Кнопка Изменить не найдена");
        postponedAssertNotNull(activateButton, "Кнопка Активировать не найдена");

        checkElementIsDisplayed(loginField, "Поле для ввода логина не отображается");
        checkElementIsDisplayed(emailField, "Поле для ввода email не отображается");
        checkElementIsDisplayed(lastNameField, "Поле для ввода фамилии не отображается");
        checkElementIsDisplayed(firstNameField, "Поле для ввода имени не отображается");
        checkElementIsDisplayed(secondNameField, "Поле для ввода отчества не отображается");
        checkElementIsDisplayed(phonePrefixField, "Поле для ввода кода телефона не отображается");
        checkElementIsDisplayed(phoneNumberField, "Поле для ввода номера телефона не отображается");
        checkElementIsDisplayed(phonePostfixField, "Поле для ввода добавочного номера телефона не отображается");
        checkElementIsDisplayed(mobilePhonePrefixField, "Поле для ввода кода мобильного телефона не отображается");
        checkElementIsDisplayed(mobilePhoneNumberField, "Поле для ввода номера мобильного телефона не отображается");
        checkElementIsDisplayed(activationCodeField, "Поле для ввода кода активации не отображается");
        checkElementIsDisplayed(companyField, "Поле для ввода компании не отображается");
        checkElementIsDisplayed(positionField, "Поле для ввода должности не отображается");
        checkElementIsDisplayed(activityField, "Поле для ввода сферы деятельности не отображается");
        checkElementIsDisplayed(companySizeField, "Поле для ввода численности сотрудников не отображается");

        checkElementIsDisplayed(smsButton, "Кнопка Подтвердить не отображается");
        checkElementIsDisplayed(changeButton, "Кнопка Изменить не отображается");
        checkElementIsDisplayed(activateButton, "Кнопка Активировать не отображается");
        return this;
    }

    @Step("Проверяется что блок Мои сервисы отображается")
    public KssProfilePage checkMyServicesBlockIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement myServicesHeader = findElementByNoThrow(mainLeftElement, By.xpath("//span[text()='Мои сервисы']"));
        postponedAssertNotNull(myServicesHeader, "Блок Мои сервисы не найден");
        checkElementIsDisplayed(myServicesHeader, "Блок Мои сервисы не отображается");
        if (myServicesHeader != null) {
            WebElement myServicesBlock = getParentElement(getParentElement(getParentElement(myServicesHeader)));
            WebElement header = myServicesBlock.findElement(By.cssSelector(".open-block"));
            WebElement body = myServicesBlock.findElement(By.cssSelector(".subscription-table"));
            postponedAssertEquals(header.getText(), "Мои сервисы", "Неправильный текст заголовка блока Мои сервисы");
            postponedAssertFalse(body.getText().isEmpty(), "Блок Мои сервисы пустой");
        }
        return this;
    }

    @Step("Проверяется что блок Мое обучение отображается")
    public KssProfilePage checkMyEducationBlockIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement myEducationBlock = findElementByNoThrow(mainLeftElement, By.cssSelector(".my-training"));
        postponedAssertNotNull(myEducationBlock, "Блок Мое обучение не найден");
        checkElementIsDisplayed(myEducationBlock, "Блок Мое обучение не отображается");
        if (myEducationBlock != null) {
            WebElement header = myEducationBlock.findElement(By.cssSelector(".open-block"));
            WebElement body = myEducationBlock.findElement(By.cssSelector(".subscription-table"));
            postponedAssertEquals(header.getText(), "Мое обучение и сервисы", "Неправильный текст заголовка блока Мое обучение");
            postponedAssertFalse(body.getText().isEmpty(), "Блок Мое обучение пустой");
        }
        return this;
    }

    @Step("Проверяется что блок Мои рассылки отображается")
    public KssProfilePage checkMySubsriptionBlockIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement mySubscriptionBlock = findElementByNoThrow(mainLeftElement, By.id("subscriptionManager"));
        postponedAssertNotNull(mySubscriptionBlock, "Блок Мои рассылки не найден");
        checkElementIsDisplayed(mySubscriptionBlock, "Блок Мои рассылки не отображается");
        if (mySubscriptionBlock != null) {
            WebElement header = mySubscriptionBlock.findElement(By.cssSelector(".normal"));
            WebElement body = mySubscriptionBlock.findElement(By.cssSelector(".subscription-table"));
            postponedAssertEquals(header.getText(), "Управление рассылками", "Неправильный текст заголовка блока Мои рассылки");
            postponedAssertFalse(body.getText().isEmpty(), "Блок Мои рассылки пустой");
        }
        return this;
    }

    @Step("Проверяется что блок Мои доступы отображается")
    public KssProfilePage checkMyAccessListBlockIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement mySubscriptionBlock = findElementByNoThrow(mainLeftElement, By.id("accessList"));
        postponedAssertNotNull(mySubscriptionBlock, "Блок Мои доступы не найден");
        checkElementIsDisplayed(mySubscriptionBlock, "Блок Мои доступы не отображается");
        if (mySubscriptionBlock != null) {
            WebElement header = mySubscriptionBlock.findElement(By.cssSelector(".normal"));
            postponedAssertEquals(header.getText(), "Ваши доступы", "Неправильный текст заголовка блока Мои доступы");

            WebElement body = mySubscriptionBlock.findElement(By.cssSelector(".access-table"));
            WebElement tableBody = body.findElement(By.tagName("tbody"));
            List<WebElement> accessList = tableBody.findElements(By.tagName("tr"));
            postponedAssertFalse(accessList.isEmpty(), "Список доступов пуст");
        }
        return this;
    }

    @Step("Проверяется что кнопка онлайн консультанта 'Помощник' отображается")
    public KssProfilePage checkOnlineHelpButtonIsPresent() {
        WebElement content = waitForPresenceOfElementLocatedBy(By.tagName("body"));
        WebElement onlineHelpBtn = findElementByNoThrow(content, By.id("assistant-btn"));
        postponedAssertNotNull(onlineHelpBtn, "Кнопка онлайн консультанта 'Помощник' не найдена");
        checkElementIsDisplayed(onlineHelpBtn, "Кнопка онлайн консультанта 'Помощник' не отображается");
        return this;
    }

    @Step("Проверяется что блок 'Мой город' отображается")
    public KssProfilePage checkGeoBlockIsPresent() {
        WebElement mainLeftElement = waitForPresenceOfElementLocatedBy(By.id("main-left"));
        WebElement geoBlock = findElementByNoThrow(mainLeftElement, By.id("geo"));
        postponedAssertNotNull(geoBlock, "Блок 'Мой город' не найден");
        checkElementIsDisplayed(geoBlock, "Блок 'Мой город' не отображается");
        if (geoBlock != null) {

            WebElement header = findElementByNoThrow(geoBlock, By.tagName("h2"));
            postponedAssertNotNull(header, "Заголовок блока 'Мой город' не найден");
            if (header != null) {
                postponedAssertEquals(header.getText().trim(), "Мой город", "Неправильный заголовок блока 'Мой город'");
            }

            WebElement city = findElementByNoThrow(geoBlock, By.id("geo-city-label"));
            postponedAssertNotNull(city, "'Ваш город' в блоке 'Мой город' не найден");
            if (header != null) {
                postponedAssertFalse(city.getText().isEmpty(), "'Ваш город' в блоке 'Мой город' Отсутствует");
            }

            WebElement checkBox = findElementByNoThrow(geoBlock, By.cssSelector(".form-field-label"));
            postponedAssertNotNull(checkBox, "Чекбокс 'определить автоматически' в блоке 'Мой город' не найден");
            checkElementIsDisplayed(checkBox, "Чекбокс 'определить автоматически' в блоке 'Мой город' не отображается");

            WebElement textBox = findElementByNoThrow(geoBlock, By.name("geo-city"));
            postponedAssertNotNull(textBox, "Поле для ввода города в блоке 'Мой город' не найдено");
            checkElementIsDisplayed(textBox, "Поле для ввода города в блоке 'Мой город' не отображается");

            WebElement button = findElementByNoThrow(geoBlock, By.cssSelector(".button"));
            postponedAssertNotNull(header, "Кнопка 'Сохранить' в блоке 'Мой город' не найдена");
            checkElementIsDisplayed(button, "Кнопка 'Сохранить' в блоке 'Мой город' не отображается");
        }
        return this;
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' не отображается")
    public KssProfilePage checkCertificateBlockIsNotPresent() {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNull(certificateBlock, "Блок 'Сертификаты на скидку' отображается");
        return this;
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' отображается")
    public KssProfilePage checkCertificateBlockIsPresent() {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNotNull(certificateBlock, "Блок 'Сертификаты на скидку' не найден");
        if (certificateBlock != null) {
            postponedAssertTrue(certificateBlock.isDisplayed(), "Блок 'Сертификаты на скидку' не отображается");
        }
        return this;
    }

    @Step("Проверяется содержание блока 'Сертификаты на скидку'")
    public KssProfilePage checkCertificateBlockContent() {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNotNull(certificateBlock, "Блок 'Сертификаты на скидку' не найден");
        if (certificateBlock != null) {
            WebElement text = findElementByNoThrow(certificateBlock, By.cssSelector(".facilities__text-lead"));
            WebElement link = findElementByNoThrow(certificateBlock, By.cssSelector("[onclick*='js-toggle-comment']"));
            WebElement rules = findElementByNoThrow(mainContentElement, By.linkText("Правила бонусной программы"));
            postponedAssertNotNull(text, "Отсутствует описание сертификата в блоке 'Сертификаты на скидку'");
            postponedAssertNotNull(link, "Отсутствует ссылка 'Как потратить?' в блоке 'Сертификаты на скидку'");
            postponedAssertNotNull(rules, "Отсутствует ссылка 'Правила бонусной программы' сертификата в блоке 'Сертификаты на скидку'");
        }
        return this;
    }

    @Step("Проверяется что текст в блоке 'Сертификаты на скидку' отображается")
    public KssProfilePage checkTextInCertificateBlockIsPresent(String text) {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertTrue(comment.isDisplayed(), "Текст '" + text + "' не отображается в блоке 'Сертификаты на скидку'");
        postponedAssertEquals(comment.getText(), text, "Неправильный текст в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Проверяется что текст в блоке 'Сертификаты на скидку' не отображается")
    public KssProfilePage checkTextInCertificateBlockIsNotPresent(String text) {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertFalse(comment.isDisplayed(), "Текст '" + text + "' отображается в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Нажать на ссылку 'Как потратить?'")
    public KssProfilePage clickLinkInCertificateBlock() {
        WebElement mainContentElement = waitForPresenceOfElementLocatedBy(By.id("main-container"));
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        certificateBlock.findElement(By.cssSelector("[onclick*='js-toggle-comment']")).click();
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public KssProfilePage checkCurrentUrlContainsDocumentUrl() {
        checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public KssProfilePage changeRegion(String region) {
        getHelper(ProfileBasePageHelper.class).changeRegion(region);
        return this;
    }

    @Step("Вернуть определение региона автоматически")
    public KssProfilePage changeCheckboxAutoRegion() {
        getHelper(ProfileBasePageHelper.class).changeCheckboxAutoRegion();
        return this;
    }

    public KssProfilePage checkBonusBlockIsPresent() {
        getHelper(ProfileBasePageHelper.class).checkBonusBlockIsPresent();
        return this;
    }

    public KssProfilePage checkBonusBlock() {
        getHelper(ProfileBasePageHelper.class).checkBonusBlock();
        return this;
    }

    public KssProfilePage clickFromPointLink() {
        getHelper(ProfileBasePageHelper.class).clickFromPointLink();
        return this;
    }

    public KssProfilePage checkFromPointCommentIsAppear() {
        getHelper(ProfileBasePageHelper.class).checkFromPointCommentIsAppear();
        return this;
    }

    public KssProfilePage clickSpendPointLink() {
        getHelper(ProfileBasePageHelper.class).clickSpendPointLink();
        return this;
    }

    public KssProfilePage checkBonusSiteIsOpened() {
        getHelper(ProfileBasePageHelper.class).checkBonusSiteIsOpened();
        return this;
    }

    public KssProfilePage clickGetPointLink() {
        getHelper(ProfileBasePageHelper.class).clickGetPointLink();
        return this;
    }

    public KssProfilePage checkPromoBonusSiteIsOpened() {
        getHelper(ProfileBasePageHelper.class).checkPromoBonusSiteIsOpened();
        return this;
    }

    public PersonInfo getPersonInfo() {
        PersonInfo personInfo = getHelper(ProfileBasePageHelper.class).getPersonInfo();
        logout();
        return personInfo;
    }
}

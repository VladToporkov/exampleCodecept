package com.actionmedia.pages.bss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.PersonInfo;
import com.actionmedia.pages.helpers.ProfileBasePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 24.10.13
 * Time: 11:33
 */
@Component
public class BssProfilePage extends BssBasePage<BssProfilePage> {

    @Step("Проверяется что открыт личный кабинет")
    public BssProfilePage checkProfilePageIsOpened() {
        WebElement personalInfo = findElementByNoThrow(mainLeftElement, By.cssSelector(".main__title"));
        assertNotNull(personalInfo, "Личный кабинет не отображается");
        postponedAssertEquals(personalInfo.getText(), "Персональные данные", "Неправильный текст загаловка личного кабинета");
        return this;
    }

    @Step("Проверяется что доступы отображаются в личном кабинете")
    public BssProfilePage checkAccessListIsPresent() {
        WebElement access = findElementByNoThrow(mainLeftElement, By.id("accessList"));
        assertNotNull(access, "Раздел доступов не найден");
        postponedAssertEquals(access.findElement(By.cssSelector(".normal")).getText(), "Ваши доступы", "Неправильный заголовок раздела доступов");
        List<WebElement> accessList = access.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        postponedAssertFalse(accessList.isEmpty(), "Список доступов пуст");
        return this;
    }

    @Step("Проверяется что открыта страница аквтивации кода доступа")
    public BssProfilePage checkActivateCodePageIsOpened() {
        WebElement activateCodeHeader = findElementByNoThrow(mainLeftElement, By.cssSelector(".normal"));
        assertNotNull(activateCodeHeader, "Заголовок странице активации кода доступа не найден");
        postponedAssertEquals(activateCodeHeader.getText(), "Активация кода доступа", "Неправильный заголовок страницы активации кода доступа");

        WebElement activeCodeFields = findElementByNoThrow(mainLeftElement, By.id("fields-activate"));
        assertNotNull(activeCodeFields, "Поля для ввода кода не найдены");
        postponedAssertTrue(activateCodeHeader.isDisplayed(), "Поля для ввода кода не отображаются");

        WebElement activeButton = findElementByNoThrow(mainLeftElement, By.id("button-activate"));
        assertNotNull(activeButton, "Кнопка активировать не найдена");
        postponedAssertTrue(activeButton.isDisplayed(), "Кнопка активировать не отображаются");
        return this;
    }

    @Step("Проверяется что блок 'Мой город' отображается")
    public BssProfilePage checkGeoBlockIsPresent() {
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

            WebElement textBox = findElementByNoThrow(geoBlock, By.cssSelector(".ui-autocomplete-input"));
            postponedAssertNotNull(textBox, "Поле для ввода города в блоке 'Мой город' не найдено");
            checkElementIsDisplayed(textBox, "Поле для ввода города в блоке 'Мой город' не отображается");

            WebElement button = findElementByNoThrow(geoBlock, By.cssSelector(".button"));
            postponedAssertNotNull(header, "Кнопка 'Сохранить' в блоке 'Мой город' не найдена");
            checkElementIsDisplayed(button, "Кнопка 'Сохранить' в блоке 'Мой город' не отображается");
        }
        return this;
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' не отображается")
    public BssProfilePage checkCertificateBlockIsNotPresent() {
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNull(certificateBlock, "Блок 'Сертификаты на скидку' отображается");
        return this;
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' отображается")
    public BssProfilePage checkCertificateBlockIsPresent() {
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNotNull(certificateBlock, "Блок 'Сертификаты на скидку' не найден");
        if (certificateBlock != null) {
            postponedAssertTrue(certificateBlock.isDisplayed(), "Блок 'Сертификаты на скидку' не отображается");
        }
        return this;
    }

    @Step("Проверяется содержание блока 'Сертификаты на скидку'")
    public BssProfilePage checkCertificateBlockContent() {
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
    public BssProfilePage checkTextInCertificateBlockIsPresent(String text) {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertTrue(comment.isDisplayed(), "Текст '" + text + "' не отображается в блоке 'Сертификаты на скидку'");
        postponedAssertEquals(comment.getText(), text, "Неправильный текст в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Проверяется что текст в блоке 'Сертификаты на скидку' не отображается")
    public BssProfilePage checkTextInCertificateBlockIsNotPresent(String text) {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertFalse(comment.isDisplayed(), "Текст '" + text + "' отображается в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Нажать на ссылку 'Как потратить?'")
    public BssProfilePage clickLinkInCertificateBlock() {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        certificateBlock.findElement(By.cssSelector("[onclick*='js-toggle-comment']")).click();
        return this;
    }

    @Step("Нажать кнопку активировать код")
    public BssProfilePage clickActivateCodeButton() {
        waitForVisibilityOfElementLocatedBy(By.cssSelector(".btn__in"), "Форма активации кода не найдена").click();
        waitForReloadingPage();
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public BssProfilePage checkCurrentUrlContainsDocumentUrl() {
        checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Изменяется регион")
    public BssProfilePage changeRegion(String region) {
        getHelper(ProfileBasePageHelper.class).changeRegion(region);
        return this;
    }

    @Step("Вернуть определение региона автоматически")
    public BssProfilePage changeCheckboxAutoRegion() {
        getHelper(ProfileBasePageHelper.class).changeCheckboxAutoRegion();
        return this;
    }

    public BssProfilePage checkBonusBlockIsPresent(){
        getHelper(ProfileBasePageHelper.class).checkBonusBlockIsPresent();
        return this;
    }

    public BssProfilePage checkBonusBlock(){
        getHelper(ProfileBasePageHelper.class).checkBonusBlock();
        return this;
    }

    public BssProfilePage clickFromPointLink(){
        getHelper(ProfileBasePageHelper.class).clickFromPointLink();
        return this;
    }

    public BssProfilePage checkFromPointCommentIsAppear(){
        getHelper(ProfileBasePageHelper.class).checkFromPointCommentIsAppear();
        return this;
    }

    public BssProfilePage clickSpendPointLink(){
        getHelper(ProfileBasePageHelper.class).clickSpendPointLink();
        return this;
    }

    public BssProfilePage checkBonusSiteIsOpened(){
        getHelper(ProfileBasePageHelper.class).checkBonusSiteIsOpened();
        return this;
    }

    public BssProfilePage clickGetPointLink(){
        getHelper(ProfileBasePageHelper.class).clickGetPointLink();
        return this;
    }

    public BssProfilePage checkPromoBonusSiteIsOpened(){
        getHelper(ProfileBasePageHelper.class).checkPromoBonusSiteIsOpened();
        return this;
    }
    public PersonInfo getPersonInfo(){
        PersonInfo personInfo = getHelper(ProfileBasePageHelper.class).getPersonInfo();
        logout();
        return personInfo;
    }

    public BssProfilePage checkEmail(String email) {
        getHelper(ProfileBasePageHelper.class).checkEmail(email);
        return this;
    }
}

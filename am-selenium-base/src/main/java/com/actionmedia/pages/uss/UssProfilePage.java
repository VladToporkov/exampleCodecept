package com.actionmedia.pages.uss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.components.PersonInfo;
import com.actionmedia.pages.helpers.ProfileBasePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: n.tyukavkin
 * Date: 10.04.2014
 * Time: 14:29
 */
@Component
public class UssProfilePage extends UssBasePage<UssProfilePage> {

    @Step("Проверяется что страница Личного кабинета открыта")
    public UssProfilePage checkProfilePageIsOpened() {
        WebElement profile = findElementByNoThrow(mainContentElement, By.id("personal-data"));
        postponedAssertNotNull(profile, "Страница Личного кабинета не открыта");
        return this;
    }

    @Step("Проверяется что блок 'Видеолекции и сервисы журнала Юрист компании' отображается")
    public UssProfilePage checkTrainingBlockIsPresent() {
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        postponedAssertNotNull(trainingBlockIsPresent, "Блок 'Видеолекции и сервисы журнала Юрист компании' не найден");
        if (trainingBlockIsPresent != null) {
            postponedAssertTrue(trainingBlockIsPresent.isDisplayed(), "Блок 'Видеолекции и сервисы журнала Юрист компании' не отображается");
            postponedAssertFalse(trainingBlockIsPresent.getText().isEmpty(), "Блок 'Видеолекции и сервисы журнала Юрист компании' не пустой");
        }
        return this;
    }

    public UssProfilePage checkCourseInTrainingBlockIsPresent(String courseName) {
        report("Проверяется что блок '" + courseName + "' отображается");
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        if (trainingBlockIsPresent != null) {
            List<WebElement> courseList = trainingBlockIsPresent.findElements(By.tagName("a"));
            List<String> courseNameList = getTextFromWebElementList(courseList);
            postponedAssertTrue(courseNameList.contains(courseName), "Сервис '" + courseName + "' не найден в блоке 'Видеолекции и сервисы журнала Юрист компании'");
        }
        return this;
    }

    @Step("Проверяется что блок 'Видеолекции и сервисы журнала Юрист компании' содержит дату активации")
    public UssProfilePage checkDateActivationInTrainingBlockIsPresent() {
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        String dateActivation = "до 30 декабря 2014 года";
        WebElement firstService = trainingBlockIsPresent.findElement(By.xpath("//table/tbody/tr[1]/td[1]/p"));
        WebElement secondService = trainingBlockIsPresent.findElement(By.xpath("//table/tbody/tr[2]/td[1]/p"));
        postponedAssertTrue(firstService.getText().contains(dateActivation), "Не указана дата окончания работы кода в строке сервиса 'Путеводитель по неустойке'");
        postponedAssertTrue(secondService.getText().contains(dateActivation), "Не указана дата окончания работы кода в строке сервиса 'Академия Юриста Компании'");
        return this;
    }

    @Step("Проверяется что блок 'Видеолекции и сервисы журнала Юрист компании' содержит блок 'Получить код'")
    public UssProfilePage checkGetCodesBlockIsPresent() {
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        WebElement getCodesBlock = findElementByNoThrow(trainingBlockIsPresent, By.cssSelector(".holding-cards-get-code"));
        postponedAssertNotNull(getCodesBlock, "Блок 'Получить код' не найден");
        if (getCodesBlock != null) {
            postponedAssertTrue(getCodesBlock.isDisplayed(), "Блок 'Получить код' не отображается");
            postponedAssertFalse(getCodesBlock.getText().isEmpty(), "Блок 'Получить код' пустой");
        }
        return this;
    }

    @Step("Проверяется что блок 'Видеолекции и сервисы журнала Юрист компании' содержит счетчиков кодов")
    public UssProfilePage checkCodesCountBlockIsPresent() {
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        WebElement getCodesBlock = findElementByNoThrow(trainingBlockIsPresent, By.cssSelector(".holding-cards-get-code"));
        if (getCodesBlock != null) {
            WebElement codeLink = getCodesBlock.findElement(By.tagName("a"));
            String codeCount = codeLink.getAttribute("data-count");
            postponedAssertTrue(codeCount != null && !codeCount.isEmpty(), "Отсутствует счетчиков кодов");
        }
        return this;
    }

    @Step("Проверяется что счетчиков кодов изменяется после нажатия на кнопку 'Получить код'")
    public UssProfilePage checkCodesCountBlockIsChangedAfterClick() {
        WebElement trainingBlockIsPresent = findElementByNoThrow(mainContentElement, By.id("my-training"));
        WebElement getCodesBlock = trainingBlockIsPresent.findElement(By.cssSelector(".holding-cards-get-code"));
        WebElement codeLink = getCodesBlock.findElement(By.tagName("a"));
        String codeCountBeforeClick = getParentElement(codeLink).findElement(By.tagName("b")).getText();
        int countBefore = Integer.parseInt(codeCountBeforeClick);
        codeLink.click();
        String codeCountAfterClick = getParentElement(codeLink).findElement(By.tagName("b")).getText();
        int countAfter = Integer.parseInt(codeCountAfterClick);
        postponedAssertTrue(countBefore > countAfter, "Счетчиков кодов не изменился после нажатия на кнопку 'Получить код'");
        return this;
    }

    public UssLayerComPage clickLinkByName(String linkName) {
        report("Нажать на ссылку '" + linkName + "'.");
        waitForPresenceOfElementLocatedBy(By.linkText(linkName), "Ссылка '" + linkName + "' не найдена").click();
        waitForWindowToBeAppearedByPartialUrlAndSwitchToIt("lawyercom.ru");
        return redirectTo(UssLayerComPage.class);
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' не отображается")
    public UssProfilePage checkCertificateBlockIsNotPresent() {
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNull(certificateBlock, "Блок 'Сертификаты на скидку' отображается");
        return this;
    }

    @Step("Проверяется что блок 'Сертификаты на скидку' отображается")
    public UssProfilePage checkCertificateBlockIsPresent() {
        WebElement certificateBlock = findElementByNoThrow(mainContentElement, By.cssSelector(".js-bonus-certs"));
        postponedAssertNotNull(certificateBlock, "Блок 'Сертификаты на скидку' не найден");
        if (certificateBlock != null) {
            postponedAssertTrue(certificateBlock.isDisplayed(), "Блок 'Сертификаты на скидку' не отображается");
        }
        return this;
    }

    @Step("Проверяется содержание блока 'Сертификаты на скидку'")
    public UssProfilePage checkCertificateBlockContent() {
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
    public UssProfilePage checkTextInCertificateBlockIsPresent(String text) {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertTrue(comment.isDisplayed(), "Текст '" + text + "' не отображается в блоке 'Сертификаты на скидку'");
        postponedAssertEquals(comment.getText(), text, "Неправильный текст в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Проверяется что текст в блоке 'Сертификаты на скидку' не отображается")
    public UssProfilePage checkTextInCertificateBlockIsNotPresent(String text) {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        WebElement comment = certificateBlock.findElement(By.cssSelector(".js-toggle-comment"));
        postponedAssertFalse(comment.isDisplayed(), "Текст '" + text + "' отображается в блоке 'Сертификаты на скидку'");
        return this;
    }

    @Step("Нажать на ссылку 'Как потратить?'")
    public UssProfilePage clickLinkInCertificateBlock() {
        WebElement certificateBlock = mainContentElement.findElement(By.cssSelector(".js-bonus-certs"));
        certificateBlock.findElement(By.cssSelector("[onclick*='js-toggle-comment']")).click();
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public UssProfilePage checkCurrentUrlContainsDocumentUrl() {
        checkCurrentUrlContainsDocumentUrl("/#/customer/geo/");
        return this;
    }

    @Step("Проверяем клик на ссылку 'Изменить регион'")
    public UssProfilePage changeRegion(String region) {
        getHelper(ProfileBasePageHelper.class).changeRegion(region);
        return this;
    }

    @Step("Вернуть определение региона автоматически")
    public UssProfilePage changeCheckboxAutoRegion() {
        getHelper(ProfileBasePageHelper.class).changeCheckboxAutoRegion();
        return this;
    }

    public UssProfilePage checkBonusBlockIsPresent(){
        getHelper(ProfileBasePageHelper.class).checkBonusBlockIsPresent();
        return this;
    }

    public UssProfilePage checkBonusBlock(){
        getHelper(ProfileBasePageHelper.class).checkBonusBlock();
        return this;
    }

    public UssProfilePage clickFromPointLink(){
        getHelper(ProfileBasePageHelper.class).clickFromPointLink();
        return this;
    }

    public UssProfilePage checkFromPointCommentIsAppear(){
        getHelper(ProfileBasePageHelper.class).checkFromPointCommentIsAppear();
        return this;
    }

    public UssProfilePage clickSpendPointLink(){
        getHelper(ProfileBasePageHelper.class).clickSpendPointLink();
        return this;
    }

    public UssProfilePage checkBonusSiteIsOpened(){
        getHelper(ProfileBasePageHelper.class).checkBonusSiteIsOpened();
        return this;
    }

    public UssProfilePage clickGetPointLink(){
        getHelper(ProfileBasePageHelper.class).clickGetPointLink();
        return this;
    }

    public UssProfilePage checkPromoBonusSiteIsOpened(){
        getHelper(ProfileBasePageHelper.class).checkPromoBonusSiteIsOpened();
        return this;
    }
    public PersonInfo getPersonInfo(){
        PersonInfo personInfo = getHelper(ProfileBasePageHelper.class).getPersonInfo();
        logout();
        return personInfo;
    }

    public UssProfilePage checkEmail(String email) {
        getHelper(ProfileBasePageHelper.class).checkEmail(email);
        return this;
    }
}

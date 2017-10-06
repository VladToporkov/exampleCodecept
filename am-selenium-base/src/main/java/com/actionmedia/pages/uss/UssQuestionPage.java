package com.actionmedia.pages.uss;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * User: n.tyukavkin
 * Date: 06.12.13
 * Time: 15:52
 */
@Component
public class UssQuestionPage extends UssBasePage<UssQuestionPage> {

    public UssQuestionPage checkSendWindowsIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsEnabled();
        return this;
    }

    public UssQuestionPage checkSendWindowsIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsDisabled();
        return this;
    }

    public UssQuestionPage checkTextInSendForm(String expectedText) {
        getHelper(QuestionPageHelper.class).checkTextInSendForm(expectedText);
        return this;
    }

    public UssQuestionPage checkSendButtonIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsEnabled();
        return this;
    }

    public UssQuestionPage checkSendButtonIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsDisabled();
        return this;
    }

    public UssQuestionPage checkPersonalExpertInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkPersonalExpertInfoIsPresent();
        return this;
    }

    public UssQuestionPage checkAuthorsInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkAuthorsInfoIsPresent();
        return this;
    }

    public UssQuestionPage checkPersonalTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkPersonalTabIsSelected();
        return this;
    }

    public UssQuestionPage checkAuthorsTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkAuthorsTabIsSelected();
        return this;
    }

    public UssQuestionPage checkSendMessageIsPresent(String message) {
        getHelper(QuestionPageHelper.class).checkSendMessageIsPresent(message);
        return this;
    }

    @Step("Проверяется текст в разделе 'онлайн-помощнику'")
    public UssQuestionPage checkOnlineHelpTabText() {
        WebElement onlineHelpTextElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-text-online"), "Форма онлайн помощника не найдена");
        String actualText = onlineHelpTextElement.getText().trim();
        String expectedText = "Моментальный ответ онлайн-помощника\n" +
                "Если не нужен письменный ответ. Круглосуточно в рабочие дни.";
        postponedAssertEquals(actualText, expectedText, "Неправильный текст в разделе 'онлайн-помощнику'");
        return this;
    }

    public UssQuestionPage clickAuthorsTab() {
        getHelper(QuestionPageHelper.class).clickAuthorsTab();
        return this;
    }

    public UssQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }

    @Step("Выбрать раздел 'онлайн-помощнику'")
    public UssQuestionPage clickOnlineHelpTab() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"), "Раздел 'онлайн-помощнику' не найден");
        content.findElement(By.cssSelector("[rel='tabs-1']")).click();
        return this;
    }

    public UssQuestionPage clickTextForm() {
        getHelper(QuestionPageHelper.class).clickTextForm();
        return this;
    }

    public UssQuestionPage clickSendButtonOnQuestionPage() {
        getHelper(QuestionPageHelper.class).clickSendButtonOnQuestionPage();
        return this;
    }

    public UssQuestionPage inputTextInSendForm(String inputText) {
        getHelper(QuestionPageHelper.class).inputTextInSendForm(inputText);
        return this;
    }

    public UssQuestionPage inputRandomPhoneNumber() {
        getHelper(QuestionPageHelper.class).inputRandomPhoneNumber();
        return this;
    }

    public boolean isWeekend() {
        return getHelper(QuestionPageHelper.class).isWeekendOrEndOfDay();
    }

    public UssQuestionPage checkErrorMessage(String message) {
        getHelper(QuestionPageHelper.class).checkErrorMessage(message);
        return this;
    }

    public UssQuestionPage checkErrorTextBoxPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorTextBoxPlaceholder();
        return this;
    }

    public UssQuestionPage checkErrorPhoneNumberPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorPhoneNumberPlaceholder();
        return this;
    }

    public UssQuestionPage clearFieldsPhoneNumber() {
        getHelper(QuestionPageHelper.class).clearFieldsPhoneNumber();
        return this;
    }

    public UssQuestionPage inputEmail(String email) {
        getHelper(QuestionPageHelper.class).inputEmail(email);
        return this;
    }

    public UssQuestionPage clearEmailField() {
        getHelper(QuestionPageHelper.class).clearEmailField();
        return this;
    }

    public UssQuestionPage checkErrorEmailPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorEmailPlaceholder();
        return this;
    }

    public UssQuestionPage checkQuestionIsCreatedInSGCRM() {
        getHelper(QuestionPageHelper.class).checkCreatedQuestionInSGCRM();
        return this;
    }

    public UssQuestionPage removeQuestionFromSGCRM() {
        getHelper(QuestionPageHelper.class).removeQuestionFromSGCRM();
        return this;
    }

    public UssQuestionPage checkQuestionIsRemovedFromSGCRM() {
        getHelper(QuestionPageHelper.class).checkQuestionIsRemovedFromSGCRM();
        return this;
    }

    public UssQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public UssQuestionPage checkButtonTabOnlineIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabOnlineIsPresent();
        return this;
    }

    public UssQuestionPage checkButtonTabWritingIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabWritingIsPresent();
        return this;
    }

    public UssQuestionPage checkButtonTabFromAuthorsIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsPresent();
        return this;
    }

    public UssQuestionPage checkButtonTabFromAuthorsIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsNotPresent();
        return this;
    }

    public UssQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public UssQuestionPage checkStickerIsPresent() {
        getHelper(QuestionPageHelper.class).checkStickerIsPresent();
        return this;
    }

    public UssQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public UssQuestionPage checkTextOnTabOnline(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabOnline(title);
        return this;
    }

    public UssQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public UssQuestionPage checkTextOnTabFromAuthors(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabFromAuthors(title);
        return this;
    }

    public UssQuestionPage checkVIPLabelOnTabWriting() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabWriting();
        return this;
    }

    public UssQuestionPage checkVIPLabelOnTabFromAuthors() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabFromAuthors();
        return this;
    }

    public UssQuestionPage checkExpertInfoPhotoIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhotoIsPresent();
        return this;
    }

    public UssQuestionPage checkExpertInfoFullNameIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoFullNameIsPresent();
        return this;
    }

    public UssQuestionPage checkExpertInfoPositionIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPositionIsPresent();
        return this;
    }

    public UssQuestionPage checkExpertInfoPhoneNumberIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhoneNumberIsPresent();
        return this;
    }

    public UssQuestionPage checkExpertInfoEmailIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsPresent();
        return this;
    }

    public UssQuestionPage checkExpertInfoEmailIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsNotPresent();
        return this;
    }

    public UssQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public UssQuestionPage checkPhotoAuthorsOnFromAuthors() {
        getHelper(QuestionPageHelper.class).checkPhotoAuthorsOnFromAuthors();
        return this;
    }

    public UssQuestionPage checkTabsMenuIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkTabsMenuIsNotPresent();
        return this;
    }

    public UssQuestionPage checkTextTabForUSN() {
        getHelper(QuestionPageHelper.class).checkTextTabForUSN();
        return this;
    }
}

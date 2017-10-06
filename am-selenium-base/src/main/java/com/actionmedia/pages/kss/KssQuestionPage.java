package com.actionmedia.pages.kss;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 11:52
 */
@Component
public class KssQuestionPage extends KssBasePage<KssQuestionPage> {

    public KssQuestionPage checkSendWindowsIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsEnabled();
        return this;
    }

    public KssQuestionPage checkSendWindowsIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsDisabled();
        return this;
    }

    public KssQuestionPage checkTextInSendForm(String expectedText) {
        getHelper(QuestionPageHelper.class).checkTextInSendForm(expectedText);
        return this;
    }

    public KssQuestionPage checkSendButtonIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsEnabled();
        return this;
    }

    public KssQuestionPage checkSendButtonIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsDisabled();
        return this;
    }

    public KssQuestionPage checkPersonalExpertInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkPersonalExpertInfoIsPresent();
        return this;
    }

    public KssQuestionPage checkAuthorsInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkAuthorsInfoIsPresent();
        return this;
    }

    public KssQuestionPage checkPersonalTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkPersonalTabIsSelected();
        return this;
    }

    public KssQuestionPage checkAuthorsTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkAuthorsTabIsSelected();
        return this;
    }

    public KssQuestionPage checkSendMessageIsPresent(String message) {
        getHelper(QuestionPageHelper.class).checkSendMessageIsPresent(message);
        return this;
    }

    @Step("Проверяется текст в разделе 'онлайн-помощнику'")
    public KssQuestionPage checkOnlineHelpTabText() {
        WebElement onlineHelpTextElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-text-online"), "Форма онлайн помощника не найдена");
        String actualText = onlineHelpTextElement.getText().trim();
        String expectedText = "Моментальный ответ онлайн-помощника\n" +
                "Быстрый ответ в чате. Круглосуточно по будням.";
        postponedAssertEquals(actualText, expectedText, "Неправильный текст в разделе 'онлайн-помощнику'");
        return this;
    }

    public KssQuestionPage clickAuthorsTab() {
        getHelper(QuestionPageHelper.class).clickAuthorsTab();
        return this;
    }

    public KssQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }

    @Step("Выбрать раздел 'онлайн-помощнику'")
    public KssQuestionPage clickOnlineHelpTab() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"), "Раздел 'онлайн-помощнику' не найден");
        content.findElement(By.cssSelector("[rel='tabs-1']")).click();
        return this;
    }

    public KssQuestionPage clickTextForm() {
        getHelper(QuestionPageHelper.class).clickTextForm();
        return this;
    }

    public KssQuestionPage clickSendButtonOnQuestionPage() {
        getHelper(QuestionPageHelper.class).clickSendButtonOnQuestionPage();
        return this;
    }

    public KssQuestionPage inputTextInSendForm(String inputText) {
        getHelper(QuestionPageHelper.class).inputTextInSendForm(inputText);
        return this;
    }

    public KssQuestionPage inputRandomPhoneNumber() {
        getHelper(QuestionPageHelper.class).inputRandomPhoneNumber();
        return this;
    }

    public boolean isWeekend() {
        return getHelper(QuestionPageHelper.class).isWeekendOrEndOfDay();
    }

    public KssQuestionPage checkErrorMessage(String message) {
        getHelper(QuestionPageHelper.class).checkErrorMessage(message);
        return this;
    }

    public KssQuestionPage checkErrorTextBoxPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorTextBoxPlaceholder();
        return this;
    }

    public KssQuestionPage checkErrorPhoneNumberPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorPhoneNumberPlaceholder();
        return this;
    }

    public KssQuestionPage clearFieldsPhoneNumber() {
        getHelper(QuestionPageHelper.class).clearFieldsPhoneNumber();
        return this;
    }

    public KssQuestionPage inputEmail(String email) {
        getHelper(QuestionPageHelper.class).inputEmail(email);
        return this;
    }

    public KssQuestionPage clearEmailField() {
        getHelper(QuestionPageHelper.class).clearEmailField();
        return this;
    }

    public KssQuestionPage checkErrorEmailPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorEmailPlaceholder();
        return this;
    }

    public KssQuestionPage checkQuestionIsCreatedInSGCRM() {
        getHelper(QuestionPageHelper.class).checkCreatedQuestionInSGCRM();
        return this;
    }

    public KssQuestionPage removeQuestionFromSGCRM() {
        getHelper(QuestionPageHelper.class).removeQuestionFromSGCRM();
        return this;
    }

    public KssQuestionPage checkQuestionIsRemovedFromSGCRM() {
        getHelper(QuestionPageHelper.class).checkQuestionIsRemovedFromSGCRM();
        return this;
    }

    public KssQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public KssQuestionPage checkButtonTabOnlineIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabOnlineIsPresent();
        return this;
    }

    public KssQuestionPage checkButtonTabWritingIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabWritingIsPresent();
        return this;
    }

    public KssQuestionPage checkButtonTabFromAuthorsIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsPresent();
        return this;
    }

    public KssQuestionPage checkButtonTabFromAuthorsIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsNotPresent();
        return this;
    }

    public KssQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public KssQuestionPage checkStickerIsPresent() {
        getHelper(QuestionPageHelper.class).checkStickerIsPresent();
        return this;
    }

    public KssQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public KssQuestionPage checkTextOnTabOnline(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabOnline(title);
        return this;
    }

    public KssQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public KssQuestionPage checkTextOnTabFromAuthors(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabFromAuthors(title);
        return this;
    }

    public KssQuestionPage checkVIPLabelOnTabWriting() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabWriting();
        return this;
    }

    public KssQuestionPage checkVIPLabelOnTabFromAuthors() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabFromAuthors();
        return this;
    }

    public KssQuestionPage checkExpertInfoPhotoIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhotoIsPresent();
        return this;
    }

    public KssQuestionPage checkExpertInfoFullNameIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoFullNameIsPresent();
        return this;
    }

    public KssQuestionPage checkExpertInfoPositionIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPositionIsPresent();
        return this;
    }

    public KssQuestionPage checkExpertInfoPhoneNumberIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhoneNumberIsPresent();
        return this;
    }

    public KssQuestionPage checkExpertInfoEmailIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsPresent();
        return this;
    }

    public KssQuestionPage checkExpertInfoEmailIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsNotPresent();
        return this;
    }

    public KssQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public KssQuestionPage checkPhotoAuthorsOnFromAuthors() {
        getHelper(QuestionPageHelper.class).checkPhotoAuthorsOnFromAuthors();
        return this;
    }

    public KssQuestionPage checkTabsMenuIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkTabsMenuIsNotPresent();
        return this;
    }

    public KssQuestionPage checkTextTabForUSN() {
        getHelper(QuestionPageHelper.class).checkTextTabForUSN();
        return this;
    }
}

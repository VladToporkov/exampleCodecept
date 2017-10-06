package com.actionmedia.pages.bss;

import ru.yandex.qatools.allure.annotations.Step;
import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 17:52
 */
@Component
public class BssQuestionPage extends BssBasePage<BssQuestionPage> {

    public BssQuestionPage checkSendWindowsIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsEnabled();
        return this;
    }

    public BssQuestionPage checkSendWindowsIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsDisabled();
        return this;
    }

    public BssQuestionPage checkTextInSendForm(String expectedText) {
        getHelper(QuestionPageHelper.class).checkTextInSendForm(expectedText);
        return this;
    }

    public BssQuestionPage checkSendButtonIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsEnabled();
        return this;
    }

    public BssQuestionPage checkSendButtonIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsDisabled();
        return this;
    }

    public BssQuestionPage checkPersonalExpertInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkPersonalExpertInfoIsPresent();
        return this;
    }

    public BssQuestionPage checkAuthorsInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkAuthorsInfoIsPresent();
        return this;
    }

    public BssQuestionPage checkPersonalTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkPersonalTabIsSelected();
        return this;
    }

    public BssQuestionPage checkAuthorsTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkAuthorsTabIsSelected();
        return this;
    }

    public BssQuestionPage checkSendMessageIsPresent(String message) {
        getHelper(QuestionPageHelper.class).checkSendMessageIsPresent(message);
        return this;
    }

    @Step("Проверяется текст в разделе 'онлайн-помощнику'")
    public BssQuestionPage checkOnlineHelpTabText() {
        WebElement onlineHelpTextElement = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-text-online"), "Форма онлайн помощника не найдена");
        String actualText = onlineHelpTextElement.getText().trim();
        String expectedText = "Моментальный ответ онлайн-помощника\nЕсли не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.";
        postponedAssertEquals(actualText, expectedText, "Неправильный текст в разделе 'онлайн-помощнику'");
        return this;
    }

    @Step("Проверяется что текст появился в форме онлайн-помощника")
    public BssQuestionPage checkTextInOnlineHelpWindowIsAppear(String message) {
        switchToFrame("lt_embeded_window");
        waitForInvisibilityOfElementLocatedBy(By.cssSelector(".spinner"));
        WebElement questionField = waitForVisibilityOfElementLocatedBy(By.cssSelector(".chat-content"), "Форма онлайн помощника не найдена");
        try {
            int count = 0;
            while (!questionField.getText().isEmpty()) {
                waitForTextToBePresentIn(questionField);
                count++;
                if (count > 5) {
                    break;
                }
            }
        } catch (TimeoutException ignored) {
        }
        String actualText = questionField.findElement(By.cssSelector(".msg")).getText();
        postponedAssertEquals(actualText, message, "Неправильный текст в форме онлайн-помощника");
        switchToDefaultContent();
        return this;
    }

    public BssQuestionPage clickAuthorsTab() {
        getHelper(QuestionPageHelper.class).clickAuthorsTab();
        return this;
    }

    public BssQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }

    @Step("Выбрать раздел 'онлайн-помощнику'")
    public BssQuestionPage clickOnlineHelpTab() {
        WebElement content = waitForVisibilityOfElementLocatedBy(By.cssSelector(".hl-tab"), "Раздел 'онлайн-помощнику' не найден");
        content.findElement(By.cssSelector("[rel='tabs-1']")).click();
        return this;
    }

    public BssQuestionPage clickTextForm() {
        getHelper(QuestionPageHelper.class).clickTextForm();
        return this;
    }

    public BssQuestionPage clickSendButtonOnQuestionPage() {
        getHelper(QuestionPageHelper.class).clickSendButtonOnQuestionPage();
        return this;
    }

    public BssQuestionPage inputTextInSendForm(String inputText) {
        getHelper(QuestionPageHelper.class).inputTextInSendForm(inputText);
        return this;
    }

    public BssQuestionPage inputRandomPhoneNumber() {
        getHelper(QuestionPageHelper.class).inputRandomPhoneNumber();
        return this;
    }

    public boolean isWeekend() {
        return getHelper(QuestionPageHelper.class).isWeekendOrEndOfDay();
    }

    public BssQuestionPage checkErrorMessage(String message) {
        getHelper(QuestionPageHelper.class).checkErrorMessage(message);
        return this;
    }

    public BssQuestionPage checkErrorTextBoxPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorTextBoxPlaceholder();
        return this;
    }

    public BssQuestionPage checkErrorPhoneNumberPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorPhoneNumberPlaceholder();
        return this;
    }

    public BssQuestionPage clearFieldsPhoneNumber() {
        getHelper(QuestionPageHelper.class).clearFieldsPhoneNumber();
        return this;
    }

    public BssQuestionPage inputEmail(String email) {
        getHelper(QuestionPageHelper.class).inputEmail(email);
        return this;
    }

    public BssQuestionPage clearEmailField() {
        getHelper(QuestionPageHelper.class).clearEmailField();
        return this;
    }

    public BssQuestionPage checkErrorEmailPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorEmailPlaceholder();
        return this;
    }

    public BssQuestionPage checkQuestionIsCreatedInSGCRM() {
        getHelper(QuestionPageHelper.class).checkCreatedQuestionInSGCRM();
        return this;
    }

    public BssQuestionPage removeQuestionFromSGCRM() {
        getHelper(QuestionPageHelper.class).removeQuestionFromSGCRM();
        return this;
    }

    public BssQuestionPage checkQuestionIsRemovedFromSGCRM() {
        getHelper(QuestionPageHelper.class).checkQuestionIsRemovedFromSGCRM();
        return this;
    }

    public BssQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public BssQuestionPage checkButtonTabOnlineIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabOnlineIsPresent();
        return this;
    }

    public BssQuestionPage checkButtonTabWritingIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabWritingIsPresent();
        return this;
    }

    public BssQuestionPage checkButtonTabFromAuthorsIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsPresent();
        return this;
    }

    public BssQuestionPage checkButtonTabFromAuthorsIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsNotPresent();
        return this;
    }

    public BssQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public BssQuestionPage checkOnlinePlaceholderText(String message) {
        getHelper(QuestionPageHelper.class).checkOnlinePlaceholderText(message);
        return this;
    }

    public BssQuestionPage checkStickerIsPresent() {
        getHelper(QuestionPageHelper.class).checkStickerIsPresent();
        return this;
    }

    public BssQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public BssQuestionPage checkTextOnTabOnline(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabOnline(title);
        return this;
    }

    public BssQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public BssQuestionPage checkTextOnTabFromAuthors(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabFromAuthors(title);
        return this;
    }

    public BssQuestionPage checkVIPLabelOnTabWriting() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabWriting();
        return this;
    }

    public BssQuestionPage checkVIPLabelOnTabFromAuthors() {
        getHelper(QuestionPageHelper.class).checkVIPLabelOnTabFromAuthors();
        return this;
    }

    public BssQuestionPage checkExpertInfoPhotoIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhotoIsPresent();
        return this;
    }

    public BssQuestionPage checkExpertInfoFullNameIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoFullNameIsPresent();
        return this;
    }

    public BssQuestionPage checkExpertInfoPositionIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPositionIsPresent();
        return this;
    }

    public BssQuestionPage checkExpertInfoPhoneNumberIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoPhoneNumberIsPresent();
        return this;
    }

    public BssQuestionPage checkExpertInfoEmailIsPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsPresent();
        return this;
    }

    public BssQuestionPage checkExpertInfoEmailIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkExpertInfoEmailIsNotPresent();
        return this;
    }

    public BssQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public BssQuestionPage checkPhotoAuthorsOnFromAuthors() {
        getHelper(QuestionPageHelper.class).checkPhotoAuthorsOnFromAuthors();
        return this;
    }

    public BssQuestionPage checkTabsMenuIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkTabsMenuIsNotPresent();
        return this;
    }

    public BssQuestionPage checkTextTabForUSN() {
        getHelper(QuestionPageHelper.class).checkTextTabForUSN();
        return this;
    }

    public BssQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}

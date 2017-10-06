package com.actionmedia.pages.gf;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 13/03/16.
 */
@Component
public class GfQuestionPage extends GFBasePage<GfRecomendPage> {
    
    public GfQuestionPage checkSendWindowsIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsEnabled();
        return this;
    }

    public GfQuestionPage checkSendButtonIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsEnabled();
        return this;
    }

    public GfQuestionPage checkSendMessageIsPresent(String message) {
        getHelper(QuestionPageHelper.class).checkSendMessageIsPresent(message);
        return this;
    }

    public GfQuestionPage clickAuthorsTab() {
        getHelper(QuestionPageHelper.class).clickAuthorsTab();
        return this;
    }

    public GfQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }

    public GfQuestionPage clickSendButtonOnQuestionPage() {
        getHelper(QuestionPageHelper.class).clickSendButtonOnQuestionPage();
        return this;
    }

    public GfQuestionPage inputTextInSendForm(String inputText) {
        getHelper(QuestionPageHelper.class).inputTextInSendForm(inputText);
        return this;
    }

    public GfQuestionPage inputRandomPhoneNumber() {
        getHelper(QuestionPageHelper.class).inputRandomPhoneNumber();
        return this;
    }

    public GfQuestionPage checkErrorMessage(String message) {
        getHelper(QuestionPageHelper.class).checkErrorMessage(message);
        return this;
    }

    public GfQuestionPage checkErrorTextBoxPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorTextBoxPlaceholder();
        return this;
    }

    public GfQuestionPage checkErrorPhoneNumberPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorPhoneNumberPlaceholder();
        return this;
    }

    public GfQuestionPage clearFieldsPhoneNumber() {
        getHelper(QuestionPageHelper.class).clearFieldsPhoneNumber();
        return this;
    }

    public GfQuestionPage inputEmail(String email) {
        getHelper(QuestionPageHelper.class).inputEmail(email);
        return this;
    }

    public GfQuestionPage clearEmailField() {
        getHelper(QuestionPageHelper.class).clearEmailField();
        return this;
    }

    public GfQuestionPage checkErrorEmailPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorEmailPlaceholder();
        return this;
    }

    public GfQuestionPage checkQuestionIsCreatedInSGCRM() {
        getHelper(QuestionPageHelper.class).checkCreatedQuestionInSGCRM();
        return this;
    }

    public GfQuestionPage removeQuestionFromSGCRM() {
        getHelper(QuestionPageHelper.class).removeQuestionFromSGCRM();
        return this;
    }

    public GfQuestionPage checkQuestionIsRemovedFromSGCRM() {
        getHelper(QuestionPageHelper.class).checkQuestionIsRemovedFromSGCRM();
        return this;
    }

    public GfQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }
    
    public GfQuestionPage checkButtonTabOnlineIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabOnlineIsPresent();
        return this;
    }

    public GfQuestionPage checkButtonTabWritingIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabWritingIsPresent();
        return this;
    }

    public GfQuestionPage checkButtonTabFromAuthorsIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsNotPresent();
        return this;
    }

    public GfQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public GfQuestionPage checkOnlinePlaceholderText(String message) {
        getHelper(QuestionPageHelper.class).checkOnlinePlaceholderText(message);
        return this;
    }

    public GfQuestionPage checkStickerIsPresent() {
        getHelper(QuestionPageHelper.class).checkStickerIsPresent();
        return this;
    }

    public GfQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public GfQuestionPage checkTextOnTabOnline(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabOnline(title);
        return this;
    }

    public GfQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public GfQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public GfQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}

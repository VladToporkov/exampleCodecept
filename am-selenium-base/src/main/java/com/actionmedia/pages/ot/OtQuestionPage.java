package com.actionmedia.pages.ot;

import com.actionmedia.pages.edu.EduQuestionPage;
import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel on 13/03/16.
 */
@Component
public class OtQuestionPage extends OTBasePage<EduQuestionPage> {

    public OtQuestionPage checkSendWindowsIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsEnabled();
        return this;
    }

    public OtQuestionPage checkSendWindowsIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendWindowsIsDisabled();
        return this;
    }

    public OtQuestionPage checkTextInSendForm(String expectedText) {
        getHelper(QuestionPageHelper.class).checkTextInSendForm(expectedText);
        return this;
    }

    public OtQuestionPage checkSendButtonIsEnabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsEnabled();
        return this;
    }

    public OtQuestionPage checkSendButtonIsDisabled() {
        getHelper(QuestionPageHelper.class).checkSendButtonIsDisabled();
        return this;
    }

    public OtQuestionPage checkPersonalExpertInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkPersonalExpertInfoIsPresent();
        return this;
    }

    public OtQuestionPage checkAuthorsInfoIsPresent() {
        getHelper(QuestionPageHelper.class).checkAuthorsInfoIsPresent();
        return this;
    }


    public OtQuestionPage checkPersonalTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkPersonalTabIsSelected();
        return this;
    }

    public OtQuestionPage checkAuthorsTabIsSelected() {
        getHelper(QuestionPageHelper.class).checkAuthorsTabIsSelected();
        return this;
    }

    public OtQuestionPage checkSendMessageIsPresent(String message) {
        getHelper(QuestionPageHelper.class).checkSendMessageIsPresent(message);
        return this;
    }

    public OtQuestionPage clickAuthorsTab() {
        getHelper(QuestionPageHelper.class).clickAuthorsTab();
        return this;
    }

    public OtQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }

    public OtQuestionPage clickTextForm() {
        getHelper(QuestionPageHelper.class).clickTextForm();
        return this;
    }

    public OtQuestionPage clickSendButtonOnQuestionPage() {
        getHelper(QuestionPageHelper.class).clickSendButtonOnQuestionPage();
        return this;
    }

    public OtQuestionPage inputTextInSendForm(String inputText) {
        getHelper(QuestionPageHelper.class).inputTextInSendForm(inputText);
        return this;
    }

    public OtQuestionPage inputRandomPhoneNumber() {
        getHelper(QuestionPageHelper.class).inputRandomPhoneNumber();
        return this;
    }

    public OtQuestionPage checkErrorMessage(String message) {
        getHelper(QuestionPageHelper.class).checkErrorMessage(message);
        return this;
    }

    public OtQuestionPage checkErrorTextBoxPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorTextBoxPlaceholder();
        return this;
    }

    public OtQuestionPage checkErrorPhoneNumberPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorPhoneNumberPlaceholder();
        return this;
    }

    public OtQuestionPage clearFieldsPhoneNumber() {
        getHelper(QuestionPageHelper.class).clearFieldsPhoneNumber();
        return this;
    }

    public OtQuestionPage inputEmail(String email) {
        getHelper(QuestionPageHelper.class).inputEmail(email);
        return this;
    }

    public OtQuestionPage clearEmailField() {
        getHelper(QuestionPageHelper.class).clearEmailField();
        return this;
    }

    public OtQuestionPage checkErrorEmailPlaceholder() {
        getHelper(QuestionPageHelper.class).checkErrorEmailPlaceholder();
        return this;
    }

    public OtQuestionPage checkQuestionIsCreatedInSGCRM() {
        getHelper(QuestionPageHelper.class).checkCreatedQuestionInSGCRM();
        return this;
    }

    public OtQuestionPage removeQuestionFromSGCRM() {
        getHelper(QuestionPageHelper.class).removeQuestionFromSGCRM();
        return this;
    }

    public OtQuestionPage checkQuestionIsRemovedFromSGCRM() {
        getHelper(QuestionPageHelper.class).checkQuestionIsRemovedFromSGCRM();
        return this;
    }

    public OtQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public OtQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public OtQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public OtQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public OtQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public OtQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}

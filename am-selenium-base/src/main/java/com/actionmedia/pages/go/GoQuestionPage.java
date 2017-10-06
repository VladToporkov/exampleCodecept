package com.actionmedia.pages.go;

import com.actionmedia.pages.gf.GFBasePage;
import com.actionmedia.pages.gf.GfRecomendPage;
import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by popovpavel on 29/09/2016.
 */
@Component
public class GoQuestionPage extends GFBasePage<GfRecomendPage> {

    public GoQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public GoQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public GoQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public GoQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public GoQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public GoQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }

    public GoQuestionPage checkButtonTabOnlineIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabOnlineIsPresent();
        return this;
    }

    public GoQuestionPage checkButtonTabWritingIsPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabWritingIsPresent();
        return this;
    }

    public GoQuestionPage checkButtonTabFromAuthorsIsNotPresent() {
        getHelper(QuestionPageHelper.class).checkButtonTabFromAuthorsIsNotPresent();
        return this;
    }

    public GoQuestionPage checkTextOnTabOnline(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabOnline(title);
        return this;
    }

    public GoQuestionPage clickPersonalTab() {
        getHelper(QuestionPageHelper.class).clickPersonalTab();
        return this;
    }


}

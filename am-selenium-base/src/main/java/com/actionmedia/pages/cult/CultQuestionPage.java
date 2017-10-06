package com.actionmedia.pages.cult;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by popovpavel on 01/10/2016.
 */
@Component
public class CultQuestionPage extends CultBasePage<CultQuestionPage> {

    public CultQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public CultQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public CultQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public CultQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public CultQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public CultQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}
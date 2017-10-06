package com.actionmedia.pages.umd;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by popovpavel on 02/10/2016.
 */
@Component
public class UmdQuestionPage extends UmdBasePage<UmdQuestionPage> {

    public UmdQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public UmdQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public UmdQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public UmdQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public UmdQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public UmdQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}


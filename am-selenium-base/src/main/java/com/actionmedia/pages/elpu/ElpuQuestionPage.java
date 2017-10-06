package com.actionmedia.pages.elpu;

import com.actionmedia.pages.helpers.QuestionPageHelper;
import org.springframework.stereotype.Component;

/**
 * Created by popovpavel on 01/10/2016.
 */
@Component
public class ElpuQuestionPage extends ElpuBasePage<ElpuQuestionPage> {

    public ElpuQuestionPage checkTitleGetAnswerIsPresent(String title) {
        getHelper(QuestionPageHelper.class).checkTitleIsPresent(title);
        return this;
    }

    public ElpuQuestionPage checkTextFormIsPresent() {
        getHelper(QuestionPageHelper.class).checkTextFormIsPresent();
        return this;
    }

    public ElpuQuestionPage checkGlassesIsVisible() {
        getHelper(QuestionPageHelper.class).checkGlassesIsVisible();
        return this;
    }

    public ElpuQuestionPage checkTextOnTabWriting(String title) {
        getHelper(QuestionPageHelper.class).checkTextOnTabWriting(title);
        return this;
    }

    public ElpuQuestionPage checkLinkExpertsWorkingRules() {
        getHelper(QuestionPageHelper.class).checkLinkExpertsWorkingRules();
        return this;
    }

    public ElpuQuestionPage checkExpertsAnswersArePresent() {
        getHelper(QuestionPageHelper.class).checkExpertsAnswersArePresent();
        return this;
    }
}

package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 01/10/2016.
 */
public class OSS_1867_HotlineInterface_EDU extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1867", testCaseVersion = "1")
    public void oss_1867_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ОБР КУ");
        test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки ОБР ВИП");
        test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Интерфейс экспертной поддержки ОБР МИНИ");
        test_mini();
    }

    private void test() {
        loginEdu()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Образование")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Образование")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

    private void test_mini() {
        loginOT()
                .navigateToRecomendPage()
                .checkHotLineLinkIsNotPresent()
                .logout();
    }
}

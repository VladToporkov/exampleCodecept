package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 29/09/2016.
 */
public class OSS_1864_HotlineInterface_OT extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1864", testCaseVersion = "1")
    public void oss_1864_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ОТ КУ");
        test();

        updateLoginAsInfo("ehs.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Интерфейс экспертной поддержки ОТ БУ");
        test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки ОТ ВИП");
        test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Интерфейс экспертной поддержки ОТ МИНИ");
        test_mini();
    }

    private void test() {
        loginOT()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Охрана труда")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Охрана труда")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

    private void test_mini() {
        loginOT()
                .navigateToRecomendPage()
                .openPageByPartUrl("/#/hotline")
                .checkNewsBlockRecomendationNewsView()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 01/10/2016.
 */
public class OSS_1868_HotlineInterfaceGO extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1868", testCaseVersion = "2")
    public void oss_1868_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ГО КУ");
        test();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки ГО ВИП");
        test();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Интерфейс экспертной поддержки ГО МИНИ");
        test_mini();
    }

    private void test() {
        loginGo()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Госзаказ")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkTextFormIsPresent()

                .clickPersonalTab()
                .checkButtonTabOnlineIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Госзаказ")
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

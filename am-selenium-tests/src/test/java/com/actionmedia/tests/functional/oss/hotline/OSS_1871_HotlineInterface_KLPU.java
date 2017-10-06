package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 02/10/2016.
 */
public class OSS_1871_HotlineInterface_KLPU extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1871", testCaseVersion = "1")
    public void oss_1871_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки КЛПУ КУ");
        test();

        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки КЛПУ ВИП");
        test();

    }

    private void test() {
        loginKlpu()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Контроль в ЛПУ")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Контроль в ЛПУ")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

}


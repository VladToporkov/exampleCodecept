package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 01/10/2016.
 */
public class OSS_1869_HotlineInterfaceELPU extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1869", testCaseVersion = "1")
    public void oss_1869_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ЭЛПУ КУ");
        test();

        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки ЭЛПУ ВИП");
        test();
    }

    private void test() {
        loginElpu()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Экономика ЛПУ")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Экономика ЛПУ")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }
}

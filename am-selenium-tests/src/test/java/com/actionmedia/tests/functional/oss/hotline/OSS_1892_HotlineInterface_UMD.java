package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by popovpavel on 02/10/2016.
 */
public class OSS_1892_HotlineInterface_UMD extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1892", testCaseVersion = "1")
    public void oss_1892_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки УМД КУ");
        test();

        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки УМД ВИП");
        test();
    }

    private void test() {
        loginUmd()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Управление многоквартирным домом")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы\n" +
                        "Управление многоквартирным домом")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

}

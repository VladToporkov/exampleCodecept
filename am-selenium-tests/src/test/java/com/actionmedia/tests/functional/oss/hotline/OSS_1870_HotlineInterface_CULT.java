package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 01/10/2016.
 */
public class OSS_1870_HotlineInterface_CULT extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1870", testCaseVersion = "1")
    public void oss_1870_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки КУЛЬТ КУ");
        test();

        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки КУЛЬТ ВИП");
        test();

    }

    private void test() {
        loginCult()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Культура")
                .checkTextFormIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Культура")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

}

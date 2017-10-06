package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 29/09/2016.
 */
public class OSS_1862_HotlineInterface_USS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1862", testCaseVersion = "1")
    public void oss_1862_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ЮСС КУ");
        uss_commercial();

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Интерфейс экспертной поддержки ЮСС БУ");
        uss_commercial();
    }

    private void uss_commercial() {
        loginUss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextFormIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы «Юрист»")

                .logout();
    }


}

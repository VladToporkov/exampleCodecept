package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.NoProxy;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.kss.KssQuestionPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 17:49
 */
public class KSS_158_VerifySendToExpertPage extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-158", testCaseVersion = "1")
    @LoginAs(key = "kss.user.demo")
    @NoProxy
    public void kss_158_test() {
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .checkSendWindowsIsDisabled()
                .checkTextInSendForm("Чтобы задать вопрос эксперту,вам необходимо войти в систему.")
                .checkSendButtonIsDisabled();

        report("Тест для проверки в ВИП-версии");
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        KssQuestionPage kssQuestionPage = loginKss()
                .navigateToAnswersPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .checkPersonalTabIsSelected()
                .checkPersonalExpertInfoIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()

                .clickAuthorsTab()
                .checkAuthorsTabIsSelected()
                .checkAuthorsInfoIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()

                .clickPersonalTab()
                .checkPersonalTabIsSelected()
                .checkPersonalExpertInfoIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()

                .clickTextForm()
                .inputTextInSendForm(QUESTION)
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .clickOnlineHelpTab()
                .checkOnlineHelpTabText();

        if (!kssQuestionPage.isWeekend()) {
            kssQuestionPage
                    .checkSendWindowsIsEnabled()
                    .checkSendButtonIsEnabled()
                    .clickTextForm()
                    .inputTextInSendForm(QUESTION)
                    .clickSendButtonOnQuestionPage()
                    .checkMessageIsAppearInFormNew(QUESTION);
        } else {
            report("По выходным помощник на связи с 9 до 18 по московскому времени. Проверяем что форма не активна");
            kssQuestionPage
                    .checkSendWindowsIsDisabled()
                    .checkSendButtonIsDisabled();
        }
        kssQuestionPage
                .logout();
    }
}

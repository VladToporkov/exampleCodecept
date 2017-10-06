package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.NoProxy;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssQuestionPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 17:49
 */
public class BSS_50_VerifySendToExpertPage extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-50", testCaseVersion = "1")
    @LoginAs(key = "bss.user.demo")
    @NoProxy
    public void bss_50_test() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .checkSendWindowsIsDisabled()
                .checkTextInSendForm("Чтобы задать вопрос эксперту,вам необходимо войти в систему.")
                .checkSendButtonIsDisabled();

        report("Тест для проверки в ВИП-версии");
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        BssQuestionPage bssQuestionPage = loginBss()
                .navigateToRecomendPage()
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

        if (!bssQuestionPage.isWeekend()) {
            bssQuestionPage
                    .checkSendWindowsIsEnabled()
                    .checkSendButtonIsEnabled()
                    .clickTextForm()
                    .inputTextInSendForm(QUESTION)
                    .clickSendButtonOnQuestionPage()
                    .checkMessageIsAppearInFormNew(QUESTION);
        } else {
            report("По выходным помощник на связи с 9 до 18 по московскому времени. Проверяем что форма не активна");
            bssQuestionPage
                    .checkSendWindowsIsDisabled()
                    .checkSendButtonIsDisabled();
        }
        bssQuestionPage
                .logout();
    }
}

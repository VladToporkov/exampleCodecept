package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.NoProxy;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssQuestionPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 06.12.13
 * Time: 15:52
 */
public class USS_20_VerifySendToExpertPage extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-20", testCaseVersion = "1")
    @LoginAs(key = "uss.user.demo")
    @NoProxy
    public void uss_20_test() {
        enterToUssWithoutLogin()
                .clickAskExpertLink()
                .clickPersonalTab()
                .checkSendWindowsIsDisabled()
                .checkTextInSendForm("Чтобы задать вопрос эксперту,вам необходимо войти в систему.")
                .checkSendButtonIsDisabled();

        report("Тест для проверки в коммерческой версии");
        updateLoginAsInfo("uss.user.commercial");
        UssQuestionPage ussQuestionPage = loginUss()
                .clickAskExpertLink()
                .clickPersonalTab()

                .clickTextForm()
                .inputTextInSendForm(QUESTION)
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .clickOnlineHelpTab()
                .checkOnlineHelpTabText();

//        if (!ussQuestionPage.isWeekend()) {
//            ussQuestionPage
//                    .checkSendWindowsIsEnabled()
//                    .checkSendButtonIsEnabled()
//                    .clickTextForm()
//                    .inputTextInSendForm(QUESTION)
//                    .clickSendButtonOnQuestionPage()
//                    .checkMessageIsAppearInFormNew(QUESTION);
//        } else {
//            report("По выходным помощник на связи с 9 до 18 по московскому времени. Проверяем что форма не активна");
//            ussQuestionPage
//                    .checkSendWindowsIsDisabled()
//                    .checkSendButtonIsDisabled();
//        }
        ussQuestionPage
                .logout();
    }
}

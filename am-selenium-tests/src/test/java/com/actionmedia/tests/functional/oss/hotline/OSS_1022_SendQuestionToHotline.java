package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 10/03/16.
 */
public class OSS_1022_SendQuestionToHotline extends AbstractDomainTest {

    private static final String QUESTION = "AUTOTEST " + RandomStringUtils.randomAlphabetic(5);

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1022", testCaseVersion = "3")
    public void oss_1022_test() {
        int[] numbers = getTwoNumbersOfSystems();
        for (int number : numbers) {
            switch (number) {
                case 0: {
                    bss_test();
                    break;
                }
                case 1: {
                    kss_vip_test();
                    break;
                }
                case 2: {
                    uss_test();
                    break;
                }
                case 3: {
                    bss_vip_test();
                    break;
                }
                case 4: {
                    gf_test();
                    break;
                }
                case 5: {
                    ot_test();
                    break;
                }
            }
        }
    }

    private void bss_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отправка вопроса на ГЛ БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private void bss_vip_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отправка вопроса на ГЛ БСС ВИП");
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .clickAuthorsTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .clickPersonalTab()
                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private void kss_vip_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отправка вопроса на ГЛ КСС ВИП");
        loginKss()
                .navigateToAnswersPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .clickAuthorsTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .clickPersonalTab()
                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private void uss_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отправка вопроса на ГЛ ЮСС");
        loginUss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private void gf_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется отправка вопроса на ГЛ ГФ КУ");
        loginGF()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickPersonalTab()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private void ot_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется отправка вопроса на ГЛ ГФ КУ");
        loginOT()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите сообщение")
                .checkErrorTextBoxPlaceholder()

                .inputTextInSendForm(QUESTION)
                .clearFieldsPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите код телефона")
                .checkErrorPhoneNumberPlaceholder()

                .clearEmailField()
                .inputRandomPhoneNumber()
                .clickSendButtonOnQuestionPage()
                .checkErrorMessage("Введите адрес электронной почты")
                .checkErrorEmailPlaceholder()

                .inputEmail("some@email.com")
                .clickSendButtonOnQuestionPage()
                .checkSendMessageIsPresent(QUESTION)

                .checkQuestionIsCreatedInSGCRM()
                .removeQuestionFromSGCRM()
                .checkQuestionIsRemovedFromSGCRM()

                .logout();
    }

    private int[] getTwoNumbersOfSystems() {
        int N = getMultiplicityOfWeekNumber();// number of release
        int CC1 = N % 6;
        int CC2 = (CC1 + 3) % 6;
        return new int[]{CC1, CC2};
    }
}

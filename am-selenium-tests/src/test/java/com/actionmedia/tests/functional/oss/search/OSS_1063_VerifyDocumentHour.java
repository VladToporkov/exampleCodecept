package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1063_VerifyDocumentHour extends AbstractDomainTest {

    private static final String QUERY = "89798789789789";
    private static final String NAME = "testletters";
    private static final String EMAIL = "testletters@action-media.ru";
    private static final String COMMENT = "коментарий";
    private static final String EMPTY_STRING = "";
    private static final String INCORRECT_NAME = "123123";
    private static final String INCORRECT_EMAIL_1 = "sdfsdf";
    private static final String INCORRECT_EMAIL_2 = "sdfsdf@";
    private static final String EMAIL_ERROR_1 = "Введите почту";
    private static final String EMAIL_ERROR_2 = "Почта должна содержать символ «@»";
    private static final String EMAIL_ERROR_3 = "Неверный формат электронной почты";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1063", testCaseVersion = "1")
    public void oss_1063_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-1063: Документ за час БСС КУ");
        bss_315_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-1063: Документ за час КСС КУ");
        kss_315_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-1063: Документ за час ЮСС КУ");
        uss_315_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-1063: Документ за час ФСС КУ");
        fss_315_test();
    }

    private void bss_315_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(QUERY)
                .clickSearchExtendedButton()

                .inputNameInDocumentForHourForm(EMPTY_STRING)
                .inputEmailInDocumentForHourForm(EMPTY_STRING)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_1)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_1)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_2)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_2)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_3)

                .inputNameInDocumentForHourForm(NAME)
                .inputEmailInDocumentForHourForm(EMAIL)
                .inputCommentInDocumentForHourForm(COMMENT)
                .clickSendButtonInDocumentForHourForm()
                .checkInputCorrectlyFormsDocumentForHour()

                .clickLinkNavigateToLawPageLink()
                .checkLawBaseTabIsSelected()
                .logout();
    }

    private void kss_315_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(QUERY)
                .clickSearchExtendedButton()

                .inputNameInDocumentForHourForm(EMPTY_STRING)
                .inputEmailInDocumentForHourForm(EMPTY_STRING)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_1)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_1)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_2)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_2)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_3)

                .inputNameInDocumentForHourForm(NAME)
                .inputEmailInDocumentForHourForm(EMAIL)
                .inputCommentInDocumentForHourForm(COMMENT)
                .clickSendButtonInDocumentForHourForm()
                .checkInputCorrectlyFormsDocumentForHour()

                .clickLinkNavigateToLawPageLink()
                .checkLawBaseTabIsSelected()
                .logout();
    }

    private void uss_315_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(QUERY)
                .clickSearchExtendedButton()

                .inputNameInDocumentForHourForm(EMPTY_STRING)
                .inputEmailInDocumentForHourForm(EMPTY_STRING)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_1)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_1)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_2)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_2)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_3)

                .inputNameInDocumentForHourForm(NAME)
                .inputEmailInDocumentForHourForm(EMAIL)
                .inputCommentInDocumentForHourForm(COMMENT)
                .clickSendButtonInDocumentForHourForm()
                .checkInputCorrectlyFormsDocumentForHour()

                .clickLinkNavigateToLawPageLink()
                .checkLawBaseTabIsSelected()
                .logout();
    }

    private void fss_315_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(QUERY)
                .clickSearchExtendedButton()

                .inputNameInDocumentForHourForm(EMPTY_STRING)
                .inputEmailInDocumentForHourForm(EMPTY_STRING)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_1)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_1)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_2)

                .inputNameInDocumentForHourForm(INCORRECT_NAME)
                .inputEmailInDocumentForHourForm(INCORRECT_EMAIL_2)
                .clickSendButtonInDocumentForHourForm()
                .checkNameErrorInDocumentForHourForm("Введите имя без цифр и знаков препинания")
                .checkEmailErrorInDocumentForHourForm(EMAIL_ERROR_3)

                .inputNameInDocumentForHourForm(NAME)
                .inputEmailInDocumentForHourForm(EMAIL)
                .clickSendButtonInDocumentForHourForm()
                .checkInputCorrectlyFormsDocumentForHour()

                .clickLinkNavigateToLawPageLink()
                .checkLawBaseTabIsSelected()
                .logout();
    }
}

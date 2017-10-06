package com.actionmedia.tests.functional.oss.magazines;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_455_VerifySendLink extends AbstractDomainTest {

    private static final String CORRECT_EMAIL = "autotester@action-media.ru";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-455", testCaseVersion = "3")
    public void oss_455_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Отправить коллеге БСС КУ");
        bss_264_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Отправить коллеге КСС КУ");
        kss_264_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Отправить коллеге ЮСС КУ");
        uss_264_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Отправить коллеге ФСС КУ");
        fss_264_test();
    }

    private void bss_264_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId("#/document/192/20881/actual")
                .report("Проверяется Отправить коллеге для БСС КУ #/document/192/20881/")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для БСС КУ #/document/189/370935/actual")
                .openDocumentByModuleIdAndDocId("#/document/189/370935/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .openDocumentByModuleIdAndDocId("#/document/125/24687/actual")
                .report("Проверяется Отправить коллеге для БСС КУ #/document/125/24687/")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для БСС КУ #/document/126/436591/actual")
                .openDocumentByModuleIdAndDocId("#/document/126/436591/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .logout();
    }

    private void kss_264_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId("#/document/189/368773/actual")
                .report("Проверяется Отправить коллеге для КСС КУ #/document/189/368773/")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для КСС КУ #/document/192/21125/actual")
                .openDocumentByModuleIdAndDocId("#/document/192/21125/")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .logout();
    }

    private void uss_264_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/192/20838/actual")
                .report("Проверяется Отправить коллеге для ЮСС КУ #/document/192/20838/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для ЮСС КУ #/document/189/369849/")
                .openDocumentByModuleIdAndDocId("#/document/189/369849/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для ЮСС КУ #/document/160/2745/")
                .openDocumentByModuleIdAndDocId("#/document/160/2745/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .logout();
    }

    private void fss_264_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId("#/document/192/20392/actual")
                .report("Проверяется Отправить коллеге для ФСС КУ #/document/192/20392/")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .report("Проверяется Отправить коллеге для ФСС КУ #/document/189/370190/")
                .openDocumentByModuleIdAndDocId("#/document/189/370190/actual")
                .checkMailButtonIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .inputEmailInMailForm("автотестер@майл.ру")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Неверный формат электронной почты")
                .inputEmailInMailForm("autotesteraction-media.ru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать символ «@»")
                .inputEmailInMailForm("autotester@action-mediaru")
                .clickSendInMailForm()
                .checkErrorMessageInMailForm("Почта должна содержать точку в имени домена")
                .inputEmailInMailForm(CORRECT_EMAIL)
                .clickSendInMailForm()
                .checkMailFormIsNotPresent()

                .logout();
    }
}

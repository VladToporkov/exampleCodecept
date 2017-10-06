package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 02/03/16.
 */
public class OSS_288_OpenSurchargeDocument extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-288", testCaseVersion = "1")
    public void oss_288_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("budget");
        updateLoginAsInfo("user.demo");
        report("Проверка Переход в платный документ БСС БУ");
        step1_bss();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("user.demo");
        report("Проверка Переход в платный документ КСС ВИП");
        step1_kss();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.demo");
        report("Проверка Переход в платный документ ЮСС КУ");
        step1_uss();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.demo.2");
        updateLoginToInfo("doc");
        report("Проверка Переход в платный документ ЮСС КУ");
        step2_uss();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("user.demo.2");
        report("Проверка Переход в платный документ БСС ВИП");
        step3_bss();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("user.demo.2");
        report("Проверка Переход в платный документ КСС ВИП");
        step4_kss();
    }

    private void step1_bss() {
        loginBss()
                .openDocumentByModuleIdAndDocId("#/document/11/42024/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkTryTrialFormIsPresent()
                .checkTryTrialForm()
                .logout();
    }

    private void step1_kss() {
        loginKss()
                .openDocumentByModuleIdAndDocId("#/document/130/51188/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkTryTrialFormIsPresent()
                .checkTryTrialForm()
                .logout();
    }

    private void step1_uss() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/165/542/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkTryTrialFormIsPresent()
                .checkTryTrialForm()
                .logout();
    }

    private void step2_uss() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/document/165/542/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkSubscribeActivationFormIsPresent()
                .checkSubscribeActivationForm()
                .logout();
    }

    private void step3_bss() {
        loginBss()
                .openDocumentByModuleIdAndDocId("#/document/11/13234/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkSubscribeActivationFormIsPresent()
                .checkSubscribeActivationFormCellPhoneNumberIsPresent()
                .logout();
    }

    private void step4_kss() {
        loginKss()
                .openDocumentByModuleIdAndDocId("#/document/130/51188/")
                .checkDocPreviewTextStatus()
                .checkAuthFormIsPresent()
                .checkTryTrialFormHasText("Вы сейчас находитесь в Справочной системе КСС «Cистема Кадры» ВИП-версия.\n" +
                        "A оплаченный доступ у вас есть к КСС «Система Кадры» для коммерческих организаций.")
                .checkTryTrialFormIsPresent()
                .checkTryTrialForm()
                .logout();
    }
}

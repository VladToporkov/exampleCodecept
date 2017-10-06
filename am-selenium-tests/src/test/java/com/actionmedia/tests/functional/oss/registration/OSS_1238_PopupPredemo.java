package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/02/16.
 */
public class OSS_1238_PopupPredemo extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1238", testCaseVersion = "1")
    public void oss_1238_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                test_uss();
                break;
            }
            case 1: {
                test_fss();
                break;
            }
            case 2: {
                test_bss();
                break;
            }
            case 3: {
                test_kss();
                break;
            }
        }
    }

    private void test_uss() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Вызов формы Предемо ЮСС КУ");
        loginUss()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/165/3068/actual")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/190/15147/actual")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/123/3/actual")
                .checkPopupPreDemoIsNotPresent()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/handbook/")
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()
                .logout();

        enterToUssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/165/3052/actual")
                .checkPopupPreDemoIsPresent()

                .clickOnClosePopupPreDemo()
                .checkAuthFormIsPresent()
                .checkDocPreviewTextStatus();

        loginUss()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/165/3052/actual")
                .checkPopupPreDemoIsNotPresent()

                .logout();
    }

    private void test_fss() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Вызов формы Предемо ФСС КУ");

        loginFss()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/207/2012/actual")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()
                .logout();

        enterToFssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/123/3/actual")
                .checkAuthFormIsPresent()
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/solutions/")
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()
                .logout();

        enterToFssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/207/2012/actual")
                .checkPopupPreDemoIsPresent()

                .clickOnClosePopupPreDemo()
                .checkAuthFormIsPresent()
                .checkDocPreviewTextStatus()
                .deleteCookies();

        loginFss()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/207/2012/actual")
                .checkPopupPreDemoIsNotPresent()
                .logout();
    }

    private void test_bss() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Вызов формы Предемо БСС ВИП");

        loginBss()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/11/14438/actual")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()
                .logout()
                .openPageByUrl("https://id2.action-media.ru/Account/LogOff");

        enterToBssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/184/3120/actual")
                .checkPopupPreDemoIsNotPresent()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/123/3/actual")
                .checkPopupPreDemoIsNotPresent()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/hotline/")
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies();

        enterToBssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/11/14438/actual")
                .checkPopupPreDemoIsPresent()

                .clickOnClosePopupPreDemo()
                .checkAuthFormIsPresent()
                .checkDocPreviewTextStatus()

                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/11/14438/actual")
                .checkPopupPreDemoIsNotPresent();

    }

    private void test_kss() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Вызов формы Предемо КСС КУ");
        loginKss()
                .openDocumentByModuleIdAndDocId("/#/documentvideo/145/787/?utm_source=test&utm_medium=test")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()
                .logout();

        enterToKssWithoutLogin()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/99/901807664/actual")
                .checkDocumentIsOpened()
                .checkPopupPreDemoIsNotPresent()
                .openDocumentByModuleIdAndDocId("/?utm_source=test&utm_medium=test#/document/123/3/actual")
                .checkPopupPreDemoIsNotPresent()

                .openDocumentByModuleIdAndDocId("#/forms/?utm_source=test&utm_medium=test")
                .checkPopupPreDemoIsNotPresent()
                .deleteCookies()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/787/?utm_source=test&utm_medium=test")
                .checkPopupPreDemoIsPresent()

                .clickOnClosePopupPreDemo()
                .checkAuthFormIsPresent()
                .checkDocPreviewTextStatus()

                .openDocumentByModuleIdAndDocId("#/documentvideo/145/787/?utm_source=test&utm_medium=test")
                .checkPopupPreDemoIsNotPresent();

    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}



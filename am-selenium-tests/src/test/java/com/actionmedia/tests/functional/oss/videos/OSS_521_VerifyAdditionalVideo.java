package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 06.04.2015
 * Time: 16:13
 */
public class OSS_521_VerifyAdditionalVideo extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-521", testCaseVersion = "2")
    public void oss_521_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-521:Доп.материалы (Видео) КСС КУ");
        kss_521_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-521:Доп.материалы (Видео) БСС КУ");
        bss_521_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-521:Доп.материалы (Видео) ЮСС КУ");
        uss_521_test();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется OSS-521:Доп.материалы (Видео) ГФ КУ");
        gf_521_test();

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется OSS-521:Доп.материалы (Видео) ОБР КУ");
        obr_521_test();
    }

    private void kss_521_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2576/")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkFooter()
                .logout();
    }

    private void bss_521_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/3763/")
                .checkDocumentIsNotEmpty()
                .checkInfoBarWidgetWork()
                .checkFooter()
                .checkDocumentTitleIsPresent()
                .logout();
    }

    private void uss_521_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/2598/")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkFooter()

                .openDocumentByModuleIdAndDocId("#/document/163/36/")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkFooter()
                .logout();
    }

    private void gf_521_test() {
        loginGF()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/3256/")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkFooter()
                .logout();
    }

    private void obr_521_test() {
        loginEdu()
                .openDocumentByModuleIdAndDocId("#/documentvideo/145/3490/")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetWork()
                .checkFooter()
                .logout();
    }
}

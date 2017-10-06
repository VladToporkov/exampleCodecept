package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 19/01/16.
 */
public class OSS_630_InfobarLinks extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/11/13621";
    private static final String DOCUMENT_URL_VIP = "#/document/113/3178";
    private static final String DOCUMENT_URL_USS_VIP = "#/document/165/2759";
    private static final String DOCUMENT_URL_KSS_BU = "#/document/161/51245";
    private static final String DOCUMENT_URL_FSS_1 = "#/document/173/1080";
    private static final String DOCUMENT_URL_FSS_2 = "#/document/178/41";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-630", testCaseVersion = "1")
    public void oss_630_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Меню доп.материалов БСС КУ");
        bss_test();

        //BSS VIP
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Меню доп.материалов БСС ВИП");
        bss_vip_test();

        //KSS BU
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Меню доп.материалов КСС БУ");
        kss_test();

        //USS DOC
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Меню доп.материалов КСС ВИП");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Меню доп.материалов ФСС");
        fss_test();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Меню доп.материалов МЦФЭР ГФ");
        gf_test();
    }

    private void bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .clickDocumentInfobarLink()
                .checkInfobarCardIsPresent()

                .checkInfobarBlocksLinks()
                .clickDocumentInfobarLink()
                .checkDocumentInfobarBottom()
                .logout();
    }

    private void bss_vip_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_VIP)
                .clickDocumentInfobarLink()
                .checkTextDocumentEditionFrom()

                .logout();
    }

    private void kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_BU)
                .clickDocumentInfobarLink()
                .checkTextDocumentEditionFrom()

                .logout();
    }

    private void uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_VIP)
                .clickDocumentInfobarLink()
                .checkTextDocumentEditionFrom()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_1)
                .clickDocumentInfobarLink()
                .checkMenu()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_2)
                .clickDocumentInfobarLink()
                .checkMenu()

                .logout();
    }

    private void gf_test() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .clickDocumentInfobarLink()
                .checkInfobarCardIsPresent()

                .checkInfobarBlocksLinks()
                .clickDocumentInfobarLink()
                .checkDocumentInfobarBottom()
                .logout();
    }
}

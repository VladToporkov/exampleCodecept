package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/01/16.
 */
public class OSS_640_TitleTagRecomendationDocument extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS_TITLE_1 = "#/document/11/13621";
    private static final String DOCUMENT_URL_BSS_TITLE_2 = "#/document/12/69161";
    private static final String DOCUMENT_URL_BSS_TITLE_3 = "#/document/199/10265";
    private static final String DOCUMENT_URL_BSS_TITLE_4 = "#/document/86/68597";
    private static final String DOCUMENT_URL_BSS_TITLE_6 = "#/document/197/291";
    private static final String DOCUMENT_URL_BSS_TITLE_7 = "#/document/210/6";
    private static final String DOCUMENT_URL_BSS_TITLE_8 = "#/document/184/2356";
    private static final String DOCUMENT_URL_BSS_TITLE_9 = "#/document/14/19417";
    private static final String DOCUMENT_URL_BSS_TITLE_11 = "#/document/113/3";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-640", testCaseVersion = "2")
    public void oss_640_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общий функционал документов Мета тег Title БСС КУ");
        bss_test();

        //BSS BU
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общий функционал документов Мета тег Title БСС БУ");
        bss_bu_test();

        //BSS УСН
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общий функционал документов Мета тег Title БСС УСН");
        bss_usn_test();

        //BSS ВИП
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общий функционал документов Мета тег Title БСС ВИП");
        bss_vip_test();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общий функционал документов Мета тег Title МЦФЭР ГФ");
        gf_test();
    }

    private void bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_1)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_2)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_3)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_4)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_6)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_7)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_8)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_9) //bug in the test-case, wait for resolved
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_11)
                .checkTitleTag()

                .openByPartialUrl("/")
                .checkTagTitle()

                .logout();
    }

    private void bss_bu_test() {
        loginBss()
                .openByPartialUrl("/")
                .checkTagTitle()

                .logout();
    }

    private void bss_usn_test() {
        loginBss()
                .openByPartialUrl("/")
                .checkTagTitle()

                .logout();
    }

    private void bss_vip_test() {
        loginBss()
                .openByPartialUrl("/")
                .checkTagTitle()

                .logout();
    }

    private void gf_test() {
        loginGF()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_1)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_2)
                .checkTitleTag()

//                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_3)
//                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_4)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_6)
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_7)
                .checkTitleTag()

//                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_8)
//                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_9) //bug in the test-case, wait for resolved
                .checkTitleTag()

                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_TITLE_11)
                .checkTitleTag()

                .openByPartialUrl("/")
                .checkTagTitle()

                .logout();
    }
}

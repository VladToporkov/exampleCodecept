package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1197_LinkParentDoc extends AbstractDomainTest {

    public static final String DOCUMENT_URL_BSS_KU = "#/document/12/68/";
    public static final String DOCUMENT_URL_BSS_BU = "#/document/86/145/";
    public static final String DOCUMENT_URL_KSS_KU = "#/document/161/18/";
    public static final String DOCUMENT_URL_KSS_BU = "#/document/131/1/";
    public static final String DOCUMENT_URL_USS = "#/document/131/1120/";
    public static final String DOCUMENT_URL_FSS_178 = "#/document/178/2/";
    public static final String DOCUMENT_URL_FSS_185 = "#/document/185/6/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1197", testCaseVersion = "1")
    public void oss_1197_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Наличие ссылки на родительский документ БСС КУ");
        bss_parent_doc(DOCUMENT_URL_BSS_KU);

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Наличие ссылки на родительский документ КСС БУ");
        bss_parent_doc(DOCUMENT_URL_BSS_BU);

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Наличие ссылки на родительский документ КСС КУ");
        kss_parent_doc(DOCUMENT_URL_KSS_KU);

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Проверяется Наличие ссылки на родительский документ КСС БУ");
        kss_parent_doc(DOCUMENT_URL_KSS_BU);

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Наличие ссылки на родительский документ ЮСС");
        uss_parent_doc(DOCUMENT_URL_USS);

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Наличие ссылки на родительский документ ФСС");
        fss_parent_doc(DOCUMENT_URL_FSS_178);
        fss_parent_doc(DOCUMENT_URL_FSS_185);
    }

    private void bss_parent_doc(String url) {
        loginBss()
                .openDocumentByModuleIdAndDocId(url)
                .checkDocumentIsOpened()

                .checkParentDocumentLinkIsPresent()
                .checkParentDocumentLinkFormat("Из рекомендации")
                .checkParentDocumentLinkIsItalicStyle()
                .checkParentDocumentLinkInBottom()

                .clickParentDocumentLink()
                .checkDocumentIsNotEmpty()
                .checkParentDocumentTitle()

                .logout();
    }

    private void kss_parent_doc(String url) {
        loginKss()
                .openDocumentByModuleIdAndDocId(url)
                .checkDocumentIsOpened()

                .checkParentDocumentLinkIsPresent()
                .checkParentDocumentLinkFormat("Из ответа")
                .checkParentDocumentLinkIsItalicStyle()
                .checkParentDocumentLinkInBottom()

                .clickParentDocumentLink()
                .checkDocumentIsOpened()
                .checkParentDocumentTitle()

                .logout();
    }

    private void uss_parent_doc(String url) {
        loginUss()
                .openDocumentByModuleIdAndDocId(url)
                .checkDocumentIsOpened()

                .checkParentDocumentLinkIsPresent()
                .checkParentDocumentLinkFormat("Из рекомендации")
                .checkParentDocumentLinkIsItalicStyle()
                .checkParentDocumentLinkInBottom()

                .clickParentDocumentLink()
                .checkDocumentIsOpened()
                .checkParentDocumentTitle()

                .logout();
    }

    private void fss_parent_doc(String url) {
        loginFss()
                .openDocumentByModuleIdAndDocId(url)
                .checkDocumentIsOpened()

                .checkParentDocumentLinkIsPresent()
                .checkParentDocumentLinkFormat("Из решения")
                .checkParentDocumentLinkIsItalicStyle()
                .checkParentDocumentLinkInBottom()

                .clickParentDocumentLink()
                .checkDocumentIsOpened()
                .checkParentDocumentTitle()

                .logout();
    }
}

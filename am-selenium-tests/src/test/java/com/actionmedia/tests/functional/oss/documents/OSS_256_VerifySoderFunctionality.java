package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.01.16
 * Time: 20:47
 */
public class OSS_256_VerifySoderFunctionality extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS = "#/document/99/901714421/";
    private static final String DOCUMENT_URL_KSS = "#/document/99/901807664/";
    private static final String DOCUMENT_URL_USS = "#/document/99/9027690/";
    private static final String DOCUMENT_URL_FSS = "#/document/99/9027690/";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-256", testCaseVersion = "1")
    public void oss_256_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Оглавление (Правовая база) БСС КУ");
        oss_256_bss_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Оглавление (Правовая база) КСС КУ");
        oss_256_kss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Оглавление (Правовая база) ЮСС КУ");
        oss_256_uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Оглавление (Правовая база) ФСС КУ");
        oss_256_fss_test();
    }

    private void oss_256_bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS)
                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()
                .checkDisplayTableOfContentsForKodeks()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .clickDocumentHeader()
                .checkTableOfContentsButtonIsUnPressed()

                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()

                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()
                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .logout();
    }

    private void oss_256_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS)
                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()
                .checkDisplayTableOfContentsForKodeks()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .clickDocumentHeader()
                .checkTableOfContentsButtonIsUnPressed()

                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()

                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()
                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .logout();
    }

    private void oss_256_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS)
                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()
                .checkDisplayTableOfContentsForKodeks()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .clickDocumentHeader()
                .checkTableOfContentsButtonIsUnPressed()

                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()

                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()
                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .logout();
    }

    private void oss_256_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS)
                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()
                .checkDisplayTableOfContentsForKodeks()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .clickDocumentHeader()
                .checkTableOfContentsButtonIsUnPressed()

                .clickTableOfContentsButton()
                .checkTableOfContentsButtonIsPressed()

                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()
                .clickRandomArticleFromTableOfContents()
                .checkTableOfContentsButtonIsUnPressed()
                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContentsForKodeks()

                .logout();
    }
}
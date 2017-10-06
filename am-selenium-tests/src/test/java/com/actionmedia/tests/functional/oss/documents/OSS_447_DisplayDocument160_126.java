package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 26.02.2015.
 */
public class OSS_447_DisplayDocument160_126 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Все журналы и книги";
    private static final String DOCUMENT_URL_KSS_160 = "#/document/160/3181/";
    private static final String DOCUMENT_URL_BSS_160 = "#/document/160/2195567/";
    private static final String DOCUMENT_URL_USS_160 = "#/document/160/9517/";
    private static final String DOCUMENT_URL_FSS_160 = "#/document/160/2196119/";
    private static final String DOCUMENT_URL_KSS_126 = "#/document/126/337494/";
    private static final String DOCUMENT_URL_BSS_126 = "#/document/126/371071/";
    private static final String DOCUMENT_URL_USS_126 = "#/document/126/295130/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-447", testCaseVersion = "1")
    public void oss_447_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов (160, 126 модуль Книги) БСС КУ");
        BssBasePage bssBasePage = loginBss();
        bssDocument_160(bssBasePage);
        bssDocument_126(bssBasePage);

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов (160, 126 модуль Книги) КСС КУ");
        KssBasePage kssBasePage = loginKss();
        kssDocument_160(kssBasePage);
        kssDocument_126(kssBasePage);

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов (160, 126 модуль Книги) ЮСС КУ");
        UssBasePage ussBasePage = loginUss();
        ussDocument_160(ussBasePage);
        ussDocument_126(ussBasePage);

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов (160, 126 модуль Книги) ФСС КУ");
        fssDocument_160();
    }

    private void kssDocument_160(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_160)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkDisplayStars()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkBrowseIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void kssDocument_126(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_126)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }

    private void bssDocument_160(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_160)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkDisplayStars()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void bssDocument_126(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_126)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkBrowseIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }

    private void ussDocument_160(UssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_160)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkDisplayStars()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void ussDocument_126(UssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_126)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }

    private void fssDocument_160() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_160)
                .checkBooksNameAndAuthor()
                .checkImageBook()
                .checkNameDocument()
                .checkDisplayTextDocumentInParagraphs()
                .checkDisplayStars()
                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkBackwardIcon()
                .checkForwardIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }
}
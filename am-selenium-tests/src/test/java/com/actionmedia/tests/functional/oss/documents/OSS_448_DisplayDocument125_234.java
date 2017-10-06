package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 26.02.2015.
 */
public class OSS_448_DisplayDocument125_234 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Все журналы и книги";
    private static final String BUTTON_NAME_USS = "Все журналы";
    private static final String DOCUMENT_URL_KSS_234 = "#/document/234/58/";
    private static final String DOCUMENT_URL_BSS_234 = "#/document/234/365/";
    private static final String DOCUMENT_URL_USS_234 = "#/document/234/42/";
    private static final String DOCUMENT_URL_FSS_234 = "#/document/234/346/";
    private static final String DOCUMENT_URL_KSS_125 = "#/document/125/20753";
    private static final String DOCUMENT_URL_BSS_125 = "#/document/125/21736/";
    private static final String DOCUMENT_URL_USS_125 = "#/document/125/22212/";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-448", testCaseVersion = "1")
    public void oss_448_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение документов (234, 125 модуль Книги-Стартовая) КСС КУ");
        KssBasePage kssBasePage = loginKss();
        kssDocument_234(kssBasePage);
        kssDocument_125(kssBasePage);

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов (234, 125 модуль Книги-Стартовая) БСС КУ");
        BssBasePage bssBasePage = loginBss();
        bssDocument_234(bssBasePage);
        bssDocument_125(bssBasePage);

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение документов (234, 125 модуль Книги-Стартовая) ЮСС КУ");
        UssBasePage ussBasePage = loginUss();
        ussDocument_234(ussBasePage);
        ussDocument_125(ussBasePage);

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение документов (234, 125 модуль Книги-Стартовая) ФСС КУ");
        fssDocument_234();
    }

    private void kssDocument_234(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_234)
                .checkBooksName()
                .checkAuthor()
                .checkImageBook()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent();
    }

    private void kssDocument_125(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_125)
                .checkBooksName()
                .checkAuthor()
                .checkImageBook()
                .checkDisplayDescriptionList()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void bssDocument_234(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_234)
                .checkBooksName()
                .checkAuthor()
                .checkImageBook()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent();
    }

    private void bssDocument_125(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_125)
                .checkBooksName()
                .checkImageBook()
                .checkDisplayDescriptionList()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void ussDocument_234(UssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_234)
                .checkBooksName()
                .checkImageBook()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_USS)
                .checkMyFavoritesRubricatorButtonIsPresent();

    }

    private void ussDocument_125(UssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_125)
                .checkBooksName()
                .checkImageBook()
                .checkDisplayDescriptionList()

                .checkInMyFavoritesIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_USS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void fssDocument_234() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_234)
                .checkBooksName()
                .checkAuthor()
                .checkImageBook()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkNotPresentShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }
}
package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.edu.EduBasePage;
import com.actionmedia.pages.fss.FssBasePage;
import com.actionmedia.pages.gf.GFBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.ot.OTBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 28.02.2015.
 */
public class OSS_450_DisplayDocument192_233 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Все журналы и книги";
    private static final String BUTTON_NAME_ALL_MAGAZINES = "Все журналы";
    private static final String DOCUMENT_URL_KSS_192 = "#/document/192/11678/";
    private static final String DOCUMENT_URL_BSS_192 = "#/document/192/20998/";
    private static final String DOCUMENT_URL_USS_192 = "#/document/192/20875";
    private static final String DOCUMENT_URL_FSS_192 = "#/document/192/21290/";
    private static final String DOCUMENT_URL_GF_192 = "#/document/192/23279/";
    private static final String DOCUMENT_URL_EDU_192 = "#/document/189/446871/";
    private static final String DOCUMENT_URL_OT_192 = "#/document/189/418497/";
    private static final String DOCUMENT_URL_KSS_233 = "#/document/233/681/";
    private static final String DOCUMENT_URL_BSS_233 = "#/document/233/24/";
    private static final String DOCUMENT_URL_USS_233 = "#/document/233/3372/";
    private static final String DOCUMENT_URL_FSS_233 = "#/document/233/24/";
    private static final String DOCUMENT_URL_GF_233 = "#/document/233/24/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-450", testCaseVersion = "3")
    public void oss_450_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) КСС КУ");
        kssDocument_192();
        kssDocument_233();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) БСС КУ");
        bssDocument_192();
        bssDocument_233();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) ЮСС КУ");
        ussDocument_192();
        ussDocument_233();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) ФСС КУ");
        fssDocument_192();
        fssDocument_233();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) ГФ КУ");
        gfDocument_192();
        gfDocument_233();

//        OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) ОТ КУ");
        otDocument_192();

//        EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется  Общее отображение документов (192, 233 модуль Журналы) ОБР КУ");
        eduDocument_192();
    }

    private void kssDocument_192() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_192)
                .checkDisplayNameJournal_192()
                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void kssDocument_233() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_233)

                .checkNameAndNumberJournal()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void bssDocument_192() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_192)

                .checkDisplayNameJournal_192()
                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
        .logout();
    }

    private void bssDocument_233() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_233)

                .checkNameAndNumberJournal()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void ussDocument_192() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_192)

                .checkDisplayNameJournal_192()
                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()
                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void ussDocument_233() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_233)

                .checkNameAndNumberJournal()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void fssDocument_192() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_192)

                .checkDisplayNameJournal_192()
                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void gfDocument_192() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_GF_192)

                .checkDisplayNameJournal_192()
                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void otDocument_192() {
        loginOT()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_OT_192)

                .checkDisplayNameJournal_192()
//                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void eduDocument_192() {
        loginEdu()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_EDU_192)

                .checkDisplayNameJournal_192()
//                .checkNumberJournal_192()
                .checkDisplayTableOfContents_192()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()

                .checkShareIcon()


                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();

    }

    private void fssDocument_233() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_233)

                .checkNameAndNumberJournal()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void gfDocument_233() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_GF_233)

                .checkNameAndNumberJournal()
                .checkDisplayTableOfContents()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkShareIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}
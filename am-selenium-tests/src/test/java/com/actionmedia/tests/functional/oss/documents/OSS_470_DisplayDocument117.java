package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 28.02.2015.
 */
public class OSS_470_DisplayDocument117 extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Весь справочник";
    private static final String DOCUMENT_URL_KSS_117 = "#/document/117/17617";
    private static final String DOCUMENT_URL_BSS_117 = "#/document/117/18125/";
    private static final String DOCUMENT_URL_USS_117 = "#/document/117/16525/";
    private static final String DOCUMENT_URL_FSS_117 = "#/document/117/17412/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-470", testCaseVersion = "1")
    public void oss_470_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Проверить отображение документов 117 модуля КСС КУ");
        kssDocument_117();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Проверить отображение документов 117 модуля БСС КУ");
        bssDocument_117();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется  Проверить отображение документов 117 модуля ЮСС КУ");
        ussDocument_117();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Проверить отображение документов 117 модуля ФСС КУ");
        fssDocument_117();
    }

    private void kssDocument_117() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_117)

                .checkSearchIn()
                .checkRevisionIsValidFrom()
                .checkMenu()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable()

                .logout();
    }

    private void bssDocument_117() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_117)

                .checkSearchIn()
                .checkRevisionIsValidFrom()
                .checkMenu()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable()

                .logout();
    }

    private void ussDocument_117() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_117)

                .checkSearchIn()
                .checkRevisionIsValidFrom()
                .checkMenu()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable()

                .logout();
    }

    private void fssDocument_117() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_117)

                .checkSearchIn()
                .checkRevisionIsValidFrom()
                .checkMenu()

                .checkPrintIcon()
                .checkWordButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkDisplayStarsSection()
                .checkDisplayStarsTable_117()

                .logout();
    }
}
package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 02/02/16.
 */
public class OSS_613_DisplayDocuments14 extends AbstractDomainTest {

    private final static String DOC_PART_URL_BSS = "#/document/14/random";
    private final static String DOC_PART_URL_GF = "#/document/14/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-613", testCaseVersion = "2")
    public void oss_613_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 14 модуль БСС КУ");
        bssDocument_14();

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 14 модуль МЦФЭР ГФ");
        gfDocument_14();
    }

    private void bssDocument_14() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_BSS)
                .checkTextDocumentEditionFromInDocHeader()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkLogoGlavbukhInDocumentContentFooter()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

    private void gfDocument_14() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_GF)
                .checkTextDocumentEditionFromInDocHeader()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkLogoGlavbukhInDocumentContentFooter()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

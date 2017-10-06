package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/03/16.
 */
public class OSS_1304_DisplayDocuments210 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/210/random";
    private final static String DOC_PART_URL_GF = "#/document/210/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1304", testCaseVersion = "2")
    public void oss_1304_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 210 модуль БСС КУ");
        bssDocument_210();

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 210 модуль МЦФЭР ГФ");
        gfDocument_210();
    }

    private void bssDocument_210() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkTextContainsBlocksHowToAndWhatToDo()

                .checkDocumentRatingIsPresent()

                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

    private void gfDocument_210() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_GF)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkTextContainsBlocksHowToAndWhatToDo()

                .checkDocumentRatingIsPresent()

                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

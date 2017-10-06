package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 08/02/16.
 */
public class OSS_610_DisplayDocuments199 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/199/10304";
    private final static String DOC_PART_URL_GF = "#/document/199/10182";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-610", testCaseVersion = "2")
    public void oss_610_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 199 модуль БСС КУ");
        bssDocument_199();

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 199 модуль МЦФЭР ГФ");
        gfDocument_199();
    }

    private void bssDocument_199() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkBriefBlockIsPresent()

                .checkTextBlocksForDocument199_10304()

                .checkDocumentRatingIsPresent()

                .checkSoderIsPresent()

                .checkRubricatorButtonIsPresent("Весь справочник")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

    private void gfDocument_199() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_GF)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkBriefBlockIsPresent()

                .checkTextBlocksForDocument199_10182()

                .checkDocumentRatingIsPresent()

                .checkSoderIsPresent()

                .checkRubricatorButtonIsPresent("Весь справочник")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

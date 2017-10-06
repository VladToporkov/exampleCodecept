package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 03/02/16.
 */
public class OSS_614_DisplayDocuments113 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/113/random";
    private final static String DOC_PART_URL_GF = "#/document/113/random";
    private final static String DOC_PART_URL_VIP = "#/document/113/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-614", testCaseVersion = "2")
    public void oss_614_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 113 модуль БСС КУ");
        bssDocument_113(DOC_PART_URL);

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов 113 модуль БСС ВИП");
        bssDocument_113(DOC_PART_URL_VIP);

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 113 модуль МЦФЭР ГФ");
        gfDocument_113(DOC_PART_URL_GF);
    }

    private void bssDocument_113(String docPartUrl) {
        loginBss()
                .openDocumentByModuleIdAndDocId(docPartUrl)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Весь справочник")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

    private void gfDocument_113(String docPartUrl) {
        loginGF()
                .openDocumentByModuleIdAndDocId(docPartUrl)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Весь справочник")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

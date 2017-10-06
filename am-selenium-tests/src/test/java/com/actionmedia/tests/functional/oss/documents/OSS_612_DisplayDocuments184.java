package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/02/16.
 */
public class OSS_612_DisplayDocuments184 extends AbstractDomainTest {

    private final static String DOC_PART_URL_BSS = "#/document/184/4942/actual";
    private final static String DOC_PART_URL_BSS_BU = "#/document/184/4942/actual";
    private final static String DOC_PART_URL_BSS_USN = "#/document/184/4942/actual";
    private final static String DOC_PART_URL_BSS_VIP = "#/document/184/4942/actual";
    private final static String DOC_PART_URL_GF = "#/document/184/790/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-612", testCaseVersion = "1")
    public void oss_612_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 184 модуль БСС КУ");
        bssDocument_184(DOC_PART_URL_BSS);

        updateLoginAsInfo("bss.user.commercial");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение документов 184 модуль БСС БУ");
        bssDocument_184(DOC_PART_URL_BSS_BU);

        updateLoginAsInfo("bss.user.commercial");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение документов 184 модуль БСС УСН");
        bssDocument_184(DOC_PART_URL_BSS_USN);

        updateLoginAsInfo("bss.user.commercial");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов 184 модуль БСС ВИП");
        bssDocument_184(DOC_PART_URL_BSS_VIP);

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 184 модуль МЦФЭР ГФ");
        gfDocument_184();
    }

    private void bssDocument_184(String document) {
        loginBss()
                .openDocumentByModuleIdAndDocId(document)
                .checkTextDocumentEditionFromInDocHeader()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkSocialBlockIsPresent()

//                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

//    private void bssDocument_184_expert() {
//        loginBss()
//                .openDocumentByModuleIdAndDocId(DOC_PART_URL_2)
//                .checkTitleWithModIdPubForRedactorUser()
//
//                .logout();
//    }

    private void gfDocument_184() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_GF)
                .checkTextDocumentEditionFromInDocHeader()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkDocumentTitleIsPresent()
                .checkContentIsPresent()

                .checkSocialBlockIsPresent()

//                .checkSoderIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

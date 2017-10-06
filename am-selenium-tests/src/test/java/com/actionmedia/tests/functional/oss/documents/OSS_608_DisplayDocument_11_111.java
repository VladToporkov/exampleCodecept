package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 25/01/16.
 */
public class OSS_608_DisplayDocument_11_111 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/111/12450";
    private final static String DOC_PART_URL_VIP = "#/document/11/13621";
    private final static String DOC_PART_URL_VIP_PROVODKI = "#/document/11/13565/fys11";
    private final static String DOC_PART_URL_VIP_TRANSPORT_TAX = "#/document/11/14355/dfas0oew45";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-608", testCaseVersion = "3")
    public void oss_608_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов БСС КУ");
        bssDocument_11_111();

        //BSS VIP
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов БСС ВИП");
        bssVIPDocument_11_111();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов МЦФЭР ГФ");
        gfDocument_11_111();
    }

    private void bssDocument_11_111() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkInCut()

                .checkSoderIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP_PROVODKI)
                .checkProvodkiForDocument11_13565()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP_TRANSPORT_TAX)
                .checkTransportTaxForDoc_11_14355()

                .logout();
    }

    private void bssVIPDocument_11_111() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()

                .checkTitleAndAuthorInformationPresent()
                .checkInCut()

                .checkSoderIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void gfDocument_11_111() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkInCut()

                .checkSoderIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_VIP_TRANSPORT_TAX)
                .checkTransportTaxForDoc_11_14355()

                .logout();
    }
}

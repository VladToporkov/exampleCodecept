package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 27/01/16.
 */
public class OSS_609_DisplayDocument_12_112 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/12/random";
    private final static String DOC_PART_URL_VIP = "#/document/112/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-609", testCaseVersion = "2")
    public void oss_609_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов БСС КУ");
        bssDocument_11_111(DOC_PART_URL);

        //BSS VIP
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение документов БСС ВИП");
        bssDocument_11_111(DOC_PART_URL_VIP);

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов МЦФЭР ГФ");
        gfDocument_11_111(DOC_PART_URL);
    }

    private void bssDocument_11_111(String docPartUrl) {
        loginBss()
                .openDocumentByModuleIdAndDocId(docPartUrl)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkInCut()

                .checkDocumentRatingIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }

    private void gfDocument_11_111(String docPartUrl) {
        loginGF()
                .openDocumentByModuleIdAndDocId(docPartUrl)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkInCut()

                .checkDocumentRatingIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();
    }
}

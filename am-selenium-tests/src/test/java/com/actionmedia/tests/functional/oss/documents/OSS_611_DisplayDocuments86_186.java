package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/02/16.
 */
public class OSS_611_DisplayDocuments86_186 extends AbstractDomainTest {

    private final static String DOC_PART_URL_1 = "#/document/86/random";
    private final static String DOC_PART_URL_2 = "#/document/186/random";
    private final static String DOC_PART_URL_GF_1 = "#/document/86/random";
    private final static String DOC_PART_URL_GF_2 = "#/document/86/random";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-611", testCaseVersion = "2")
    public void oss_611_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 86 и 186 модули БСС КУ");
        bssDocument_86(DOC_PART_URL_1);
        bssDocument_86(DOC_PART_URL_2);

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 86 и 186 модули МЦФЭР ГФ");
        gfDocument_86(DOC_PART_URL_GF_1);
        gfDocument_86(DOC_PART_URL_GF_2);
    }

    private void bssDocument_86(String document) {
        loginBss()
                .openDocumentByModuleIdAndDocId(document)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkParentDocumentLinkIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();

    }

    private void gfDocument_86(String document) {
        loginGF()
                .openDocumentByModuleIdAndDocId(document)
                .checkMenu()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkPrintIcon()

                .checkTitleAndAuthorInformationPresent()
                .checkContentIsPresent()

                .checkParentDocumentLinkIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все рекомендации")

                .checkAddToFavoritesButtonsForDocumentArePresent()

                .logout();

    }
}

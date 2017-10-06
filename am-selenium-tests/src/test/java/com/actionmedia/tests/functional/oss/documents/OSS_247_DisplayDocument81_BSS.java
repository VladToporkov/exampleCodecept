package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.01.16
 * Time: 22:47
 */
public class OSS_247_DisplayDocument81_BSS extends AbstractDomainTest {

    private static final String BSS_DOCUMENT_URL = "#/document/81/113098";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-247", testCaseVersion = "1")
    public void oss_247_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (81 модуль) БСС КУ");
        oss_247_bss_test("Все кодексы и ПБУ");

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (81 модуль) БСС БУ");
        oss_247_bss_test("Все кодексы");

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется  Общее отображение документов (81 модуль) БСС УСН");
        oss_247_bss_test("Все кодексы и ПБУ");

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (81 модуль) БСС ВИП");
        oss_247_bss_test("Все кодексы и ПБУ");

    }

    private void oss_247_bss_test(String rubricatorName) {
        loginBss()
                .openDocumentByModuleIdAndDocId(BSS_DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkRubricatorButtonIsPresent(rubricatorName)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkTableOfContentsButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}
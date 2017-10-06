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
public class OSS_246_DisplayDocument97_BSS extends AbstractDomainTest {

    private static final String BSS_DOCUMENT_URL = "#/document/97/260323";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-246", testCaseVersion = "2")
    public void oss_246_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (97 модуль) БСС КУ");
        oss_246_bss_test("Все кодексы и ПБУ");

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (97 модуль) БСС БУ");
        oss_246_bss_test("Все кодексы");

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется  Общее отображение документов (97 модуль) БСС УСН");
        oss_246_bss_test("Все кодексы и ПБУ");

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (97 модуль) БСС ВИП");
        oss_246_bss_test("Все кодексы и ПБУ");
    }

    private void oss_246_bss_test(String rubricatorButtonName) {
        loginBss()
                .openDocumentByModuleIdAndDocId(BSS_DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkRubricatorButtonIsPresent(rubricatorButtonName)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}
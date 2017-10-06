package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 12/05/16.
 */
public class OSS_643_DisplayDocument96_BSS extends AbstractDomainTest {

    private static final String DOCUMENT_URL = "#/document/96/420212167";

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-643", testCaseVersion = "2")
    public void oss_643_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (96 модуль) БСС КУ");
        oss_643_bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (96 модуль) БСС БУ");
        oss_643_bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется  Общее отображение документов (96 модуль) БСС УСН");
        oss_643_bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (96 модуль) БСС ВИП");
        oss_643_bss_test();
    }

    private void oss_643_bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkHelpWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}

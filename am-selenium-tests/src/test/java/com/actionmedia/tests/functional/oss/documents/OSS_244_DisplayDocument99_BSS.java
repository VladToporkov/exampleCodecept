package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_244_DisplayDocument99_BSS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-244", testCaseVersion = "2")
    public void oss_244_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) БСС КУ");
        oss_244_bss_test("#/document/99/901765862/actual", "Все кодексы и ПБУ");

        //BSS BU
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (99 модуль) БСС БУ");
        oss_244_bss_test("#/document/99/901714433/actual", "Все кодексы");

        //BSS USN
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется  Общее отображение документов (99 модуль) БСС УСН");
        oss_244_bss_test("#/document/99/901765862/actual", "Все кодексы и ПБУ");

        //BSS VIP
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (99 модуль) БСС ВИП");
        oss_244_bss_test("#/document/99/901765862/actual", "Все кодексы и ПБУ");
    }

    private void oss_244_bss_test(String documentId, String buttonName) {
        loginBss()
                .openDocumentByModuleIdAndDocId(documentId)
                .checkDocumentIsOpened()
                .checkExtendedSearchButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkHelpWidgetIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkRevisionHistoryIsPresent()
                .checkMoreOnTheTopicIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkSendButtonIsPresentForKodeks()
                .checkSoderIsPresent()
                .checkBacklinksArePresent()
                .checkCommentsArePresent()

                .checkRubricatorButtonIsPresent(buttonName)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}

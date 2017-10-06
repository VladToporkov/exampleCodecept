package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1668_DisplayDocuments99_KSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1668", testCaseVersion = "2")
    public void oss_1668_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) КСС КУ");
        oss_1668_kss_test("#/document/99/901807664/actual");

        //KSS BU
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется  Общее отображение документов (99 модуль) КСС БУ");
        oss_1668_kss_test("#/document/99/901807664/actual");

        //KSS VIP
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (99 модуль) КСС ВИП");
        oss_1668_kss_test("#/document/99/901807664/actual");
    }

    private void oss_1668_kss_test(String documentId) {
        loginKss()
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

                .checkRubricatorButtonIsPresent("Все кодексы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}

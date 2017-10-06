package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1670_DisplayDocuments99_FSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1670", testCaseVersion = "2")
    public void oss_1670_test() {
        //fss
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ФСС КУ");
        oss_1670_fss_test("#/document/99/901807667/actual");
    }

    private void oss_1670_fss_test(String documentId) {
        loginFss()
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

                .checkRubricatorButtonIsPresent("Все кодексы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}

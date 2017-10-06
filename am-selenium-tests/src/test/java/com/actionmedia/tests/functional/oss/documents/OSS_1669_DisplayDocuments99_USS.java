package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1669_DisplayDocuments99_USS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1669", testCaseVersion = "2")
    public void oss_1669_test() {
        //uss
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ЮСС КУ");
        oss_1669_uss_test("#/document/99/9027690/actual");

        //uss VIP
        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется  Общее отображение документов (99 модуль) ЮСС ВИП");
        oss_1669_uss_test("#/document/99/9027690/actual");
    }

    private void oss_1669_uss_test(String documentId) {
        loginUss()
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
                .checkCommentsRubricatorButtonIsPresent()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1674_DisplayDocuments99_EHS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1674", testCaseVersion = "2")
    public void oss_1674_test() {
        //ehs
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ОТ КУ");
        oss_1674_ehs_test("#/document/99/902389617/actual");

        //ehs VIP
        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (99 модуль) ОТ ВИП");
        oss_1674_ehs_test("#/document/99/902389617/actual");
    }

    private void oss_1674_ehs_test(String documentId) {
        loginOT()
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

                .checkRubricatorButtonIsPresent("Законы и правила")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .logout();
    }

}

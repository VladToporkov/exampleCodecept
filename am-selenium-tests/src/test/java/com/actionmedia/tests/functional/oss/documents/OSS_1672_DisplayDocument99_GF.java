package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 10/05/16.
 */
public class OSS_1672_DisplayDocument99_GF extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1672", testCaseVersion = "2")
    public void oss_1672_test() {
        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется  Общее отображение документов (99 модуль) ГФ БУ");
        oss_1672_gf_test("#/document/99/901714433/actual");
    }

    private void oss_1672_gf_test(String documentId) {
        loginGF()
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

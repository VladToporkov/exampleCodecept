package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1722_RevisionHistory_FSS extends AbstractDomainTest {

    private static final String FSS_DOCUMENT_URL = "#/document/99/9027690";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1722", testCaseVersion = "2")
    public void oss_1722_test() {
        //fss
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется История изменений (Правовая база) ФСС КУ");
        oss_1722_fss_test();
    }

    private void oss_1722_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(FSS_DOCUMENT_URL)
                .checkDocumentIsOpened()
                .checkRevisionHistoryIsPresent()

                .clickOnRevisionHistoryLink()
                .checkRevisionHistoryBlockIsOpened()
                .checkRevisionHistoryTitleSpeciallyActionsIsPresent()
                .checkRevisionHistoryTitleContainsInDocumentIsPresent()

                .clickOnRandomDocumentFromRevisionHistoryList()
                .checkDocumentIsOpened()

                .returnToBack()

                .clickOnRandomDocumentFromRevisionHistoryList()
                .checkDocumentIsOpened()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1723_RevisionHistory_EHS extends AbstractDomainTest {

    private static final String USS_DOCUMENT_URL = "#/document/99/9027690";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1723", testCaseVersion = "2")
    public void oss_1723_test() {
        //ehs
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется История изменений (Правовая база) ОТ КУ");
        oss_1723_ehs_test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется История изменений (Правовая база) ОТ БАЗ");
        oss_1723_ehs_test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История изменений (Правовая база) ОТ ВИП");
        oss_1723_ehs_test();
    }

    private void oss_1723_ehs_test() {
        loginOT()
                .openDocumentByModuleIdAndDocId(USS_DOCUMENT_URL)
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

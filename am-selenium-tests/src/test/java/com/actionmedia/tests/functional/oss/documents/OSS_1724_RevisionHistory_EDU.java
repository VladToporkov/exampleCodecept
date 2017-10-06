package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1724_RevisionHistory_EDU extends AbstractDomainTest {

    private static final String EDU_DOCUMENT_URL = "#/document/99/9027690";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1724", testCaseVersion = "2")
    public void oss_1724_test() {
        //edu
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется История изменений (Правовая база) ОБР КУ");
        oss_1724_edu_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется История изменений (Правовая база) ОБР БАЗ");
        oss_1724_edu_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История изменений (Правовая база) ОБР ВИП");
        oss_1724_edu_test();
    }

    private void oss_1724_edu_test() {
        loginEdu()
                .openDocumentByModuleIdAndDocId(EDU_DOCUMENT_URL)
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

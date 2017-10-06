package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/05/16.
 */
public class OSS_1720_RevisionHistory_KSS extends AbstractDomainTest {

    private static final String КSS_DOCUMENT_URL = "#/document/99/9027690";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1720", testCaseVersion = "2")
    public void oss_1720_test() {
        //kss
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется История изменений (Правовая база) КСС КУ");
        oss_1720_kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется История изменений (Правовая база) КСС БУ");
        oss_1720_kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История изменений (Правовая база) КСС ВИП");
        oss_1720_kss_test();
    }

    private void oss_1720_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(КSS_DOCUMENT_URL)
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
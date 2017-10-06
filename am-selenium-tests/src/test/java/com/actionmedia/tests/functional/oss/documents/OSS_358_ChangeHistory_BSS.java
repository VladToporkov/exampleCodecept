package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 19/05/16.
 */
public class OSS_358_ChangeHistory_BSS extends AbstractDomainTest {

    private static final String BSS_DOCUMENT_URL = "#/document/99/9027690";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-358", testCaseVersion = "2")
    public void oss_358_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется История изменений (Правовая база) БСС КУ");
        oss_358_bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется История изменений (Правовая база) БСС БУ");
        oss_358_bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется История изменений (Правовая база) БСС УСН");
        oss_358_bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История изменений (Правовая база) БСС ВИП");
        oss_358_bss_test();
    }

    private void oss_358_bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(BSS_DOCUMENT_URL)
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

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/03/16.
 */
public class OSS_1548_GlavbukhAdvises extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/11/14985/ogs0";
    private final static String DOC_PART_URL_2 = "#/document/12/75673/ogs0";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1548", testCaseVersion = "1")
    public void oss_1548_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение документов 113 модуль БСС КУ");
        bssDocument_113();

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение документов 113 модуль МЦФЭР ГФ");
        gfDocument_113();
    }

    private void bssDocument_113() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkIncutAdviceContainsText("Главбух советует:")

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_2)
                .checkIncutAdviceContainsText("Главбух советует:")

                .logout();
    }

    private void gfDocument_113() {
        loginGF()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkIncutAdviceContainsText("Совет:")

                .openDocumentByModuleIdAndDocId(DOC_PART_URL_2)
                .checkIncutAdviceContainsText("Совет:")

                .logout();
    }
}

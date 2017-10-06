package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 15/02/16.
 */
public class OSS_1544_DisplayDocumentNewElements172_173 extends AbstractDomainTest {

    private final static String DOC_PART_URL = "#/document/173/2148";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1544", testCaseVersion = "1")
    public void oss_1544_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Новые элементы 172 и 173 модуль ФСС КУ");
        fssDocument_173();
    }

    private void fssDocument_173() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOC_PART_URL)
                .checkCommonViewDocument_173_2148()

                .logout();
    }
}

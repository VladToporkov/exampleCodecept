package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 19.05.2015
 * Time: 15:26
 */
public class OSS_566_CommonViewOf191Module extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-566", testCaseVersion = "1")
    public void oss_566_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("OSS-566::Общее отображение документов (191 модуль) ФСС КУ");
        fss_566_test();
    }

    private void fss_566_test() {
        loginFss()
                .openDocumentByUrl(getDocumentUrlByKey("fss.191.module.594"))
                .checkCommonView191()
                .logout();
    }
}

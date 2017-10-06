package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 13.05.2015
 * Time: 13:10
 */
public class OSS_565_CommonViewOf174Module extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-565", testCaseVersion = "1")
    public void oss_565_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("OSS-563:Комментарии (Формы) ФСС КУ");
        fss_565_test();
    }

    private void fss_565_test() {
        loginFss()
                .openDocumentByUrl(getDocumentUrlByKey("fss.174.module.467"))
                .checkCommonView174()
                .logout();
    }
}

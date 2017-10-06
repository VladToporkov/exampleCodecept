package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 12:10
 */
public class KSS_90_VerifyInfoBarWidgetInDocument extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-90", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_90_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("/#/document/130/51582")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetIsPresent()
                .checkInfoBarWidgetWork()
                .logout();
    }
}

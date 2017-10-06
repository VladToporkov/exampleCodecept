package com.actionmedia.tests.functional.uss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 11:45
 */
public class USS_113_VerifyFormDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
//    @TestLink(testCaseId = "USS-113", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_113_test() {
        loginUss()
                .navigateToFormsPage()
                .openDocumentByUrl(getDocumentUrlByKey("uss.140.module"))
                .checkDownloadButtonIsPresent()
                .checkFormsPreview()
                .logout();
    }
}

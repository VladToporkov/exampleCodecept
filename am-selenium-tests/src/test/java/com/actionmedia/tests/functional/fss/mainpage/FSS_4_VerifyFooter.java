package com.actionmedia.tests.functional.fss.mainpage;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 03.12.13
 * Time: 11:25
 */
public class FSS_4_VerifyFooter extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-4", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_4_test() {
        loginFss()
                .navigateToMainPage()
                .checkFooterIsPresent()
                .checkFooterInfo()
                .checkLinksFromFooter();
    }
}

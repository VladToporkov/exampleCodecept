package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 02.12.13
 * Time: 14:35
 */
public class KSS_238_VerifyBanner extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-238", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_238_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkBannerDefaultState()
                .logout();
    }
}

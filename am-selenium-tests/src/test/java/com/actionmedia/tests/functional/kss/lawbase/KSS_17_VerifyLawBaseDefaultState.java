package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 16:32
 */
public class KSS_17_VerifyLawBaseDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-17", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_17_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkDefaultStateLawBasePage()
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 12:09
 */
public class USS_43_VerifyLawBasePage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-43", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_43_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkDefaultStateLawBasePage()
                .logout();
    }
}

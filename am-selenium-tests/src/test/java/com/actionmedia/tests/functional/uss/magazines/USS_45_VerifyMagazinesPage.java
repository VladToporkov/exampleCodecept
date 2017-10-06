package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 14:12
 */
public class USS_45_VerifyMagazinesPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-45", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_45_test() {
        loginUss()
                .navigateToMagazinesPage()
                .checkDefaultStateMagazinesPage()
                .logout();
    }
}

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
 * Time: 14:39
 */
public class USS_46_VerifyShelves extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-46", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_46_test() {
        loginUss()
                .navigateToMagazinesPage()
                .checkDefaultStateMagazinesPage()
                .checkMagazinesLink()
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:29
 */
public class USS_49_VerifyWizardsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-49", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_49_test() {
        loginUss()
                .navigateToServicesPage()
                .checkDefaultStateServicesPage()
                .logout();
    }
}

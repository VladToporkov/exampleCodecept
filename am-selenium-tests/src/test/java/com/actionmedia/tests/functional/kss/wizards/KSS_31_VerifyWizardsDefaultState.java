package com.actionmedia.tests.functional.kss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.09.13
 * Time: 12:01
 */
public class KSS_31_VerifyWizardsDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-31", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_31_test() {
        loginKss()
                .navigateToWizardsPage()
                .checkDefaultStateWizardsPage()
                .logout();
    }
}
package com.actionmedia.tests.functional.uss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:42
 */
public class USS_19_VerifyPopularBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-19", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_19_test() {
        loginUss()
                .navigateToServicesPage()
                .checkPopularBlockIsPresent()
                .checkPopularBlockAreNotEmpty()
                .checkPopularWizardsLinks()
                .logout();
    }
}

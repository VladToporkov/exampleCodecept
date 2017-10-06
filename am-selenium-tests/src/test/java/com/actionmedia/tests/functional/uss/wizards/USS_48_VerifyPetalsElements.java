package com.actionmedia.tests.functional.uss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:46
 */
public class USS_48_VerifyPetalsElements extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "USS-48", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_48_test() {
        loginUss()
                .navigateToServicesPage()
                .checkPetalBlocksIsPresent()
                .checkLinksForPetalBlock()
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.10.13
 * Time: 18:29
 */
public class USS_6_VerifyPopularBlock extends AbstractDomainTest {

    //TODO Refactored to new implementation
    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "USS-6", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_6_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkPopularBlockIsDisplayed()
                .checkPopularBlockIsNotEmpty()
                .checkLinksInPopularBlock()
                .logout();
    }
}

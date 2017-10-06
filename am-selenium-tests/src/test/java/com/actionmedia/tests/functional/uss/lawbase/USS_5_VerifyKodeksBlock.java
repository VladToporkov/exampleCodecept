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
 * Time: 18:09
 */
public class USS_5_VerifyKodeksBlock extends AbstractDomainTest {

    //TODO Refactored to new implementation
    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "USS-5", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_5_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkKodexBlockIsDisplayed()
                .checkKodexBlockIsNotEmpty()
                .checkKodexOrder()
                .checkBlanksOrder()
                .checkLinksForKodexBlock()
                .logout();
    }
}

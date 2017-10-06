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
 * Time: 18:34
 */
public class USS_4_VerifyNewsBlock extends AbstractDomainTest {

    //TODO Refactored to new implementation
    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "USS-4", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_4_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkNewsBlockLinks()
                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()
                .logout();
    }
}

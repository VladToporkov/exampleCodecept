package com.actionmedia.tests.functional.uss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 12:24
 */
public class USS_11_VerifyPopularBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-11", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_11_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkPopularBlockIsDisplayed()
                .checkPopularBlockAreNotEmpty()
                .checkPopularFormLinks()
                .logout();
    }
}

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
 * Time: 11:54
 */
public class USS_12_VerifyNewsBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-12", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_12_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkNewsBlockLinks()
                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()
                .logout();
    }
}

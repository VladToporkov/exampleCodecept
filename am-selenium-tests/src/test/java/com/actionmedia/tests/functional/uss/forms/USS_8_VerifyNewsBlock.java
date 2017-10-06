package com.actionmedia.tests.functional.uss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 10:04
 */
public class USS_8_VerifyNewsBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-8", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_8_test() {
        loginUss()
                .navigateToFormsPage()
                .checkNewsFormLinks()
                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()
                .logout();
    }
}


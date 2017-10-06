package com.actionmedia.tests.functional.uss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 9:58
 */
public class USS_42_VerifyFormsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-42", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_42_test() {
        loginUss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }
}

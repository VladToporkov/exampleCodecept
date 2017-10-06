package com.actionmedia.tests.functional.kss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 19.09.13
 * Time: 16:23
 */
public class KSS_20_VerifyFormsDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-20", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_20_test() {
        loginKss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 11:38
 */
public class KSS_21_VerifyFormsNewsBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-21", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_21_test() {
        loginKss()
                .navigateToFormsPage()
                .checkNewFormLinks()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()
                .logout();
    }
}

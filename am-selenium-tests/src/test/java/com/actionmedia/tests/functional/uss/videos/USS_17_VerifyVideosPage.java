package com.actionmedia.tests.functional.uss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:11
 */
public class USS_17_VerifyVideosPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-17", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_17_test() {
        loginUss()
                .navigateToVideoPage()
                .checkDefaultStateVideoPage()
                .logout();
    }
}

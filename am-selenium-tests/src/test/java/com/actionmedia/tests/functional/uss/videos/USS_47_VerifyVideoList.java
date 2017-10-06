package com.actionmedia.tests.functional.uss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:15
 */
public class USS_47_VerifyVideoList extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-47", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_47_test() {
        loginUss()
                .navigateToVideoPage()
                .checkLastVideo()
                .checkVideoLinks()
                .logout();
    }
}

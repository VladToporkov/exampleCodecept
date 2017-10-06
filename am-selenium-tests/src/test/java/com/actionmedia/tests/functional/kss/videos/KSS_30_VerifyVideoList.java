package com.actionmedia.tests.functional.kss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 23.09.13
 * Time: 12:01
 */
public class KSS_30_VerifyVideoList extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-30", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_30_test() {
        loginKss()
                .navigateToVideoPage()
                .checkLastVideo()
                .checkVideoLinks()
                .logout();
    }
}

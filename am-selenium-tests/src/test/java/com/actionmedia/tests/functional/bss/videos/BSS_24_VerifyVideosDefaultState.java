package com.actionmedia.tests.functional.bss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 16:02
 */
public class BSS_24_VerifyVideosDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-24", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_24_test() {
        loginBss()
                .navigateToVideoPage()
                .checkDefaultStateVideoPage()
                .checkVideoBlocksContent()
                .checkVideoCounter()

                .checkPlayerLinkForLastVideo()
                .checkDefaultStateVideoPage()

                .checkLinksInVideoPlayer()
                .checkDefaultStateVideoPage()

                .checkLinksInVideoDescribe()
                .checkDefaultStateVideoPage()
                .logout();
    }
}

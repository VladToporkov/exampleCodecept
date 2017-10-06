package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 25.09.13
 * Time: 16:21
 */
public class KSS_38_VerifyVideosBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-38", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_38_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkVideosBlockIsPresent()
                .checkVideoPreviewIsPresent()
                .checkBackgroundForVideo()
                .checkTitleAndLengthVideoIsPresent()

                .checkVideoLink()
                .navigateToAnswersPage()
                .checkVideosLinkIsOpenedVideosPage()
                .logout();
    }
}

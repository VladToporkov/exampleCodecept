package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 12:21
 */
public class USS_83_VerifyVideosBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-83", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_83_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkVideosBlockIsPresent()

                .checkVideosLinkIsOpenedVideosPage()
                .logout();
    }
}

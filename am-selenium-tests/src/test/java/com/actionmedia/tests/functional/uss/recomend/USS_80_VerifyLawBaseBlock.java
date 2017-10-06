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
 * Time: 11:22
 */
public class USS_80_VerifyLawBaseBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-80", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_80_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkLawBaseBlockIsPresent()
                .checkLawBaseBlockIsNotEmpty()

                .checkLinksInLawBaseBlock()
                .navigateToRecomendPage()
                .checkLawBaseLinkIsOpenedLawBasePage()
                .logout();
    }
}

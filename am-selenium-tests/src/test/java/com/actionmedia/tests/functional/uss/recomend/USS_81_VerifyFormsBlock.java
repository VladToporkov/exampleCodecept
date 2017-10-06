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
 * Time: 11:45
 */
public class USS_81_VerifyFormsBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-81", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_81_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkFormsBlockIsPresent()
                .checkFormsBlockIsNotEmpty()

                .checkFormsLinkIsOpenedFormsPage()
                .logout();
    }
}

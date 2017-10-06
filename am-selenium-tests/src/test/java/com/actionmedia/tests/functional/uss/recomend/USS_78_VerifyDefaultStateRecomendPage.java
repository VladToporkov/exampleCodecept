package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 15:53
 */
public class USS_78_VerifyDefaultStateRecomendPage extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "USS-78", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_78_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkDefaultStateRecomendPage()
                .logout();
    }
}

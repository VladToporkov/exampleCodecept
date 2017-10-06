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
 * Time: 14:16
 */
public class USS_87_VerifyNewsBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-87", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_87_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkNewsBlockIsPresent()
                .checkNewsBlockIsNotEmpty()
                .checkLinksInNewsBlock()
                .checkNewsPageLinkIsOpenedNewsPage()
                .logout();
    }
}

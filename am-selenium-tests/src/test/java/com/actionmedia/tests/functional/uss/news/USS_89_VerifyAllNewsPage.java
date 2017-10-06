package com.actionmedia.tests.functional.uss.news;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 14:57
 */
public class USS_89_VerifyAllNewsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-89", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_89_test() {
        loginUss()
                .navigateToRecomendPage()
                .clickNewsLink()
                .checkNewsIsPresent()
                .checkLinksOnNewsPage()
                .checkNewsScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .logout();
    }
}

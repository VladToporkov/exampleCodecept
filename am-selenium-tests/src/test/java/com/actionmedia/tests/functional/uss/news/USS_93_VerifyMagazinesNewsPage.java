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
 * Time: 15:27
 */
public class USS_93_VerifyMagazinesNewsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-93", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_93_test() {
        loginUss()
                .navigateToRecomendPage()
                .clickNewsLink()
                .clickMagazinesSection()
                .checkNewsIsPresent()
                .checkLinksOnNewsPage()
                .checkNewsScrolling()
                .checkDateAreSortedDescending()
                .checkNewsBlockAreNotRepeated()
                .checkNewsAreNotEmpty()
                .logout();
    }
}

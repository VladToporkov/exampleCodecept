package com.actionmedia.tests.functional.kss.news;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 14:07
 */
public class KSS_146_VerifyMagazinesNewsPage extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-146", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_146_test() {
        loginKss()
                .navigateToAnswersPage()
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

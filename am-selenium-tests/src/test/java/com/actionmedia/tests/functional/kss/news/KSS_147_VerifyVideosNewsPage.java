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
public class KSS_147_VerifyVideosNewsPage extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-147", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_147_test() {
        loginKss()
                .navigateToAnswersPage()
                .clickNewsLink()
                .clickVideosSection()
                .checkNewsIsPresent()
                .checkLinksOnNewsPage()
                .checkDateAreSortedDescending()
                .checkNewsBlockAreNotRepeated()
                .checkNewsAreNotEmpty()
                .logout();
    }
}

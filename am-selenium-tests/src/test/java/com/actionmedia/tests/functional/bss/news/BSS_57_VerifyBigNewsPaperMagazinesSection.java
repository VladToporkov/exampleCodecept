package com.actionmedia.tests.functional.bss.news;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 10:47
 */
public class BSS_57_VerifyBigNewsPaperMagazinesSection extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-57", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_57_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickNewsPaperHeaderLink()
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

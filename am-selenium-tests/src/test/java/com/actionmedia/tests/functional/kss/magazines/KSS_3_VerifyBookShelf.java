package com.actionmedia.tests.functional.kss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 02.12.13
 * Time: 16:01
 */
public class KSS_3_VerifyBookShelf extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-3", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_3_test() {
        loginKss()
                .navigateToMagazinesPage()
                .checkBooksBlockIsPresent()
//                .checkScrollOnBookShelf()
                .checkItemsOnBookShelfAreNotRepeated()
                .checkImageLoadedForBookShelf()
                .checkLinkOnBookShelf()
                .logout();
    }
}

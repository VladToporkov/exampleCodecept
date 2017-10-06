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
 * Time: 15:01
 */
public class KSS_2_VerifyShelfOfNewItems extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-2", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_2_test() {
        loginKss()
                .navigateToMagazinesPage()
                .checkNewBlockIsPresent()
//                .checkScrollOnNewShelf()
                .checkItemsOnNewShelfAreNotRepeated()
                .checkImageLoadedForNewShelf()
                .checkLinkOnNewsShelf()
                .logout();
    }
}

package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 13:54
 */
public class BSS_121_VerifyMagazinesDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-121", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_121_test() {
        loginBss()
                .navigateToMagazinesPage()
                .checkDefaultStateMagazinesPage()

//                .checkScrollOnShelves()

                .checkLinksFromNewsBlock()

                .checkLinksFromBooksBlock()

                .checkLinksFromMagazinesBlock()

                .checkLinksFromMobileReadBlock()
                .logout();
    }
}

package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 9:33
 */
public class BSS_22_VerifyLawBaseDefaultState extends AbstractDomainTest {

    //TODO Refactored to new implementation
    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "BSS-22", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_22_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkDefaultStateLawBasePage()

                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsBlockAreNotRepeat()

                .checkLinksFromKodeksBlock()
                .checkDefaultStateLawBasePage()
                .checkLinksFromPopularBlock()
                .checkDefaultStateLawBasePage()
                .checkLinksFromNewsBlock()
                .checkDefaultStateLawBasePage()
                .logout();
    }
}

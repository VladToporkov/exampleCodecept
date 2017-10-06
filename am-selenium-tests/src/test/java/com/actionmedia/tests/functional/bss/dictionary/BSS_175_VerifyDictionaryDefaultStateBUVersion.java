package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.12.13
 * Time: 11:21
 */
public class BSS_175_VerifyDictionaryDefaultStateBUVersion extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-175", testCaseVersion = "2")
    @LoginAs(key = "bss.user.budget")
    @Version(section = "budget")
    public void bss_175_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()

                .checkElementsOnDictionaryBoardBUVersion()
                .checkElementsOnPopularBlockBUVersion()

                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()

                .checkLinksInStickersBUVersion()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromPopularBlock()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromNewsBlock()
                .checkDefaultStateDictionaryPage()
                .logout();
    }
}

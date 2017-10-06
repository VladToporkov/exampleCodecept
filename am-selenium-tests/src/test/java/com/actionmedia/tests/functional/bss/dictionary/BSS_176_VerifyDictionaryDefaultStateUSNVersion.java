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
 * Time: 15:06
 */
public class BSS_176_VerifyDictionaryDefaultStateUSNVersion extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-176", testCaseVersion = "2")
    @LoginAs(key = "bss.user.usn")
    @Version(section = "usn")
    public void bss_176_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()

                .checkElementsOnDictionaryBoardUSNVersion()
                .checkElementsOnPopularBlock()

                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()

                .checkLinksInStickersUSNVersion()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromPopularBlock()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromNewsBlock()
                .checkDefaultStateDictionaryPage()
                .logout();
    }
}

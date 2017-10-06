package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 11:21
 */
public class BSS_26_VerifyDictionaryDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-26", testCaseVersion = "2")
    @LoginAs(key = "bss.user.commercial")
    public void bss_26_ku_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()

                .checkElementsOnDictionaryBoard()
                .checkElementsOnPopularBlock()

                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()

                .checkLinksInStickers()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromPopularBlock()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromNewsBlock()
                .checkDefaultStateDictionaryPage()
                .logout();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        loginBss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()

                .checkElementsOnDictionaryBoard()
                .checkElementsOnPopularBlock()

                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()

                .checkLinksInStickers()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromPopularBlock()
                .checkDefaultStateDictionaryPage()

                .checkLinksFromNewsBlock()
                .checkDefaultStateDictionaryPage()
                .logout();
    }
}

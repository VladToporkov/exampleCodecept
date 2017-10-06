package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 12.18.13
 * Time: 16:50
 */
public class BSS_14_VerifyDictionaryBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-14", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_14_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkDictionaryBlockIsPresent()

                .checkLinkFromDictionaryBlock()
                .clickDictionaryLink()
                .checkDefaultStateDictionaryPage()
                .logout();
    }
}

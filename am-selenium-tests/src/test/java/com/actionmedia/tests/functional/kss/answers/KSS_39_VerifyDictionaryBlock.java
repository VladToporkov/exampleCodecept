package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 25.09.13
 * Time: 18:01
 */
public class KSS_39_VerifyDictionaryBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-39", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_39_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkDictionaryBlockIsPresent()
                .checkDictionaryBlockIsNotEmpty()
                .checkCurrentDateInDictionaryBlockIsPresent()
                .checkCurrencyInDictionaryBlockIsPresent()
                .checkMrotInDictionaryBlockIsPresent()
                .checkTotalAmountDictionaryInDictionaryBlockIsPresent()
                .checkRubricatorLinksInDictionaryBlockArePresent()

                .checkLinksInDictionaryBlock()
                .navigateToAnswersPage()
                .checkLinkInDictionaryBlockIsOpenedDictionaryPage()
                .logout();
    }
}
package com.actionmedia.tests.functional.uss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 12:32
 */
public class USS_9_VerifyDictionaryBoard extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-9", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_9_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()
                .checkElementsOnDictionaryBoard()
                .checkDateOnCalendar()
                .checkStickersArePresent()
                .checkLinksInStickers()
                .logout();
    }
}

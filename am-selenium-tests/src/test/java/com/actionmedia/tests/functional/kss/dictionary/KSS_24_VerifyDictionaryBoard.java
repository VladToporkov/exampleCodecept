package com.actionmedia.tests.functional.kss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 16:32
 */
public class KSS_24_VerifyDictionaryBoard extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-24", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_24_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()
                .checkElementsOnDictionaryBoard()
                .checkDateOnCalendar()
                .checkStickersArePresent()
                .checkLinksInStickers()
                .logout();
    }
}

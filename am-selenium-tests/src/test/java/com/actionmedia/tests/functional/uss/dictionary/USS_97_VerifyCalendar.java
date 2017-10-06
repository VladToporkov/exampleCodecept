package com.actionmedia.tests.functional.uss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 06.12.13
 * Time: 16:23
 */
public class USS_97_VerifyCalendar extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-97", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_97_test() {
        loginUss()
                .navigateToDictionaryPage()
                .clickCalendarLink()
                .checkCalendarIsPresent()
                .checkCalendarElements()
                .checkCurrentDate()
                .logout();
    }
}

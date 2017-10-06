package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 24.04.2014
 * Time: 10:49
 */
public class BSS_27_VerifyCalendar extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "BSS-27", testCaseVersion = "3")
    @LoginAs(key = "bss.user.commercial")
    public void bss_27_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkCalendarWidgetIsPresent()
                .clickCalendarWidget()
                .checkCalendarPageDefaultState()

                .clickTaxFilterLinkInCalendar()
                .checkTaxFilterListIsPresent()

                .clickTaxFilterLinkInCalendar()
                .checkTaxFilterListIsNotPresent()

                .clickRandomActiveDayInCalendar()
                .checkTaskTableForActiveDayIsPresent()

                .clickNextMonthButton()
                .checkNextMonthPageIsOpened()

                .clickPrevMonthButton()
                .checkPrevMonthPageIsOpened()
                .checkTaskListOnCalendarPageIsPresent()
                .checkTaskTableForPrevMonthIsOpened()

                .clickPrevMonthButton()
                .checkPrevMonthPageIsOpened()
                .checkTaskListOnCalendarPageIsPresent()
                .checkTaskTableForPrevMonthIsOpened()

                .clickGetToCurrentDayLink()
                .checkCalendarPageDefaultState()
                .logout();
    }
}

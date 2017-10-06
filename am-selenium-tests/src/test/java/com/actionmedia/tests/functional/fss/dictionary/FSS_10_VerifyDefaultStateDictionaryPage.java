package com.actionmedia.tests.functional.fss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 12:22
 */
public class FSS_10_VerifyDefaultStateDictionaryPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-10", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_10_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()

                .checkFirstScreenInWidgetIsDisplayed()
                .clickSecondScreenInWidgets()
                .checkSecondScreenInWidgetIsDisplayed()
                .clickFirstScreenInWidgets()
                .checkFirstScreenInWidgetIsDisplayed()

                .checkLinksFromNewsBlock()
                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()

                .checkFiltersInRightPanel()

                .checkRandomLinksFromExpandedPopularBlock()
                .checkRandomLinksFromExpandedViewedBlock();
    }
}

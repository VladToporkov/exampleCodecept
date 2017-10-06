package com.actionmedia.tests.functional.fss.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 06.11.13
 * Time: 14:23
 */
public class FSS_5_VerifyDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-5", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_5_test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkDefaultStateSolutionsPage()

                .checkLinksFromNewsBlock()
                .checkNewsBlockScrolling()
                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()

                .checkFiltersInRightPanel()

                .checkRandomLinksFromExtendedPopularBlock()
                .checkRandomLinksFromExtendedViewedBlock();
    }
}

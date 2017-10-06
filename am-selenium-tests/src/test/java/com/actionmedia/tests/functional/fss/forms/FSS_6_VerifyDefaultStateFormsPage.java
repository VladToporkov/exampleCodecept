package com.actionmedia.tests.functional.fss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 08.11.13
 * Time: 16:18
 */
public class FSS_6_VerifyDefaultStateFormsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-6", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_6_test() {
        loginFss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()

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

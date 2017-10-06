package com.actionmedia.tests.functional.fss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 11:58
 */
public class FSS_7_VerifyDefaultStateLawBasePage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-7", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_7_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkDefaultStateLawBasePage()

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

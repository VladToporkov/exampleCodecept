package com.actionmedia.tests.functional.fss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 03.12.13
 * Time: 11:59
 */
public class FSS_167_VerifyRightPanel extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-167", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_167_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkCollapsedRightPanel()

                .checkRandomLinksFromCollapsedPopularTab()
                .checkRandomLinksFromCollapsedViewedTab()

                .checkExpandedRightPanel()
                .checkFiltersInRightPanel()

                .checkRandomLinksFromExtendedPopularBlock()
                .checkRandomLinksFromExtendedViewedBlock();
    }
}

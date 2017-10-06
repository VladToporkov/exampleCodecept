package com.actionmedia.tests.functional.fss.magazines;

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
public class FSS_166_VerifyRightPanel extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-166", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_166_test() {
        loginFss()
                .navigateToMagazinesPage()
                .checkCollapsedRightPanel()

                .checkRandomLinksFromCollapsedPopularTab()
                .checkRandomLinksFromCollapsedViewedTab()

                .checkExpandedRightPanel()
                .checkFiltersInRightPanel()

                .checkRandomLinksFromExpandedPopularBlock()
                .checkRandomLinksFromExpandedViewedBlock();
    }
}

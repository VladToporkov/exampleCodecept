package com.actionmedia.tests.functional.fss.mainpage;

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
public class FSS_2_VerifyMainPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-2", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_2_test() {
        loginFss()
                .navigateToMainPage()
                .checkDefaultStateMainPage()

                .checkSolutionsLinks()
                .checkBreadcrumbLinks()

                .checkSolutionsLinkIsOpenedSolutionsPage()
                .checkFormsLinkIsOpenedFormsPage()
                .checkMagazinesLinkIsOpenedMagazinesPage()
                .checkLawBaseLinkIsOpenedLawBasePage()
                .checkVideoLinkIsOpenedVideoPage()
                .checkDictionaryLinkIsOpenedDictionaryPage()

                .checkFiltersInRightPanel()
                .checkMagazinesContent()
                .checkRandomLinksFromPopularBlock()
                .checkRandomLinksFromViewedBlock()
                .checkRandomLinksFromNewInWorkBlock();
    }
}

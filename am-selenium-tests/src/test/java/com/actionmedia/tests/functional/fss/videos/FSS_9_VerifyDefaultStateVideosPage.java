package com.actionmedia.tests.functional.fss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 15:53
 */
public class FSS_9_VerifyDefaultStateVideosPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-9", testCaseVersion = "1")
    @LoginAs(key = "fss.user.panel")
    public void fss_9_test() {
        loginFss()
                .navigateToVideoPage()
                .checkDefaultStateVideosPage()

                .checkPresentationLinkIsPresent()
                .checkThemesIsPresent()
                .checkHideButtonIsPresent()
                .checkNotAllThemesIsDisplayed()
                .clickHideButton()
                .checkAllThemesIsDisplayed()
                .clickHideButton()
                .checkNotAllThemesIsDisplayed()

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

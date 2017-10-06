package com.actionmedia.tests.functional.fss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 05.12.13
 * Time: 14:13
 */
public class FSS_171_VerifyRightPanelInVideo extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-171", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_171_test() {
        loginFss()
                .navigateToVideoPage()
                .clickRandomSectionInRubricator()
                .clickRandomVideoLink()

                .checkCollapsedRightPanelInVideo()

                .checkLinksFromCollapsedSoderTabInMagazine()
                .checkRandomLinksFromCollapsedWithThisVideoTab()

                .checkExpandedRightPanelInVideo()

                .checkLinksFromExpandedSoderTabInMagazine()
                .checkRandomLinksFromExpandedWithThisVideoTab();
    }
}

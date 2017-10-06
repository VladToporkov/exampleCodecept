package com.actionmedia.tests.functional.fss.solutions;

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
public class FSS_163_VerifyRightPanelInSolution extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-163", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_163_test() {
        loginFss()
                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromRubricator()

                .checkCollapsedRightPanelInSolution()

                .checkLinksFromCollapsedSoderTab()
                .checkRandomLinksFromCollapsedWithThisSolutionTab()

                .checkExpandedRightPanel()

                .checkLinksFromExpandedSoderTab()
                .checkRandomLinksFromExpandedWithThisSolutionTab();
    }
}

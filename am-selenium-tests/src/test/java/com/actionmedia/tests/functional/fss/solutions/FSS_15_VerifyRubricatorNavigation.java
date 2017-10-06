package com.actionmedia.tests.functional.fss.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.05.2014
 * Time: 12:27
 */
public class FSS_15_VerifyRubricatorNavigation extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-15", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_15_test() {
        loginFss()
                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .checkRubricatorIsOpened()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed()

                .clickFirstSectionInRubricator()
                .clickFirstAnotherSolutions()
                .checkAnotherSolutionsContentIsPresent()
                .clickFirstAnotherSolutions()

                .clickFirstDifferentApproach()
                .checkDiffApproachContentIsPresent()
                .clickFirstDifferentApproach()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}

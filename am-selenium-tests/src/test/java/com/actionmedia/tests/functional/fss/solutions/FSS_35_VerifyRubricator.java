package com.actionmedia.tests.functional.fss.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 13.11.13
 * Time: 17:27
 */
public class FSS_35_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-35", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_35_test() {
        loginFss()
                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed()

                .clickRubricatorButtonFss()
                .clickFirstAnotherSolutions()
                .checkAnotherSolutionsContentIsPresent()

                .clickFirstDifferentApproach()
                .checkDiffApproachContentIsPresent()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}

package com.actionmedia.tests.functional.fss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 14:10
 */
public class FSS_36_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-36", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_36_test() {
        loginFss()
                .navigateToFormsPage()
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
                .checkRubricatorIsClosed();
    }
}

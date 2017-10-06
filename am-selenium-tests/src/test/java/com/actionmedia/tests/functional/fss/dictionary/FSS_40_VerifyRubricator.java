package com.actionmedia.tests.functional.fss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 14:15
 */
public class FSS_40_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-40", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_40_test() {
        loginFss()
                .navigateToDictionaryPage()
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

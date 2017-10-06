package com.actionmedia.tests.functional.fss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 14:20
 */
public class FSS_37_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-37", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_37_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromKodeksRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedKodeksItemIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromKodeksRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedKodeksItemIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .clickRandomItemFromKodeksRubricator()
                .clickRubricatorButtonFss()
                .checkOpenedKodeksItemIsHighlighted()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}

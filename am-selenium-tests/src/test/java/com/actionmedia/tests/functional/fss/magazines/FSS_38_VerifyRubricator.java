package com.actionmedia.tests.functional.fss.magazines;

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
public class FSS_38_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-38", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_38_test() {
        loginFss()
                .navigateToMagazinesPage()
                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .clickRandomLinkFromSoder()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .clickRandomLinkFromSoder()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()

                .clickRandomSectionInRubricator()
                .checkFirstItemIsSelected()
                .clickRandomSubSectionsInRubricator()
                .checkOpenedSubSectionsIsHighlighted()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .clickRandomLinkFromSoder()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}

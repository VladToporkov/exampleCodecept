package com.actionmedia.tests.functional.fss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 10:32
 */
public class FSS_64_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-64", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_64_test() {
        loginFss()
                .navigateToMagazinesPage()
                .clickRandomMagazine()
                .clickRubricatorButtonFss()
                .checkRubricatorIsOpened()

                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .checkContentIsPresent()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .checkContentIsPresent()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .checkContentIsPresent()

                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .openRandomSoderLink()
                .clickRandomLinkFromSoder()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted()
                .clickRandomLinkFromSoder()
                .clickRubricatorButtonFss()
                .checkOpenedItemIsHighlighted();
    }
}

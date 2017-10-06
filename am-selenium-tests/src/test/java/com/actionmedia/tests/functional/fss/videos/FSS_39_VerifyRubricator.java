package com.actionmedia.tests.functional.fss.videos;

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
public class FSS_39_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-39", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_39_test() {
        loginFss()
                .navigateToVideoPage()
                .clickRandomSectionInRubricator()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()
                .clickRandomVideoLink()
                .clickRubricatorButtonFss()
                .checkOpenedVideoIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()
                .clickRandomVideoLink()
                .clickRubricatorButtonFss()
                .checkOpenedVideoIsHighlighted()

                .clickRandomSectionInRubricator()
                .checkContentIsPresent()
                .openRandomSoderLink()
                .checkSoderContentIsPresent()
                .closeOpenedSoderLink()
                .checkSoderContentIsNotPresent()
                .clickRandomVideoLink()
                .clickRubricatorButtonFss()
                .checkOpenedVideoIsHighlighted()

                .clickCloseRubricatorButton()
                .checkRubricatorIsClosed();
    }
}

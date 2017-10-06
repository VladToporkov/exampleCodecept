package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 10:37
 */
public class USS_77_VerifyYellowPlate extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-77", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_77_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkYellowPlateIsPresent()
                .checkYellowPlateIsNotEmpty()
                .checkSearchBoxIsPresentOnRecomendPage()

                .checkLinksOnYellowPlate()
                .checkRubricatorLinksFromYellowPlate()
                .logout();
    }
}

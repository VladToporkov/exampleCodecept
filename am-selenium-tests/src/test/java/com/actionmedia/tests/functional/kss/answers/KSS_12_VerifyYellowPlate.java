package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 25.09.13
 * Time: 11:10
 */
public class KSS_12_VerifyYellowPlate extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-12", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_12_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkYellowPlateIsPresent()
                .checkYellowPlateIsNotEmpty()
                .checkSearchBoxIsPresentOnAnswersPage()
                .checkMoreAnswersOnYellowPlate()

                .checkLinksOnYellowPlate()
                .checkRubricatorLinksOnYellowPlate()
                .logout();
    }
}

package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 11.04.2014
 * Time: 11:34
 */
public class BSS_9_VerifyRubricatorLinksFromYellowPlateUSN extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-9", testCaseVersion = "2")
    @LoginAs(key = "bss.user.usn")
    @Version(section = "usn")
    public void bss_9_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkLinkFromYellowPlate()
                .checkRubricatorLinksFromYellowPlate()
                .logout();
    }
}

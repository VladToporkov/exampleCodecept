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
public class BSS_194_VerifyRubricatorLinksFromYellowPlateVIP extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-194", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_194_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkLinkFromYellowPlate()
                .checkRubricatorLinksFromYellowPlate()
                .logout();
    }
}

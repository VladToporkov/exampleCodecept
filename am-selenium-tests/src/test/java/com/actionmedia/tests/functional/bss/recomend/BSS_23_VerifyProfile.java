package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 24.10.13
 * Time: 11:32
 */
public class BSS_23_VerifyProfile extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-23", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_23_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .checkAccessListIsPresent()
                .checkGeoBlockIsPresent()
                .logout();
    }
}

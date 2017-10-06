package com.actionmedia.tests.functional.bss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 18:15
 */
public class BSS_51_VerifyServicesDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-51", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_51_test() {
        loginBss()
                .navigateToServicesPage()
                .checkDefaultStateServicesPage()

                .checkLinksFromReportSection()

                .checkLinksFromCalculatorSection()

                .checkLinksFromWizardsSection()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.11.13
 * Time: 12:10
 */
public class KSS_155_VerifyServicesDefaultState extends AbstractDomainTest {

//    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "KSS-155", testCaseVersion = "1")
    @LoginAs(key = "kss.user.vip")
    @Version(section = "vip")
    public void kss_155_test() {
        loginKss()
                .navigateToServicesPage()
                .checkDefaultStateServicesPage()

                .checkRabotaRuImage()
                .checkRabotaRuBlock()

                .checkBusinessSchoolImage()
                .checkBusinessSchoolBlock()

                .checkSchoolDirectorImage()
                .checkSchoolDirectorBlock()

                .checkKadrovoeDeloImage()
                .checkKadrovoeDeloBlock()

                .checkActivationInCutsWork()
                .checkOpenProgramInCutsWork()

                .checkScrollRabotaRuImage()
                .checkScrollRabotaRuTitle()

                .checkScrollBusinessSchoolImage()
                .checkScrollBusinessSchoolTitle()

                .checkScrollSchoolDirectorImage()
                .checkScrollSchoolDirectorTitle()

                .checkKadrovoeDeloImage()
                .checkScrollKadrovikTitle()

                .checkLinksFromPage()
                .logout();
    }
}

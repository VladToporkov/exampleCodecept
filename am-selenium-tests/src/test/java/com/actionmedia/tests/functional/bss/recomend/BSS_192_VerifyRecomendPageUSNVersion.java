package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 17.04.2014
 * Time: 18:28
 */
public class BSS_192_VerifyRecomendPageUSNVersion extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-192", testCaseVersion = "1")
    @Version(section = "usn")
    public void bss_192_test() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .checkDefaultStateRecomendPageForNotLoggedUser()
                .checkAskExpertLinkIsPresent()
                .checkAboutSystemLinkIsPresent()
                .checkActivateCodeLinkIsPresent()
                .checkEnterLinkIsPresent()
                .checkLogoIsPresent()
                .checkTextVersionInHeader("Версия для упрощенки")

                .navigateToFormsPage()
                .navigateToRecomendPage()
                .checkCurrentUrlContainsText("/#/recommendations/")
                .checkDefaultStateRecomendPageForNotLoggedUser();
    }
}

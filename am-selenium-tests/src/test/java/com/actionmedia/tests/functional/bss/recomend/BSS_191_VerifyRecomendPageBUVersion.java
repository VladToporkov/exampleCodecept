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
public class BSS_191_VerifyRecomendPageBUVersion extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-191", testCaseVersion = "1")
    @Version(section = "budget")
    public void bss_191_test() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .checkDefaultStateRecomendPageForNotLoggedUser()
                .checkAskExpertLinkIsPresent()
                .checkAboutSystemLinkIsPresent()
                .checkActivateCodeLinkIsPresent()
                .checkEnterLinkIsPresent()
                .checkLogoIsPresent()
                .checkTextVersionInHeader("Версия для бюджетных, казенных и автономных учреждений")

                .navigateToFormsPage()
                .navigateToRecomendPage()
                .checkCurrentUrlContainsText("/#/recommendations/")
                .checkDefaultStateRecomendPageForNotLoggedUser();
    }
}

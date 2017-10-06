package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 17.04.2014
 * Time: 18:28
 */
public class BSS_150_VerifyRecomendPageKUVersion extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-150", testCaseVersion = "2")
    public void bss_150_test() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .checkDefaultStateRecomendPageForNotLoggedUser()
                .checkAskExpertLinkIsPresent()
                .checkAboutSystemLinkIsPresent()
                .checkActivateCodeLinkIsPresent()
                .checkEnterLinkIsPresent()
                .checkLogoIsPresent()
                .checkTextVersionInHeader("Версия для коммерческих организаций")

                .navigateToFormsPage()
                .navigateToRecomendPage()
                .checkCurrentUrlContainsText("/#/recommendations/")
                .checkDefaultStateRecomendPageForNotLoggedUser();
    }
}

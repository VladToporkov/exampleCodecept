package com.actionmedia.tests.functional.bss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 12:12
 */
public class BSS_126_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-126", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_126_test() {
        loginBss()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomWizard()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()

                .clickRandomWizard()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .clickRandomWizard()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .clickRandomWizard()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickCalculatorSection()
                .clickCalculatorByNumber(1)
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .clickCalculatorSection()
                .clickCalculatorByNumber(2)
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .clickCalculatorSection()
                .clickCalculatorByNumber(3)
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .clickCalculatorSection()
                .clickCalculatorByNumber(4)
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickHeader()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()
                .clickRubricatorButton()
                .clickActiveMenuItem()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()
                .logout();
    }
}

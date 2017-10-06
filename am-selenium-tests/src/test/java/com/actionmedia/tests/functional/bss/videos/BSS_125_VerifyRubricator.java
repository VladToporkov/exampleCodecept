package com.actionmedia.tests.functional.bss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 12:08
 */
public class BSS_125_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-125", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_125_test() {
        loginBss()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .logout();
    }
}

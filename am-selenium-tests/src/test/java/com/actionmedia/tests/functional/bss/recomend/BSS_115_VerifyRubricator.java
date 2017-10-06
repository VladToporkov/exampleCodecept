package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 13:54
 */
public class BSS_115_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-115", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_115_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromThirdMenu()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromThirdMenu()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromThirdMenu()
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

                .clickHeader()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()

                .clickRubricatorButton()
                .clickMyFavoritesButton()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()

                .clickRubricatorButton()
                .clickActiveMenuItem()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()
                .logout();
    }
}

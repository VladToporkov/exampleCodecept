package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 13:51
 */
public class BSS_120_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-120", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_120_test() {
        loginBss()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .clickRandomItemFromFirstMenu()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkActiveItemForSecondMenuIsHighlighted()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkActiveItemForSecondMenuIsHighlighted()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()
                .clickRandomItemFromSecondMenu()
                .checkActiveItemForSecondMenuIsHighlighted()
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

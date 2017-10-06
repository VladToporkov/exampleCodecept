package com.actionmedia.tests.functional.uss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 16:21
 */
public class VerifyRubricatorOnFormsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToFormsPage()
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

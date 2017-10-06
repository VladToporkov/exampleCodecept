package com.actionmedia.tests.functional.kss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 13:51
 */
public class KSS_179_VerifyRubricatorForms extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-179", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_179_test() {
        loginKss()
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

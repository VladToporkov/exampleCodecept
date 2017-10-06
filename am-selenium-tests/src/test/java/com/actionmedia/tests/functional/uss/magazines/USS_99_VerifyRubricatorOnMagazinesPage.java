package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 16:23
 */
public class USS_99_VerifyRubricatorOnMagazinesPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-99", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_99_test() {
        loginUss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomCommentaries()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomCommentaries()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomCommentaries()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
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

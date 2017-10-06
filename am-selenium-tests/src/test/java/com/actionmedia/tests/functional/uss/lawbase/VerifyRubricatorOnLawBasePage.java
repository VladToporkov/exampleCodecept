package com.actionmedia.tests.functional.uss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 16:03
 */
public class VerifyRubricatorOnLawBasePage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomKodeks()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkKodeksContentsIsPresent()
                .clickRandomPart()
                .checkKodeksContentsIsPresent()

                .clickRandomKodeks()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkKodeksContentsIsPresent()
                .clickRandomPart()
                .checkKodeksContentsIsPresent()

                .clickRandomKodeks()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkKodeksContentsIsPresent()
                .clickRandomPart()
                .checkKodeksContentsIsPresent()

                .clickRandomKodeks()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkKodeksArticleIsHighlighted()

                .clickRandomKodeks()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkKodeksArticleIsHighlighted()

                .clickRandomKodeks()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkKodeksArticleIsHighlighted()

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

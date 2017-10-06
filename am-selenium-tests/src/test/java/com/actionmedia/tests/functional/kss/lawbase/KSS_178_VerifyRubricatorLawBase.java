package com.actionmedia.tests.functional.kss.lawbase;

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
public class KSS_178_VerifyRubricatorLawBase extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-178", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_178_test() {
        loginKss()
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

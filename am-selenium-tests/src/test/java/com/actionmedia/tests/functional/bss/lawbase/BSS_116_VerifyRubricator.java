package com.actionmedia.tests.functional.bss.lawbase;

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
public class BSS_116_VerifyRubricator extends AbstractDomainTest {

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-116", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_116_test() {
        loginBss()
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

                .clickRandomPBU()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()

                .clickRandomPBU()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()

                .clickRandomPBU()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkContentsIsPresent()

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

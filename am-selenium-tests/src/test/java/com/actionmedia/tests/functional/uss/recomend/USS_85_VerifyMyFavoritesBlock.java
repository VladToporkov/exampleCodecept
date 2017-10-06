package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.annotations.AfterMethodCustom;
import com.actionmedia.annotations.BeforeMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 12:50
 */
public class USS_85_VerifyMyFavoritesBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-85", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_85_test() {
        loginUss()
                    .navigateToRecomendPage()
                    .clickMyFavoritesButton()
                    .clearAllBookmarks()
                    .logout();
        report("Провереятся работа пустого блока Мое избранное для залогиненного юзера");
        loginUss()
                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsPresent()
                .checkEmptyMyFavoritesBlock()

                .checkMyFavoritesLinksIsOpenedMyFavoritesMenu()
                .checkMyFavoritesMenuIsEmpty()

                .report("Провереятся работа пустого блока Мое избранное для не залогиненного юзера")
                .logout()
                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsAbsent();

        loginUss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()

                .report("Провереятся работа блока Мое избранное для залогиненного юзера")
                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsPresent()
                .checkIsNotEmptyMyFavoritesBlock()
                .checkMyFavoritesMenuIsNotEmpty()
                .checkMyFavoritesLinksIsOpenedMyFavoritesMenu()
                .checkLinkInMyFavoritesBlock()

                .report("Провереятся работа пустого блока Мое избранное для не залогиненного юзера")
                .logout()
                .navigateToFormsPage()
                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsAbsent();
    }

    @AfterMethodCustom
    @LoginAs(key = "uss.user.commercial")
    public void clearAllBookmarks() {
        loginUss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}




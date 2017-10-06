package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.annotations.AfterMethodCustom;
import com.actionmedia.annotations.BeforeMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 10:15
 */
public class BSS_15_VerifyMyFavoritesBlock extends AbstractDomainTest {

    @BeforeMethodCustom
    @LoginAs(key = "bss.user.commercial")
    public void bss_15_clearAllBookmarksBefore() {
        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "bss-15", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_15_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsPresent()
                .checkEmptyMyFavoritesBlock()
                .checkMyFavoritesLinksIsOpenedMyFavoritesMenu()
                .checkMyFavoritesMenuIsEmpty()

                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()

                .navigateToRecomendPage()
                .checkMyFavoritesBlockIsPresent()
                .checkIsNotEmptyMyFavoritesBlock()
                .checkMyFavoritesMenuIsNotEmpty()
                .checkMyFavoritesLinksIsOpenedMyFavoritesMenu()
                .checkLinkInMyFavoritesBlock()
                .logout();
    }

    @AfterMethodCustom
    @LoginAs(key = "bss.user.commercial")
    public void bss_15_clearAllBookmarksAfter() {
        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}



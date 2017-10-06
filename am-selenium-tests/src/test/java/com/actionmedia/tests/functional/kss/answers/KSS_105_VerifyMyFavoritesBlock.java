package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.annotations.AfterMethodCustom;
import com.actionmedia.annotations.BeforeMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 10:15
 */
public class KSS_105_VerifyMyFavoritesBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-105", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_105_test() {
        loginKss()
                .navigateToAnswersPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();

        report("Провереятся работа пустого блока Мое избранное для не залогиненного юзера");
        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .checkMyFavoritesBlockIsAbsent();

        loginKss()
                .navigateToAnswersPage()
                .checkMyFavoritesBlockIsPresent()
                .checkEmptyMyFavoritesBlock()

                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()
                .navigateToFormsPage()
                .logout();

        loginKss()
                .navigateToAnswersPage()
                .checkMyFavoritesBlockIsPresent()
                .checkIsNotEmptyMyFavoritesBlock()
                .checkMyFavoritesMenuIsNotEmpty()
                .checkMyFavoritesLinksIsOpenedMyFavoritesMenu()
                .checkLinkInMyFavoritesBlock()
                .logout();
    }

    @AfterMethodCustom
    @LoginAs(key = "kss.user.commercial")
    public void kss_105_after() {
        loginKss()
                .navigateToAnswersPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}



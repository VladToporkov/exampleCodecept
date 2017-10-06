package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 13.03.2014
 * Time: 14:49
 */
public class USS_191_VerifyMagazinesMainPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-191", testCaseVersion = "1")
    public void uss_191_test() {
        enterToUssWithoutLogin()
                .navigateToMagazinesPage()
                .clickRandomMagazine()
                .checkMagazineNameIsPresent()
                .checkMagazineNumberIsPresent()
                .checkListOfArticlesOnMainMagazinesPageArePresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")

                .checkAddToFavoritesButtonForMagazinesIsAbsent()
                .checkBrowseButtonIsAbsent()
                .checkPrintAllMagazineButtonIsAbsent()
                .checkSendButtonIsAbsent()

                .clickRandomArticleFromMagazinesMainPage()
                .checkSelectedArticleIsOpened()
                .checkAuthFormIsPresent();

        updateLoginAsInfo("uss.user.commercial");
        loginUss()
                .navigateToMagazinesPage()
                .clickRandomMagazine()

                .checkMagazineNameIsPresent()
                .checkMagazineNumberIsPresent()
                .checkListOfArticlesOnMainMagazinesPageArePresent()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkBrowseButtonIsPresent()
                .checkPrintAllMagazineButtonIsPresent()
                .checkSendButtonIsPresent()

                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()

                .clickMailButton()
                .checkMailFormIsPresent()
                .clickMailButton()

                .clickRandomArticleFromMagazinesMainPage()
                .checkSelectedArticleIsOpened()
                .logout();
    }
}

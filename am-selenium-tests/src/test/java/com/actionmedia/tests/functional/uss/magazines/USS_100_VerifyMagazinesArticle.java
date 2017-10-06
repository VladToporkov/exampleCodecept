package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssRubricator;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 13.03.2014
 * Time: 14:49
 */
public class USS_100_VerifyMagazinesArticle extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-100", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_100_test() {
        UssRubricator ussRubricator = loginUss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine();

        while (!ussRubricator.isNotFirstAndNotLastArticle()) {
            ussRubricator
                    .clickRandomMagazine();
        }

        ussRubricator
                .clickRandomNotFirstAndNotLastArticle()

                .checkMagazineNameIsPresent()
                .checkMagazineNumberIsPresent()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkBrowseButtonIsPresent()
                .checkPrintMagazineButtonIsPresent()
                .checkSaveButtonIsPresent()
                .checkSendButtonIsPresent()
                .checkNavigationButtonsArePresent()

                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()

                .checkNavigationButtonFunctionality()

                .clickTableOfContentsButton()
                .checkCurrentItemIsHighlightedInTableOfContents()
                .clickRandomArticleFromTableOfContents()
                .checkSelectedArticleIsOpened()
                .logout();
    }
}

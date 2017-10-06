package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.annotations.AfterMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 12:40
 */
public class BSS_36_VerifyFavorites extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-36", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_36_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();

        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForDocumentButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickFirstArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForKodeksButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToFormsPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .clickRandomAddToFavoritesButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForDocumentButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .clickRandomAddToFavoritesForMagazinesButton()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToVideoPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .clickRandomAddToFavoritesButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickRandomWizard()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .clickRandomAddToFavoritesButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickCalculatorSection()
                .clickRandomArticle()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForDocumentButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()
                .logout();
    }

    @AfterMethodCustom
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void delete_BSS_36() {
        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}

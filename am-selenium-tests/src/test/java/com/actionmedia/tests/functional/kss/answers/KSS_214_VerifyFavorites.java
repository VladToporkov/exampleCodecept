package com.actionmedia.tests.functional.kss.answers;

import com.actionmedia.annotations.AfterMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 12:40
 */
public class KSS_214_VerifyFavorites extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-214", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_214_test() {
        loginKss()
                .navigateToAnswersPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();

        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("/#/document/130/random/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForDocumentButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .openDocumentByModuleIdAndDocId("/#/document/99/901714421/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForKodeksButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .openDocumentByModuleIdAndDocId("/#/document/121/random/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .clickRandomAddToFavoritesButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .openDocumentByModuleIdAndDocId("/#/document/117/random/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .clickRandomAddToFavoritesForDocumentButton()
                .checkAddToFavoritesButtonIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickRandomArticle()
                .openDocumentByModuleIdAndDocId("/#/document/160/random/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .clickRandomAddToFavoritesForMagazinesButton()
                .checkAddToFavoritesButtonForMagazinesIsHighlighted()
                .clickMyFavoritesButton()
                .checkAddedItemIsPresentInMyFavoritesMenu()

                .openDocumentByModuleIdAndDocId("/#/document/126/random/")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .clickRandomAddToFavoritesForMagazinesButton()
                .checkAddToFavoritesButtonForMagazinesIsHighlighted()
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

                .logout();

        loginKss()
                .navigateToAnswersPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }

    @AfterMethodCustom
    @LoginAs(key = "kss.user.commercial")
    public void after_kss_214() {
        loginKss()
                .navigateToAnswersPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}

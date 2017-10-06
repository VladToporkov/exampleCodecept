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
 * Date: 16.04.2014
 * Time: 17:18
 */
public class BSS_148_VerifyFavoritesRubricator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-148", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_148_test() {
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
                .clickRandomAddToFavoritesForDocumentButton()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickFirstArticle()
                .clickRandomAddToFavoritesForKodeksButton()

                .navigateToFormsPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()

                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesForDocumentButton()

                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesForMagazinesButton()

                .navigateToVideoPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickRandomWizard()
                .clickRandomArticle()
                .clickRandomAddToFavoritesButton()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickCalculatorSection()
                .clickRandomArticle()
                .clickRandomAddToFavoritesForDocumentButton()
                .logout();

        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clickRecomendDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickLawBaseDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickFormsDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickDictionaryDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickMagazinesDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickVideosDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickWizardsDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()

                .clickMyFavoritesButton()
                .clickCalculatorDocument()
                .checkPreDefinedDocumentIsOpened()
                .checkDocumentIsNotEmpty()
                .logout();
    }

    @AfterMethodCustom
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void after_BSS_148_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .logout();
    }
}

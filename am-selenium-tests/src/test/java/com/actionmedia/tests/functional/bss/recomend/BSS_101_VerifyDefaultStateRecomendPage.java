package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 11.10.13
 * Time: 10:47
 */
public class BSS_101_VerifyDefaultStateRecomendPage extends AbstractDomainTest {

    //    @Test(groups = {implemented})
//    @TestLink(testCaseId = "BSS-101", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_101_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkDefaultStateRecomendPage()
                .checkAllImagesWereLoaded()
                .checkRubricatorLinksFromYellowPlate()

                .checkRubricatorLinksFromFormsBlock()
                .checkRubricatorLinksFromDictionaryBlock()
                .checkRubricatorLinksFromMyFavoritesBlock()
                .checkRubricatorLinksForSection()

                .checkLinkFromYellowPlate()
                .checkDefaultStateRecomendPage()
                .checkLinkFromLawBaseBlock()
                .checkDefaultStateRecomendPage()
                .checkLinkFromMagazinesBlock()
                .checkDefaultStateRecomendPage()
                .checkLinkFromDictionaryBlock()
                .checkDefaultStateRecomendPage()
                .checkLinkFromVideoBlock()
                .checkDefaultStateRecomendPage()
                .logout();
    }
}

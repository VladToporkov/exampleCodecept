package com.actionmedia.tests.functional.uss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 28.11.13
 * Time: 16:30
 */
public class USS_98_VerifyMagazineDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-98", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_98_test() {
        loginUss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickRandomArticle()
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkBrowseButtonIsPresent()
                .checkPrintMagazineButtonIsPresent()
                .checkSaveButtonIsPresent()
                .checkSendButtonIsPresent()
                .checkNavigationButtonsArePresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }
}

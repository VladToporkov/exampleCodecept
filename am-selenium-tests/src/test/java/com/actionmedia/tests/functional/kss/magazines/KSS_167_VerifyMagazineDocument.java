package com.actionmedia.tests.functional.kss.magazines;

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
public class KSS_167_VerifyMagazineDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-167", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_167_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickRandomArticle()
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkBrowseButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkSaveButtonIsPresent()
                .checkSendButtonIsPresent()
                .checkNavigationButtonsForBookArePresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.kss.KssRubricator;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 28.11.13
 * Time: 16:10
 */
public class KSS_70_VerifyBookDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-70", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_70_test() {
        KssRubricator kssRubricator = loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomBook()
                .clickRandomItemFromSecondMenu();

        while (!kssRubricator.isNotFirstAndNotLastArticle()) {
            kssRubricator
                    .clickRandomBook()
                    .clickRandomItemFromSecondMenu();
        }

        kssRubricator
                .clickRandomNotFirstAndNotLastArticle()
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkPrintButtonIsPresent()
                .checkWordButtonIsPresent()
                .checkNavigationButtonsForBookArePresent()
                .checkSoderButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}

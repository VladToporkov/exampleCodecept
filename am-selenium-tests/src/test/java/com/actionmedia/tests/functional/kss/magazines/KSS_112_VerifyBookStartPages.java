package com.actionmedia.tests.functional.kss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 02.04.2014
 * Time: 15:38
 */
public class KSS_112_VerifyBookStartPages extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-70", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_112_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRandomBook()
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkListOfArticlesOnMainBookPageArePresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()

                .openDocumentByUrl(getDocumentUrlByKey("kss.125.module"))
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkListOfArticlesOnMainBookPageArePresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}

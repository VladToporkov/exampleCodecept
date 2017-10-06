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
 * Time: 17:00
 */
public class KSS_69_VerifyMagazineDocumentMainPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-69", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_69_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickFirstArticle()
                .checkDocumentIsOpened()
                .checkAddToFavoritesButtonForMagazinesIsPresent()
                .checkBrowseButtonIsPresent()
                .checkSendButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все журналы и книги")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}

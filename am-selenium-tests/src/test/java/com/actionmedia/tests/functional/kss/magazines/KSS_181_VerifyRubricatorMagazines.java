package com.actionmedia.tests.functional.kss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 16:23
 */
public class KSS_181_VerifyRubricatorMagazines extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-181", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_181_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomBook()
                .clickRandomItemFromSecondMenu()
                .clickRandomArticle()
                .clickRubricatorButton()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomMagazine()
                .clickRandomItemFromSecondMenu()
                .clickRandomItemFromThirdMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickHeader()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()

                .clickRubricatorButton()
                .clickMyFavoritesButton()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()

                .clickRubricatorButton()
                .clickActiveMenuItem()
                .checkRubricatorIsClosed()
                .checkRubricatorButtonIsUnPressed()
                .logout();
    }
}

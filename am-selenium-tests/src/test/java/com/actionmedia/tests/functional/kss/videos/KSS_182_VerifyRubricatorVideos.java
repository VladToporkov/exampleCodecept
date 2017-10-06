package com.actionmedia.tests.functional.kss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 17:12
 */
public class KSS_182_VerifyRubricatorVideos extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-182", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_182_test() {
        loginKss()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()
                .clickRandomItemFromFirstMenu()
                .checkContentsIsPresent()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()

                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .clickRubricatorButton()
                .checkOpenedItemIsHighlighted()
                .logout();
    }
}

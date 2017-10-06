package com.actionmedia.tests.functional.kss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 28.11.13
 * Time: 15:10
 */
public class KSS_71_VerifyVideoDocument145Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-71", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_71_test() {
        loginKss()
                .navigateToVideoPage()
                .openDocumentByUrl(getDocumentUrlByKey("kss.145.module"))
                .checkDocumentIsOpened()
                .checkVideoVersionIsPresent()
                .checkVideoPlayerIsPresent()
                .checkNavigationButtonsForVideoArePresent()
                .checkVideoTitleIsPresent()
                .checkVideoPartTitleIsPresent()
                .checkVideoPartsArePresent()
                .checkActivePartHasPlayButton()
                .checkRubricatorButtonIsPresent("Все видео")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonIsPresent()
                .logout();
    }
}

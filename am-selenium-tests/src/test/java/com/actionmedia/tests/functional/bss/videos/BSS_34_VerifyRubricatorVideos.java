package com.actionmedia.tests.functional.bss.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 12:08
 */
public class BSS_34_VerifyRubricatorVideos extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-34", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_34_test() {
        loginBss()
                .navigateToVideoPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkAllRubricatorSectionsHaveContent()
                .logout();
    }
}

package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 13:54
 */
public class BSS_29_VerifyRubricatorRecomend extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-29", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_29_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkAllRubricatorSectionsHaveContent()
                .logout();
    }
}

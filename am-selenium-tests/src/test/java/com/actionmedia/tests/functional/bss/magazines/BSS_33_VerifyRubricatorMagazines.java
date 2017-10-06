package com.actionmedia.tests.functional.bss.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 10:50
 */
public class BSS_33_VerifyRubricatorMagazines extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-33", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_33_test() {
        loginBss()
                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkAllRubricatorSectionsHaveContent()
                .logout();
    }
}

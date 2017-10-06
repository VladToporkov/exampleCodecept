package com.actionmedia.tests.functional.bss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 13:51
 */
public class BSS_32_VerifyRubricatorDictionary extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-32", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_32_test() {
        loginBss()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkFirstElementIsSelected()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkAllRubricatorSectionsHaveContent()
                .logout();
    }
}

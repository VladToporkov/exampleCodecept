package com.actionmedia.tests.functional.bss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 22.10.13
 * Time: 12:12
 */
public class BSS_35_VerifyRubricatorServices extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-35", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_35_test() {
        loginBss()
                .navigateToServicesPage()
                .clickRubricatorButton()
                .checkRubricatorButtonIsPressed()
                .checkActiveItemForFirstMenuIsHighlighted()
                .checkAllRubricatorSectionsHaveContent()
                .logout();
    }
}

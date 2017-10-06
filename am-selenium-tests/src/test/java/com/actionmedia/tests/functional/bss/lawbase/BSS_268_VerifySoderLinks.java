package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 18:51
 */
public class BSS_268_VerifySoderLinks extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-268", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_268_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .checkScrolling()
                .logout();
    }
}

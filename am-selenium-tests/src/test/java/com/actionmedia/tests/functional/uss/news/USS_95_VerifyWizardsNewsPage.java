package com.actionmedia.tests.functional.uss.news;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 15:27
 */
public class USS_95_VerifyWizardsNewsPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-95", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_95_test() {
        loginUss()
                .navigateToRecomendPage()
                .clickNewsLink()
                .clickServiceSection()
                .checkNewsIsPresent()
                .checkLinksOnNewsPage()
                .checkNewsScrolling()
                .checkNewsBlockAreNotRepeated()
                .checkNewsAreNotEmpty()
                .logout();
    }
}

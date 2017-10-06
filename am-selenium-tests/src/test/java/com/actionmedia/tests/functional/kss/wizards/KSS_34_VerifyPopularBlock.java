package com.actionmedia.tests.functional.kss.wizards;

import com.actionmedia.annotations.BeforeMethodCustom;
import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 15:20
 */
public class KSS_34_VerifyPopularBlock extends AbstractDomainTest {

    @BeforeMethodCustom
    @LoginAs(key = "kss.user.commercial")
    public void openFewWizards() {
        loginKss()
                .navigateToWizardsPage()
                .openFewWizards()
                .logout();
    }

//    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-34", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_34_test() {
        loginKss()
                .navigateToWizardsPage()
                .checkPopularBlockIsPresent()
                .checkPopularBlockAreNotEmpty()
                .checkPopularWizardsLinks()
                .logout();
    }
}

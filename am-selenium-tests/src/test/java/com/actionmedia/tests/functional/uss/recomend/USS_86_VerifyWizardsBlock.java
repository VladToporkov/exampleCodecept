package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 30.10.13
 * Time: 12:33
 */
public class USS_86_VerifyWizardsBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-86", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_86_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkWizardsBlockIsPresent()
                .checkWizardsBlockIsNotEmpty()

                .checkLinksInWizardsBlock()
                .checkLinkInWizardsBlockIsOpenedServicesPage()
                .logout();
    }
}

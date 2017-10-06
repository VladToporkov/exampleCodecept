package com.actionmedia.tests.functional.kss.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.09.13
 * Time: 17:29
 */
public class KSS_32_VerifyPetalElements extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-32", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_32_test() {
        loginKss()
                .navigateToWizardsPage()
                .checkPetalBlocksIsPresent()
                .checkLinksForPetalBlock()
                .logout();
    }
}

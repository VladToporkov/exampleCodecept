package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 15:20
 */
public class KSS_19_VerifyKodexBlock extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "KSS-19", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_19_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkKodexBlockIsDisplayed()
                .checkKodexBlockIsNotEmpty()
                .checkKodexOrder()
                .checkBlanksOrder()
                .checkLinksForKodexBlock()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.dictionary;

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
public class KSS_26_VerifyPopularBlock extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-26", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_26_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkPopularBlockIsDisplayed()
                .checkPopularBlockAreNotEmpty()
                .checkPopularFormLinks()
                .logout();
    }
}

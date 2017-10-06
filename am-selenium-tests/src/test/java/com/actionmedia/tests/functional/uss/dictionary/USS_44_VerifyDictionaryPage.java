package com.actionmedia.tests.functional.uss.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 29.10.13
 * Time: 11:50
 */
public class USS_44_VerifyDictionaryPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "USS-44", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_44_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDefaultStateDictionaryPage()
                .logout();
    }
}

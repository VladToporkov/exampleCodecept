package com.actionmedia.tests.functional.bss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 11:45
 */
public class BSS_128_VerifyFormDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-128", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_128_test() {
        loginBss()
                .navigateToFormsPage()
                .clickLastForm()
                .checkContentIsPresent()
                .checkDownloadButtonIsPresent()

                .navigateToFormsPage()
                .clickRandomFormFromPopularBlock()
                .checkContentIsPresent()
                .checkDownloadButtonIsPresent()

                .navigateToFormsPage()
                .clickRandomFormFromNewsBlock()
                .checkContentIsPresent()
                .checkDownloadButtonIsPresent()
                .logout();
    }
}

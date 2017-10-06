package com.actionmedia.tests.functional.fss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 11.11.13
 * Time: 14:57
 */
public class FSS_11_VerifyDefaultStateServicesPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-11", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_11_test() {
        loginFss()
                .navigateToServicesPage()
                .checkDefaultStateServicesPage()

                .checkLinksFromServicesBlock()

                .checkDateAreSortedDescending()
                .checkNewsAreNotEmpty()
                .checkNewsBlockAreNotRepeat()

                .checkRandomLinksFromExpandedExamplesBlock()
                .checkRandomLinksFromExpandedAdditionalBlock();
    }
}

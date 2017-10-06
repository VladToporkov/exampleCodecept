package com.actionmedia.tests.functional.fss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 03.12.13
 * Time: 11:59
 */
public class FSS_152_VerifyRightPanel extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "FSS-152", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_152_test() {
        loginFss()
                .navigateToServicesPage()
                .checkCollapsedRightPanel()

                .checkRandomLinksFromCollapsedAdditionalTab()
                .checkRandomLinksFromCollapsedExampleTab()

                .checkExpandedRightPanel()

                .checkRandomLinksFromExpandedAdditionalBlock()
                .checkRandomLinksFromExpandedExamplesBlock();
    }
}

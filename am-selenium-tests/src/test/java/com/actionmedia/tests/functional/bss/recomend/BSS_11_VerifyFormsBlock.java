package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 12.18.13
 * Time: 15:31
 */
public class BSS_11_VerifyFormsBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-11", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_11_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkFormsWidgetIsPresent()
                .checkFormsBlockIsNotEmpty()

                .clickFormsLink()
                .checkDefaultStateFormsPage()
                .logout();
    }
}

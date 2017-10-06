package com.actionmedia.tests.functional.fss.mainpage;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 30.04.2014
 * Time: 15:36
 */
public class FSS_151_VerifyAccessActivationButton extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-151", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_151_test() {
        loginFss()
                .navigateToPersonalCabinetPage()
                .clickActivateButton()
                .checkDefaultStateActivationCodeTab();
    }
}

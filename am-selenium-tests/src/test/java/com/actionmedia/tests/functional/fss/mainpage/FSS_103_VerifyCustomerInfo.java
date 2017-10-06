package com.actionmedia.tests.functional.fss.mainpage;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 17:47
 */
public class FSS_103_VerifyCustomerInfo extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-103", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_103_test() {
        loginFss()
                .navigateToPersonalCabinetPage()
                .checkDefaultStatePersonalInfoTab()

                .clickChangePasswordTab()
                .checkDefaultStateChangePasswordTab()

                .clickActivationCodeTab()
                .checkDefaultStateActivationCodeTab()

                .clickPersonalInfoTab()
                .checkDefaultStatePersonalInfoTab();
    }
}

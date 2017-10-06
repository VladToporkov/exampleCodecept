package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssServicesPage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.*;

/**
 * User: n.tyukavkin
 * Date: 27.02.14
 * Time: 16:08
 */
public class USS_181_VerifyLoginToKD extends AbstractDomainTest {

    public static final String LOGIN = "uss.user.vip";

    @Test(groups = {smoke, implemented, noProk, noRT, noWeb13})
    @TestLink(testCaseId = "USS-181", testCaseVersion = "1")
    @LoginAs(key = LOGIN)
    @Version(section = "doc")
    public void uss_181_test() {
        loginUss()
                .navigateToServicesPage()
                .checkUserInfoLinkIsPresent()
                .checkKDPageIsOpened()

                .clickLogoutLinkOnKDPage()
                .checkCurrentUrlContainsText("http://constructor", "?fullscreen=1")
                .checkKDPageIsOpened()
                .checkLoginButtonIsPresent()

                .clickLoginLinkOnKDPage()
                .checkLoginPageIsOpened()
                .checkCurrentUrlContainsText("?continue=http://constructor", "/#/customer/auth/")

                .login(UssServicesPage.class, getLoginByKey(LOGIN), getPasswordByKey(LOGIN))
                .checkKDPageIsOpened()
                .checkUserInfoLinkIsPresent()
                .checkLogoutButtonIsPresent()

                .clickPartnersButtonButton()
                .checkEmptyPartnersTextIsPresent()
                .clickLogoutLinkOnKDPage();
    }
}

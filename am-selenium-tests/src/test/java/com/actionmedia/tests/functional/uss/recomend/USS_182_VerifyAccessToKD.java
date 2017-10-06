package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.*;

/**
 * User: n.tyukavkin
 * Date: 27.02.14
 * Time: 16:08
 */
public class USS_182_VerifyAccessToKD extends AbstractDomainTest {

    @Test(groups = {regression, implemented, noProk, noRT, noWeb13})
    @TestLink(testCaseId = "USS-182", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    @Version(section = "doc")
    public void uss_182_test() {
        report("Проверяется доступ к ЮСС КД для пользователя без доступов");
        loginUss()
                .navigateToServicesPage()
                .checkActivationCodePageIsOpened()
                .checkCurrentUrlContainsText("#/customer/activate-code/")
                .logout();

        report("Проверяется доступ к ЮСС КД для пользователя со всеми доступами");
        enterToUssWithoutLogin()
                .navigateToServicesPage()
                .checkKDPageIsOpened()
                .checkCurrentUrlContainsText("http://constructor", "?fullscreen=1")
                .checkLoginButtonIsPresent()
                .clickPartnersButtonButton()
                .checkLoginAlertIsPresent()
                .clickLoginLinkOnAlert()
                .checkLoginPageIsOpened()
                .checkCurrentUrlContainsText("?continue=http://constructor", "/#/customer/auth/");
    }
}

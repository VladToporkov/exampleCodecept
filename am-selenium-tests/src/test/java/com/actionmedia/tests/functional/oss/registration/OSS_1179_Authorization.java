package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssRecomendPage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 03/03/16.
 */
public class OSS_1179_Authorization extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1179", testCaseVersion = "1")
    public void oss_1179_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверка Авторизация на сайте через форму входа ЮСС КУ");
        uss_authorization_test();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверка Авторизация на сайте через форму входа ФСС КУ");
        fss_authorization_test();

        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверка Авторизация на сайте через форму входа БСС КУ");
        bss_authorization_test();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверка Авторизация на сайте через форму входа КСС КУ");
        kss_authorization_test();
    }

    private void uss_authorization_test() {
        enterToUssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .checkAutoLoggingIsActive()
                .unSelectRememberCheckBox() //for further testing

                .typeLogin()
                .typePassword()

                .clickOnEyeIconOnPasswordField()
                .checkPasswordBecameVisible()

                .clickOnEnterButton(BssRecomendPage.class)
                .logout();
    }

    private void fss_authorization_test() {
        enterToFssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .checkAutoLoggingIsActive()
                .unSelectRememberCheckBox() //for further testing

                .typeLogin()
                .typePassword()

                .clickOnEyeIconOnPasswordField()
                .checkPasswordBecameVisible()

                .clickOnEnterButton(BssRecomendPage.class)
                .logout();
    }

    private void bss_authorization_test() {
        enterToBssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .checkAutoLoggingIsActive()
                .unSelectRememberCheckBox() //for further testing

                .typeLogin()
                .typePassword()

                .clickOnEyeIconOnPasswordField()
                .checkPasswordBecameVisible()

                .clickOnEnterButton(BssRecomendPage.class)
                .logout();
    }

    private void kss_authorization_test() {
        enterToKssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .checkAutoLoggingIsActive()
                .unSelectRememberCheckBox() //for further testing

                .typeLogin()
                .typePassword()

                .clickOnEyeIconOnPasswordField()
                .checkPasswordBecameVisible()

                .clickOnEnterButton(BssRecomendPage.class)
                .logout();
    }
}

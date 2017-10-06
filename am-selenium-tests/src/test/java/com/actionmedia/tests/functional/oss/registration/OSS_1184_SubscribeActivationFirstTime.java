package com.actionmedia.tests.functional.oss.registration;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/03/16.
 */
public class OSS_1184_SubscribeActivationFirstTime extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1184", testCaseVersion = "1")
    public void oss_1184_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Проверка Отображение формы регистрации через Вхожу в первый раз БСС");
        bss_test();

        updateLoginToInfo("budget");
        report("Проверка Отображение формы регистрации через Вхожу в первый раз БСС БУ");
        bss_test();

        updateLoginToInfo("usn");
        report("Проверка Отображение формы регистрации через Вхожу в первый раз БСС УСН");
        bss_test();

        updateLoginToInfo("vip");
        report("Проверка Отображение формы регистрации через Вхожу в первый раз БСС ВИП");
        bss_test();


        updateSystemInfo(SystemPubs.kss);
        report("Проверка Отображение формы регистрации через Вхожу в первый раз КСС");
        kss_test();

        updateLoginToInfo("budget");
        report("Проверка Отображение формы регистрации через Вхожу в первый раз КСС БУ");
        kss_test();

        updateLoginToInfo("vip");
        report("Проверка Отображение формы регистрации через Вхожу в первый раз КСС ВИП");
        kss_test();


        updateSystemInfo(SystemPubs.uss);
        report("Проверка Отображение формы регистрации через Вхожу в первый раз ЮСС");
        uss_test();


        updateSystemInfo(SystemPubs.fss);
        report("Проверка Отображение формы регистрации через Вхожу в первый раз ФСС");
        fss_test();
    }

    private void bss_test() {
        enterToBssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .chooseActivateSubscribe()
                .checkEnterFirstTime()
                .checkEmailFieldIsPresent()
                .checkPasswordFieldIsPresent()
                .checkFullNameFieldsArePresent()
                .checkPhoneFieldsArePresent()
                .checkCaptchaFieldIsPresent()
                .checkCaptchaImageIsPresent()
                .checkRegistrationButtonIsPresent()
                .checkGetDemoButtonIsDisabled();
    }

    private void kss_test() {
        enterToKssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .chooseActivateSubscribe()
                .checkEnterFirstTime()
                .checkEmailFieldIsPresent()
                .checkPasswordFieldIsPresent()
                .checkFullNameFieldsArePresent()
                .checkPhoneFieldsArePresent()
                .checkCaptchaFieldIsPresent()
                .checkCaptchaImageIsPresent()
                .checkRegistrationButtonIsPresent()
                .checkGetDemoButtonIsDisabled();
    }

    private void uss_test() {
        enterToUssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .chooseActivateSubscribe()
                .checkEnterFirstTime()
                .checkEmailFieldIsPresent()
                .checkPasswordFieldIsPresent()
                .checkFullNameFieldsArePresent()
                .checkPhoneFieldsArePresent()
                .checkCaptchaFieldIsPresent()
                .checkCaptchaImageIsPresent()
                .checkRegistrationButtonIsPresent()
                .checkGetDemoButtonIsDisabled();
    }

    private void fss_test() {
        enterToFssWithoutLogin()
                .navigateToLoginPage()
                .checkLoginPageIsOpened()
                .chooseActivateSubscribe()
                .checkEnterFirstTime()
                .checkEmailFieldIsPresent()
                .checkPasswordFieldIsPresent()
                .checkFullNameFieldsArePresent()
                .checkPhoneFieldsArePresent()
                .checkCaptchaFieldIsPresent()
                .checkCaptchaImageIsPresent()
                .checkRegistrationButtonIsPresent()
                .checkGetDemoButtonIsDisabled();
    }
}

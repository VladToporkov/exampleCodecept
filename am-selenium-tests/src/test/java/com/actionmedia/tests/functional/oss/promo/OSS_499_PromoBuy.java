package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_499_PromoBuy extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-499", testCaseVersion = "1")
    public void oss_499_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется отображение блока 'Купить' Промо КСС КУ");
        kss_499_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение блока 'Купить' Промо КСС БУ");
        kss_499_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение блока 'Купить' страницы Промо КСС ВИП");
        kss_499_test();

        updateLoginAsInfo("user.promo");
        report("Проверяется отображение блока 'Купить'  страницы Промо КСС для пользователя с привязанным диллером");
        kss_499_test_promo_user();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение блока 'Купить' страницы Промо БСС КУ");
        bss_499_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение блока 'Купить' страницы Промо БСС ВИП");
        bss_499_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется отображение блока 'Купить' страницы Промо БСС УПР");
        bss_499_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение блока 'Купить' страницы Промо БСС БУ");
        bss_499_test();

        updateLoginAsInfo("user.promo");
        report("Проверяется отображение блока 'Купить' страницы Промо БСС для пользователя с привязанным диллером");
        bss_499_test_promo_user();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение блока 'Купить' страницы Промо ЮСС КУ");
        uss_499_test();

        updateLoginAsInfo("user.promo");
        report("Проверяется отображение блока 'Купить' страницы Промо ЮСС для пользователя с привязанным диллером");
        uss_499_test_promo_user();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение блока 'Купить' страницы Промо ФСС КУ");
        fss_499_test();

        updateLoginAsInfo("user.promo");
        report("Проверяется отображение блока 'Купить' страницы Промо ФСС для пользователя с привязанным диллером");
        fss_499_test_promo_user();
    }

    private void kss_499_test() {
        loginKss()
                .navigateToPromoPage()

                .checkTrialDisplayed()

                .checkBuyDisplay()

                .checkCityBlock()

                .checkUserDealer();
    }

    private void kss_499_test_promo_user() {
        loginKss()
                .navigateToPromoPage()

                .checkBuyDisplay()

                .checkPromoDealer();
    }

    private void bss_499_test() {
        loginBss()
                .navigateToPromoPage()

                .checkTrialDisplayed()

                .checkBuyDisplay()

                .checkCityBlock()

                .checkUserDealer();
    }

    private void bss_499_test_promo_user() {
        loginBss()
                .navigateToPromoPage()

                .checkBuyDisplay()

                .checkPromoDealer();
    }

    private void uss_499_test() {
        loginUss()
                .navigateToPromoPage()

                .checkTrialDisplayed()

                .checkBuyDisplay()

                .checkCityBlock()

                .checkUserDealer();
    }

    private void uss_499_test_promo_user() {
        loginUss()
                .navigateToPromoPage()

                .checkBuyDisplay()

                .checkPromoDealer();
    }

    private void fss_499_test() {
        loginFss()
                .navigateToPromoPage()

                .checkTrialDisplayed()

                .checkBuyDisplay()

                .checkCityBlock()

                .checkUserDealer();
    }

    private void fss_499_test_promo_user() {
        loginFss()
                .navigateToPromoPage()

                .checkBuyDisplay()

                .checkPromoDealer();
    }
}

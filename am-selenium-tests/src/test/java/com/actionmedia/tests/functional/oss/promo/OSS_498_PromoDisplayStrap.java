package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_498_PromoDisplayStrap extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-498", testCaseVersion = "1")
    public void oss_498_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Желтая плашка (Промо) КСС КУ");
        kss_498_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Желтая плашка (Промо) КСС БУ");
        kss_498_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Желтая плашка (Промо) КСС ВИП");
        kss_498_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Желтая плашка (Промо) БСС КУ");
        bss_498_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Желтая плашка (Промо) БСС ВИП");
        bss_498_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Желтая плашка (Промо) БСС УПР");
        bss_498_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Желтая плашка (Промо) БСС БУ");
        bss_498_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Желтая плашка (Промо) ЮСС КУ");
        uss_498_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Желтая плашка (Промо) ЮСС ДОК");
        uss_498_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Желтая плашка (Промо) ФСС КУ");
        fss_498_test();
    }

    public void kss_498_test() {
        loginKss()
                .navigateToPromoPage()

                .checkAnswerDisplayed()

                .checkStrap()

                .checkStrapSearch()

                .checkStrapSearchRandom()

                .checkStrapLinks();
    }

    public void bss_498_test() {
        loginBss()
                .navigateToPromoPage()

                .checkAnswerDisplayed()

                .checkStrap()

                .checkStrapSearch()

                .checkStrapSearchRandom()

                .checkStrapLinks();
    }

    public void uss_498_test() {
        loginUss()
                .navigateToPromoPage()

                .checkAnswerDisplayed()

                .checkStrap()

                .checkStrapSearch()

                .checkStrapSearchRandom()

                .checkStrapLinks();
    }

    public void fss_498_test() {
        loginFss()
                .navigateToPromoPage()

                .checkAnswerDisplayed()

                .checkStrap()

                .checkStrapSearch()

                .checkStrapSearchRandom()

                .checkStrapLinks();
    }
}

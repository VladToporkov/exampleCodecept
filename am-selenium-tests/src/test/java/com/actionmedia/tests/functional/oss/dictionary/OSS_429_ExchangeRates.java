package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 24.02.2015.
 */

public class OSS_429_ExchangeRates extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-429", testCaseVersion = "1")
    public void oss_429_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) КСС КУ");
        kss_429_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение раздела (Справочник) КСС БУ");
        kss_429_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела (Справочник) КСС ВИП");
        kss_429_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) БСС КУ");
        bss_429_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела (Справочник) БСС ВИП");
        bss_429_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение раздела (Справочник) БСС УПР");
        bss_429_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) ФСС КУ");
        fss_429_test();
    }

    private void kss_429_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDisplayCurrencyOnDictionaryBoard()
                .logout();
    }

    private void bss_429_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDisplayCurrencyOnDictionaryBoard()
                .logout();
    }

    private void fss_429_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDisplayCurrencyOnDictionaryBoard()
                .logout();

    }
}

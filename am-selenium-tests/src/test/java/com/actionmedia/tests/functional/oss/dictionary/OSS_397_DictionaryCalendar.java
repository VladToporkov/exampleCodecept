package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_397_DictionaryCalendar extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-397", testCaseVersion = "1")
    public void oss_397_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется отображение календаря в разделе справочник КСС КУ");
        kss_397_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение календаря в разделе справочник КСС БУ");
        kss_397_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение календаря в разделе справочник КСС ВИП");
        kss_397_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение календаря в разделе справочник БСС КУ");
        bss_397_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение календаря в разделе справочник БСС ВИП");
        bss_397_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется отображение календаря в разделе справочник БСС УПР");
        bss_397_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение календаря в разделе справочник БСС БУ");
        bss_397_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение календаря в разделе справочник ЮСС КУ");
        uss_397_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется отображение календаря в разделе справочник ЮСС ДОК");
        uss_397_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение календаря в разделе справочник ФСС КУ");
        fss_397_test();
    }

    public void kss_397_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDateOnCalendar()

                .checkMonthCalendar()

                .checkRedDays()

                .checkMonthDayTable()

                .checkMonthHourTable()

                .checkFactoryCalendar()

                .logout();
    }

    public void bss_397_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDateOnCalendar()

                .checkMonthCalendar()

                .checkRedDays()

                .checkMonthDayTable()

                .checkMonthHourTable()

                .checkFactoryCalendar()

                .logout();
    }

    public void uss_397_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDateOnCalendar()

                .checkMonthCalendar()

                .checkRedDays()

                .checkMonthDayTable()

                .checkMonthHourTable()

                .checkFactoryCalendar()

                .logout();
    }

    public void fss_397_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDateOnCalendar()

                .checkMonthCalendar()

                .checkRedDays()

                .checkMonthDayTable()

                .checkMonthHourTable()

                .checkFactoryCalendar()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

public class OSS_493_DisplayDocument190_CalendarBlock extends AbstractDomainTest {

    private static final String BUTTON_NAME = "Весь справочник";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-493", testCaseVersion = "1")
    public void oss_493_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок календарь (навигация) КСС КУ");
        kssDocument_190();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блок календарь (навигация) КСС БУ");
        kssDocument_190();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блок календарь (навигация) КСС ВИП");
        kssDocument_190();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок календарь (навигация) БСС КУ");
        bssDocument_190();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блок календарь (навигация) БСС ВИП");
        bssDocument_190();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блок календарь (навигация) БСС УПР");
        bssDocument_190();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блок календарь (навигация) БСС БУ");
        bssDocument_190();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блок календарь (навигация) ЮСС КУ");
        ussDocument_190();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Блок календарь (навигация) ЮСС ДОК");
        ussDocument_190();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блок календарь (навигация) ФСС КУ");
        fssDocument_190();
    }

    private void kssDocument_190() {
        loginKss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkFactoryCalendarBlock()

                .checkDates()

                .checkCalendarInfoDays()

                .checkCalendarInfoHour()

                .checkCalendarWeekKoment()

                .checkNavigationButtons()

                .checkCalendarNavigationForward()

                .checkCalendarNavigationBackward()

                .checkFirstCalendarPage()

                .checkLastCalendarPage()

                .checkNumberOf()

                .logout();
    }

    private void bssDocument_190() {
        loginBss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkSetupCalendarButton()

                .checkFactoryCalendarBlock()

                .checkDates()

                .checkCalendarInfoDays()

                .checkCalendarInfoHour()

                .checkCalendarWeekKoment()

                .checkNavigationButtons()

                .checkCalendarNavigationForward()

                .checkCalendarNavigationBackward()

                .checkFirstCalendarPage()

                .checkLastCalendarPage()

                .checkNumberOf()

                .logout();
    }

    private void ussDocument_190() {
        loginUss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkFactoryCalendarBlock()

                .checkDates()

                .checkCalendarInfoDays()

                .checkCalendarInfoHour()

                .checkCalendarWeekKoment()

                .checkNavigationButtons()

                .checkCalendarNavigationForward()

                .checkCalendarNavigationBackward()

                .checkFirstCalendarPage()

                .checkLastCalendarPage()

                .checkNumberOf()

                .logout();
    }

    private void fssDocument_190() {
        loginFss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkFactoryCalendarBlock()

                .checkDates()

                .checkCalendarInfoDays()

                .checkCalendarInfoHour()

                .checkCalendarWeekKoment()

                .checkNavigationButtons()

                .checkCalendarNavigationForward()

                .checkCalendarNavigationBackward()

                .checkFirstCalendarPage()

                .checkLastCalendarPage()

                .checkNumberOf()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_492_DisplayDocument190 extends AbstractDomainTest {

    private static final String BUTTON_NAME_RUBRICATOR_HANDBOOK = "Весь справочник";
    private static final String BUTTON_NAME_RUBRICATOR_HANDBOOKS = "Все справочники";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-492", testCaseVersion = "3")
    public void oss_492_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) КСС КУ");
        kssDocument_190();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение документов (190 модуль Календарь) КСС БУ");
        kssDocument_190();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов (190 модуль Календарь) КСС ВИП");
        kssDocument_190();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) БСС КУ");
        bssDocument_190();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов (190 модуль Календарь) БСС ВИП");
        bssDocument_190();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется отображение документов (190 модуль Календарь) БСС УПР");
        bssDocument_190();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение документов (190 модуль Календарь) БСС БУ");
        bssDocument_190();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) ЮСС КУ");
        ussDocument_190();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется отображение документов (190 модуль Календарь) ЮСС ДОК");
        ussDocument_190();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) ФСС КУ");
        fssDocument_190();

        //EHS
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) ОТ КУ");
        ehsDocument_190();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется отображение документов (190 модуль Календарь) ОТ МИНИ");
        ehsDocument_190();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов (190 модуль Календарь) ОТ ВИП");
        ehsDocument_190();

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) ОБР КУ");
        eduDocument_190();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется отображение документов (190 модуль Календарь) ОБР МИНИ");
        eduDocument_190();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов (190 модуль Календарь) ОБР ВИП");
        eduDocument_190();

        //GO
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется отображение документов (190 модуль Календарь) ГЗ КУ");
        goDocument_190();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется отображение документов (190 модуль Календарь) ГЗ МИНИ");
        goDocument_190();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение документов (190 модуль Календарь) ГЗ ВИП");
        goDocument_190();
    }

    private void kssDocument_190() {
        enterToKssWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();


        loginKss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOK)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void bssDocument_190() {
        enterToBssWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginBss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOK)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void ussDocument_190() {
        enterToUssWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginUss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOK)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void fssDocument_190() {
        enterToFssWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginFss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOK)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void ehsDocument_190() {
        enterToOtWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginOT()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOK)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void eduDocument_190() {
        enterToEduWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginEdu()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOKS)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }

    private void goDocument_190() {
        enterToGoWithoutLogin()
                .navigateToDictionaryPage()
                .closePopupInviteDemo()
                .clickFactoryCalendarLink()
                .checkAuthBlockIsPresent();

        loginGo()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkTitle()

                .checkCalendarBlock()

                .checkEventsTitle()

                .checkEvents()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_RUBRICATOR_HANDBOOKS)

                .checkNotDisplayStars()

                .checkEventsBlock()

                .logout();
    }
}
package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

public class OSS_399_DictionaryPopylar extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-399", testCaseVersion = "1")
    public void oss_399_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется отображение блока популярное (Справочник) КСС КУ");
        kss_399_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение блока популярное (Справочник) КСС БУ");
        kss_399_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение блока популярное (Справочник) КСС ВИП");
        kss_399_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение блока популярное (Справочник) БСС КУ");
        bss_399_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение блока популярное (Справочник) БСС ВИП");
        bss_399_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется отображение блока популярное (Справочник) БСС УПР");
        bss_399_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение блока популярное (Справочник) БСС БУ");
        bss_399_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение блока популярное (Справочник) ЮСС КУ");
        uss_399_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется отображение блока популярное (Справочник) ЮСС ДОК");
        uss_399_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение блока популярное (Справочник) ФСС КУ");
        fss_399_test();
    }

    public void kss_399_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkPopularFormLinks()

                .logout();
    }

    public void bss_399_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkPopularFormLinks()

                .logout();
    }

    public void uss_399_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkPopularFormLinks()

                .logout();
    }

    public void fss_399_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkPopularFormLinks()

                .logout();
    }
}
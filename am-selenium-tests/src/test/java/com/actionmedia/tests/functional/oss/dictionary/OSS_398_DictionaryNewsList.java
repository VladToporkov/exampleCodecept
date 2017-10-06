package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_398_DictionaryNewsList extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-398", testCaseVersion = "1")
    public void oss_398_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется отображение новостной ленты в разделе справочник КСС КУ");
        kss_398_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение новостной ленты в разделе справочник КСС БУ");
        kss_398_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение новостной ленты в разделе справочник КСС ВИП");
        kss_398_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется отображение новостной ленты в разделе справочник БСС КУ");
        bss_398_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется отображение новостной ленты в разделе справочник БСС ВИП");
        bss_398_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется отображение новостной ленты в разделе справочник БСС УПР");
        bss_398_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется отображение новостной ленты в разделе справочник БСС БУ");
        bss_398_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется отображение новостной ленты в разделе справочник ЮСС КУ");
        uss_398_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется отображение новостной ленты в разделе справочник ЮСС ДОК");
        uss_398_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется отображение новостной ленты в разделе справочник ФСС КУ");
        fss_398_test();
    }

    public void kss_398_test() {
        loginKss()
                .navigateToDictionaryPage()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkNewsList()

                .checkScrollNewsList()

                .logout();
    }

    public void bss_398_test() {
        loginBss()
                .navigateToDictionaryPage()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkNewsList()

                .checkScrollNewsList()

                .logout();
    }

    public void uss_398_test() {
        loginUss()
                .navigateToDictionaryPage()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkNewsList()

                .checkScrollNewsList()

                .logout();
    }

    public void fss_398_test() {
        loginFss()
                .navigateToDictionaryPage()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkNewsList()

                .checkScrollNewsList()

                .logout();
    }


}
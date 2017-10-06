package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;


public class OSS_383_StatusFilter extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-383", testCaseVersion = "1")
    public void oss_383_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) КСС КУ");
        kss_383_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) КСС БУ");
        kss_383_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) КСС ВИП");
        kss_383_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) БСС КУ");
        bss_383_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) БСС ВИП");
        bss_383_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) БСС УПР");
        bss_383_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) БСС БУ");
        bss_383_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) ЮСС КУ");
        uss_383_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) ЮСС ДОК");
        uss_383_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По статусам (Правовая база) ФСС КУ");
        fss_383_test();
    }

    private void kss_383_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilter()
                .checkLinksStatusFilter()

                .logout();
    }

    private void bss_383_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilter()
                .checkLinksStatusFilter()

                .logout();
    }

    private void uss_383_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilter()
                .checkLinksStatusFilter()

                .logout();
    }

    private void fss_383_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilter()
                .checkLinksStatusFilter()

                .logout();
    }
}

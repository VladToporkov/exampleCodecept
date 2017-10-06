package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;


public class OSS_380_SortingFilterLawPage extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-380", testCaseVersion = "1")
    public void oss_380_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Сортировка (Правовая база) КСС КУ");
        kss_380_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Сортировка (Правовая база) КСС БУ");
        kss_380_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Сортировка (Правовая база) КСС ВИП");
        kss_380_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Сортировка (Правовая база) БСС КУ");
        bss_380_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Сортировка (Правовая база) БСС ВИП");
        bss_380_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Сортировка (Правовая база) БСС УПР");
        bss_380_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Сортировка (Правовая база) БСС БУ");
        bss_380_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Сортировка (Правовая база) ЮСС КУ");
        uss_380_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Сортировка (Правовая база) ЮСС ДОК");
        uss_380_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Сортировка (Правовая база) ФСС КУ");
        fss_380_test();
    }

    private void kss_380_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .checkRelevanceFilter()

                .logout();
    }

    private void bss_380_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .checkRelevanceFilter()

                .logout();
    }

    private void uss_380_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .checkRelevanceFilter()

                .logout();
    }

    private void fss_380_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .checkRelevanceFilter()

                .logout();
    }
}

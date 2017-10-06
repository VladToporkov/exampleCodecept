package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/12/15.
 */
public class OSS_386_SortingFilterMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-386", testCaseVersion = "2")
    public void oss_386_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Сортировка (Журналы и книги) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Сортировка (Журналы и книги) КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Сортировка (Журналы и книги) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Сортировка (Журналы и книги) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Сортировка (Журналы и книги) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Сортировка (Журналы и книги) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Сортировка (Журналы и книги) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Сортировка (Журналы и книги) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Сортировка (Журналы и книги) ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Сортировка (Журналы и книги) ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .checkRelevanceFilter()

                .logout();
    }

    private void bss_test() {
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

    private void uss_test() {
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

    private void fss_test() {
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

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_387_SearchFiltersMagazin extends AbstractDomainTest {

    public static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-387", testCaseVersion = "1")
    public void oss_365_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) КСС КУ");
        kss_365_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги)  КСС БУ");
        kss_365_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) КСС ВИП");
        kss_365_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) БСС КУ");
        bss_365_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) БСС ВИП");
        bss_365_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) БСС УПР");
        bss_365_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) БСС БУ");
        bss_365_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) ЮСС КУ");
        uss_365_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) ЮСС ДОК");
        uss_365_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По изданиям (Журналы и книги) ФСС КУ");
        fss_365_test();
    }

    private void kss_365_test() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkLinksArchiveFilter()
                .logout();
    }

    private void bss_365_test() {
        loginBss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkLinksArchiveFilter()
                .logout();
    }

    private void uss_365_test() {
        loginUss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkLinksArchiveFilter()
                .logout();
    }

    private void fss_365_test() {
        loginFss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkLinksArchiveFilter()
                .logout();
    }

}

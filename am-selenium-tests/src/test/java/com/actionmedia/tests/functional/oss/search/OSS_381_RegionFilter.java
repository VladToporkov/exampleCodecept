package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;


public class OSS_381_RegionFilter extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-381", testCaseVersion = "1")
    public void oss_381_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС КУ");
        kss_381_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС БУ");
        kss_381_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС ВИП");
        kss_381_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС КУ");
        bss_381_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС ВИП");
        bss_381_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС УПР");
        bss_381_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС БУ");
        bss_381_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ЮСС КУ");
        uss_381_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ЮСС ДОК");
        uss_381_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ФСС КУ");
        fss_381_test();
    }

    private void kss_381_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true)

                .checkMoscowRegionFilter()

                .checkAllRegionFilter()

                .logout();
    }

    private void bss_381_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true)

                .checkMoscowRegionFilter()

                .checkAllRegionFilter()

                .logout();
    }

    private void uss_381_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true)

                .checkMoscowRegionFilter()

                .checkAllRegionFilter()

                .logout();
    }

    private void fss_381_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true)

                .checkMoscowRegionFilter()

                .checkAllRegionFilter()

                .logout();
    }
}

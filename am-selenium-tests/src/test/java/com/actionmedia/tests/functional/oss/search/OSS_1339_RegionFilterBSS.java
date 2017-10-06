package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/11/15.
 */
public class OSS_1339_RegionFilterBSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1339", testCaseVersion = "1")
    public void oss_1339_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС КУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС ВИП");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС УПР");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) БСС БУ");
        test();
    }

    private void test() {
        loginBss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRegionFilter(true, "Калининградская область")

                .clickInLawPracticeLinkFilter()
                .checkRegionFilter(true, "Калининградская область")

                .clickProfileLink()
                .changeRegion("Москва")

                .logout();
    }
}

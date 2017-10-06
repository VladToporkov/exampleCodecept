package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/11/15.
 */
public class OSS_1340_RegionFilterKSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1340", testCaseVersion = "1")
    public void oss_1340_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) КСС ВИП");
        test();
    }

    private void test() {
        loginKss()
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

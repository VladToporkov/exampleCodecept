package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/11/15.
 */
public class OSS_1341_RegionFilterUSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1341", testCaseVersion = "1")
    public void oss_1341_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ЮСС ДОК");
        test();
    }

    private void test() {
        loginUss()
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

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 30/11/15.
 */
public class OSS_1342_RegionFilterFSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1342", testCaseVersion = "1")
    public void oss_1342_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По регионам (Правовая база) ФСС КУ");
        test();
    }

    private void test() {
        loginFss()
                .clickProfileLink()
                .changeRegion("Калининград")
                .goBack()
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

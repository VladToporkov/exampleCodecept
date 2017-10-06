package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1246_WidgetLawPagePresentFss extends AbstractDomainTest {

    private static final String QUERY_1 = "закон";
    private static final String QUERY_2 = "кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1246", testCaseVersion = "1")
    public void oss_1246_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Правовая база ФСС");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLawSearchWidgetIsNotPresent()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLawSearchWidgetIsNotPresent()

                .logout();
    }
}

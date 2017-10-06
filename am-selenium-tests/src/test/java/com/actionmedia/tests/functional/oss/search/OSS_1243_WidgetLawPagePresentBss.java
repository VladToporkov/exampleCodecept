package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1243_WidgetLawPagePresentBss extends AbstractDomainTest {

    private static final String QUERY_1 = "закон";
    private static final String QUERY_2 = "кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1243", testCaseVersion = "1")
    public void oss_1243_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Правовая база БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLawSearchWidgetIsNotPresent()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLawSearchWidgetIsNotPresent()

                .logout();
    }
}

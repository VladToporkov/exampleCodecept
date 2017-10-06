package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1262_WidgetMagazinesPresentUss extends AbstractDomainTest {

    private static final String QUERY_1 = "книги";
    private static final String QUERY_2 = "журналы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1262", testCaseVersion = "1")
    public void oss_1262_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .logout();
    }
}

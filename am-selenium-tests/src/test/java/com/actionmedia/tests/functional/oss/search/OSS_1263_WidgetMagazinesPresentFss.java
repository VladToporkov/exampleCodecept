package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1263_WidgetMagazinesPresentFss extends AbstractDomainTest {

    private static final String QUERY_1 = "книги";
    private static final String QUERY_2 = "журналы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1263", testCaseVersion = "1")
    public void oss_1263_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ФСС");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .logout();
    }
}

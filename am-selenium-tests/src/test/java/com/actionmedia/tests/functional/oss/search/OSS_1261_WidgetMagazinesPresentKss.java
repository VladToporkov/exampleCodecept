package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1261_WidgetMagazinesPresentKss extends AbstractDomainTest {

    private static final String QUERY_1 = "книги";
    private static final String QUERY_2 = "журналы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1261", testCaseVersion = "1")
    public void oss_1261_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 12/10/2016.
 */
public class OSS_1931_SearchResultsRecomendations_USS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1931", testCaseVersion = "1")
    public void oss_1931_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ЮСС КУ");
        test_uss();

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ЮСС БУ");
        test_uss();
    }

    private void test_uss() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()

                .checkSearchResultsContainLinksOnDocuments()
                .checkSearchResultsDocumentsContainBriefTextUnderTheLinks()

                .checkSearchTitle(QUERY)
                .checkSearchResultsExtendedStringIsPresent()

                .checkSearchResultHasStrongText()
                .checkSectionFilterIsPresent()

                .logout();
    }
}
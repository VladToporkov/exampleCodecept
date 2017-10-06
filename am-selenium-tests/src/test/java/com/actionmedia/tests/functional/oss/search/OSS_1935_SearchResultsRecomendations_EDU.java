package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 16/10/2016.
 */
public class OSS_1935_SearchResultsRecomendations_EDU extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1935", testCaseVersion = "1")
    public void oss_1935_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ОБР КУ");
        test_edu();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ОБР МИНИ");
        test_edu();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ОБР ВИП");
        test_edu();
    }

    private void test_edu() {
        loginEdu()
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

                .checkSearchResultTypeFilterByNKOIsPresent()
                .checkSearchResultTypeFilterByOrganizationsIsPresent()

                .logout();
    }
}

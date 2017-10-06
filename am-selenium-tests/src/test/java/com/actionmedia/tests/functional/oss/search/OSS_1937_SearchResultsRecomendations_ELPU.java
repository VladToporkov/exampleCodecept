package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 16/10/2016.
 */
public class OSS_1937_SearchResultsRecomendations_ELPU extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1937", testCaseVersion = "1")
    public void oss_1937_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ЭЛПУ КУ");
        test_elpu();

        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. ЭЛПУ ВИП");
        test_elpu();
    }

    private void test_elpu() {
        loginElpu()
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

                .checkSearchResultTypeFilterByRecomendationsIsPresent()

                .checkSearchResultRecomendationItemIsActivated()

                .logout();
    }
}

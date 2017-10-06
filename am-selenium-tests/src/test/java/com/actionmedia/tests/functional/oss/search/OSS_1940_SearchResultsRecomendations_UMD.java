package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 16/10/2016.
 */
public class OSS_1940_SearchResultsRecomendations_UMD extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1940", testCaseVersion = "1")
    public void oss_1940_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. УМД КУ");
        test_umd();

        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Рекомендации. УМД ВИП");
        test_umd();
    }

    private void test_umd() {
        loginUmd()
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

                .checkSearchResultRecomendationItemIsActivated()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 12/10/2016.
 */
public class OSS_1930_SearchResultsInAnswersPage_KSS extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1930", testCaseVersion = "1")
    public void oss_1930_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Ответы. КСС КУ");
        test_kss();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Ответы. КСС БУ");
        test_kss();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Ответы. КСС ВИП");
        test_kss();
    }

    private void test_kss() {
        loginKss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()

                .checkSearchResultsContainLinksOnDocuments()
                .checkSearchResultsDocumentsContainBriefTextUnderTheLinks()

                .checkSearchTitle(QUERY)
                .checkSearchResultsExtendedStringIsPresent()

                .checkSearchResultHasStrongText()
                .checkSectionFilterIsPresent()

                .checkSearchResultTypeFilterByThemesIsPresent()

                .checkSearchResultAnswersItemIsActivated()

                .logout();
    }
}
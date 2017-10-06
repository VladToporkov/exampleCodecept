package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/11/15.
 */
public class OSS_1338_SortingFilterLawBaseLogic extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1338", testCaseVersion = "1")
    public void oss_1338_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                testUSS();
                break;
            }
            case 1: {
                testFSS();
                break;
            }
            case 2: {
                testBSS();
                break;
            }
            case 3: {
                testKSS();
                break;
            }
        }
    }

    private void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.expert");
        report("Проверяется Сортировка Правовая база БСС КУ");
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .clickInLawPracticeLinkFilter()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkDocumentsInLawPracticePageAreSortedDescending()

                .clickRelevanceSortedFilter()
                .checkRelevanceLinkWorks()

                .logout();
    }

    private void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется Сортировка Правовая база ФСС КУ");
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .clickInLawPracticeLinkFilter()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkDocumentsInLawPracticePageAreSortedDescending()

                .clickRelevanceSortedFilter()
                .checkRelevanceLinkWorks()

                .logout();
    }

    private void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.expert");
        report("Проверяется Сортировка Правовая база КСС КУ");
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .clickInLawPracticeLinkFilter()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkDocumentsInLawPracticePageAreSortedDescending()

                .clickRelevanceSortedFilter()
                .checkRelevanceLinkWorks()

                .logout();
    }

    private void testUSS() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.expert");
        report("Проверяется Сортировка Правовая база ЮСС КУ");
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkSearchResultsDateFilter()

                .clickInLawPracticeLinkFilter()
                .checkRelevanceLinkWorks()

                .clickDateSortedFilter()
                .checkDocumentsInLawPracticePageAreSortedDescending()

                .clickRelevanceSortedFilter()
                .checkRelevanceLinkWorks()

                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
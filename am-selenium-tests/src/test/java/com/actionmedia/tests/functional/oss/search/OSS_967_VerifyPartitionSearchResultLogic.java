package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel Popov on 07/10/15.
 */
public class OSS_967_VerifyPartitionSearchResultLogic extends AbstractDomainTest {

    private static final String FIRSTQUERY = "договор";
    private static final String SECOND_QUERY_FOR_BSS_AND_USS = "Зачет";
    private static final String SECOND_QUERY_FOR_KSS_AND_FSS = "Случаи";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-967", testCaseVersion = "1")
    public void oss_967_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                testUss();
                break;
            }
            case 1: {
                testFss();
                break;
            }
            case 2: {
                testBss();
                break;
            }
            case 3: {
                testKss();
                break;
            }
        }
    }

    private void testUss() {
        String thirdQuery = "1";
        String fourthQuery = "Долг";

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи (Логика) ЮСС ");
        loginUss()
                .navigateToRecomendPage()
                .inputQueryInSearchBox(FIRSTQUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchSecondBlockResult(7)
                .checkSearchThirdBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)

                .inputQueryInSearchBox(SECOND_QUERY_FOR_BSS_AND_USS)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchResultBeforeShowMoreButton(2, 47)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(3, 47)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginUss()
                .navigateToMagazinesPage()
                .inputQueryInSearchBox(thirdQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(10)
                .checkSearchSecondBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginUss()
                .navigateToLawBasePage()
                .inputQueryInSearchBox(fourthQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchResultBeforeShowMoreButton(1, 50)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(2, 50)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();
    }

    private void testFss() {
        String thirdQuery = "1";
        String fourthQuery = "Работа";

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи (Логика) ФСС ");
        loginFss()
                .navigateToSolutionsPage()
                .inputQueryInSearchBox(FIRSTQUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchSecondBlockResult(7)
                .checkSearchThirdBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)

                .inputQueryInSearchBox(SECOND_QUERY_FOR_KSS_AND_FSS)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchResultBeforeShowMoreButton(2, 47)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(3, 47)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginFss()
                .navigateToFormsPage()
                .inputQueryInSearchBox(thirdQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(10)
                .checkSearchSecondBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginFss()
                .navigateToMagazinesPage()
                .inputQueryInSearchBox(fourthQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchResultBeforeShowMoreButton(1, 50)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(2, 50)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();
    }

    private void testBss() {
        String thirdQuery = "Деньги";
        String fourthQuery = "Постановление";

        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи (Логика) БСС ");
        loginBss()
                .navigateToRecomendPage()
                .inputQueryInSearchBox(FIRSTQUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchSecondBlockResult(7)
                .checkSearchThirdBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)

                .inputQueryInSearchBox(SECOND_QUERY_FOR_BSS_AND_USS)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchResultBeforeShowMoreButton(2, 47)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(3, 47)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginBss()
                .navigateToLawBasePage()
                .inputQueryInSearchBox(thirdQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(10)
                .checkSearchSecondBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginBss()
                .navigateToDictionaryPage()
                .inputQueryInSearchBox(fourthQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchResultBeforeShowMoreButton(1, 50)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(2, 50)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();
    }

    private void testKss() {
        String thirdQuery = "1";
        String fourthQuery = "1";

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.expert");
        report("Проверяется Подгрузка результатов поисковой выдачи (Логика) КСС ");
        loginKss()
                .navigateToAnswersPage()
                .inputQueryInSearchBox(FIRSTQUERY)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchSecondBlockResult(7)
                .checkSearchThirdBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)

                .inputQueryInSearchBox(SECOND_QUERY_FOR_KSS_AND_FSS)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(3)
                .checkWidgetContentAnyTypeArePresent(1, 3)
                .checkSearchResultBeforeShowMoreButton(2, 47)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(3, 47)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginKss()
                .navigateToVideoPage()
                .inputQueryInSearchBox(thirdQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchFirstBlockResult(10)
                .checkSearchSecondBlockResult(40)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();

        loginKss()
                .navigateToFormsPage()
                .inputQueryInSearchBox(fourthQuery)
                .clickSearchButtonAndNavigateToSearchResultHelper()
                .checkSearchResultBeforeShowMoreButton(1, 50)
                .clickShowMoreButton()
                .checkSearchResultAfterShowMoreButton(2, 50)
                .scrollToEnd()
                .checkSearchPartLoadedBlocksResult(50)
                .checkSearchLastBlockResult(50)
                .logoutBase();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}

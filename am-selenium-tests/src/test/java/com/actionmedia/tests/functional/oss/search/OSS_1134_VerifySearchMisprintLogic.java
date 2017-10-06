package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/10/15.
 */
public class OSS_1134_VerifySearchMisprintLogic extends AbstractDomainTest {

    private static final String FIRST_QUERY_FALSE = "rjltrc";
    private static final String SECOND_QUERY_FALSE = "зокон";
    private static final String SECOND_QUERY_TRUE = "закон";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1134", testCaseVersion = "1")
    public void oss_1134_test() {
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

    public void testUSS() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Исправление опечаток Логика ЮСС КУ");
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(FIRST_QUERY_FALSE)

                .navigateToLawBasePage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(SECOND_QUERY_FALSE)

                .goBack()
                .checkSearchQuery(SECOND_QUERY_TRUE)
                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .clickFormsFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)
                .logout();
    }

    public void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Исправление опечаток Логика ФСС КУ");
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(FIRST_QUERY_FALSE)

                .navigateToLawBasePage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(SECOND_QUERY_FALSE)

                .goBack()
                .checkSearchQuery(SECOND_QUERY_TRUE)
                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .clickFormsFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)
                .logout();
    }

    public void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Исправление опечаток Логика БСС КУ");
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(FIRST_QUERY_FALSE)

                .navigateToLawBasePage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(SECOND_QUERY_FALSE)

                .goBack()
                .checkSearchQuery(SECOND_QUERY_TRUE)
                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .clickFormsFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)
                .logout();
    }

    public void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Исправление опечаток Логика КСС КУ");
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(FIRST_QUERY_FALSE)

                .navigateToLawBasePage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickNoFixLink()
                .checkSearchResultIsNotPresent()
                .checkSearchQuery(SECOND_QUERY_FALSE)

                .goBack()
                .checkSearchQuery(SECOND_QUERY_TRUE)
                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .clickFormsFilter()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}

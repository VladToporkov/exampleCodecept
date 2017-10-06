package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 01/12/15.
 */
public class OSS_1354_StatusFilterLogic extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1354", testCaseVersion = "1")
    public void oss_1354_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                test_uss();
                break;
            }
            case 1: {
                test_fss();
                break;
            }
            case 2: {
                test_bss();
                break;
            }
            case 3: {
                test_kss();
                break;
            }
        }
    }

    private void test_uss() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется фильтры По статусам (Логика) ЮСС КУ");
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilterIsPresent()
                .checkLinksStatusFilter()
                .logout();
    }

    private void test_fss() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется фильтры По статусам (Логика) ФСС КУ");
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilterIsPresent()
                .checkLinksStatusFilter()
                .logout();
    }

    private void test_bss() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется фильтры По статусам (Логика) БСС КУ");
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilterIsPresent()
                .checkLinksStatusFilter()
                .logout();
    }

    private void test_kss() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется фильтры По статусам (Логика) КСС КУ");
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkStatusFilterIsPresent()
                .checkLinksStatusFilter()
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}

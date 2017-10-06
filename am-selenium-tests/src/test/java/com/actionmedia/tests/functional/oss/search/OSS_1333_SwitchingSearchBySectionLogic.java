package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/11/15.
 */
public class OSS_1333_SwitchingSearchBySectionLogic extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1333", testCaseVersion = "1")
    public void oss_1333_test() {
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

    private void testUSS() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Переключение поиска по разделам Логика ЮСС КУ");

        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksSectionFilter()
                .logout();

    }

    private void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Переключение поиска по разделам Логика ФСС КУ");

        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksSectionFilter()
                .logout();

    }

    private void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Переключение поиска по разделам Логика БСС КУ");

        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksSectionFilter()
                .logout();

    }

    private void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Переключение поиска по разделам Логика КСС КУ");

        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkLinksSectionFilter()
                .logout();

    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
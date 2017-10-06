package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 26/10/15.
 */
public class OSS_1254_VerifySearchFormWidgetPresentLogic extends AbstractDomainTest {

    private static final String QUERY = "справка";
    private static final String QUERY_FSS = "отчет";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1254", testCaseVersion = "1")
    public void oss_1254_test() {
        switch (getNumberOfSystem()) {
            case 0: {
                testFSS();
                break;
            }
            case 1: {
                testBSS();
                break;
            }
            case 2: {
                testKSS();
                break;
            }
            case 3: {
                testUSS();
                break;
            }
        }
    }

    private void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Формы Логика БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .logout();
    }

    private void testUSS() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Формы Логика ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .logout();
    }

    private void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Формы Логика КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .logout();
    }

    private void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Формы Логика ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_FSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}
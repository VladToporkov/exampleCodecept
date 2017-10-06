package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/10/15.
 */
public class OSS_1288_WidgetHandbookPresentLogic extends AbstractDomainTest {

    private static final String QUERY = "случаи";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1288", testCaseVersion = "1")
    public void oss_1288_test() {
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

    public void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Справочников ФСС КУ Логика");

        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkClickInMainLinkInDictionaryWidget()
                .checkLinksWidgetDictionary()
                .logout();
    }

    public void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Справочников БСС КУ Логика");

        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkClickInMainLinkInDictionaryWidget()
                .checkLinksWidgetDictionary()
                .logout();
    }

    public void testUSS() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Справочников ЮСС КУ Логика");

        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkClickInMainLinkInDictionaryWidget()
                .checkLinksWidgetDictionary()
                .logout();
    }

    public void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Справочников КСС КУ Логика");

        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkClickInMainLinkInDictionaryWidget()
                .checkLinksWidgetDictionary()
                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }
}

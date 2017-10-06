package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 09/11/15.
 */
public class OSS_1303_WidgetCodesPresentLogic extends AbstractDomainTest {

    private static final String QUERY = "окоф 1";
    private static final String SECOND_QUERY = "кбк 1";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1303", testCaseVersion = "1")
    public void oss_1303_test() {
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
        report("Проверяется Колдунщик ОКОФ ЮСС КУ Логика");
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetsFull()
                .clickWidgetShowMore()
                .checkWidgetsFolder()
                .checkWidgetsLinks()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetCodesFull()
                .clickWidgetShowMore()
                .checkWidgetCodeDictionary()
                .checkWidgetCodesSourceLink()

                .logout();
    }

    public void testFSS() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик ОКОФ ФСС КУ Логика");
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetsFull()
                .clickWidgetShowMore()
                .checkWidgetsFolder()
                .checkWidgetsLinks()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetCodesFull()
                .clickWidgetShowMore()
                .checkWidgetCodeDictionary()
                .checkWidgetCodesSourceLink()

                .logout();
    }

    public void testBSS() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик ОКОФ БСС КУ Логика");
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetsFull()
                .clickWidgetShowMore()
                .checkWidgetsFolder()
                .checkWidgetlsLinks()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetCodesFull()
                .clickWidgetShowMore()
                .checkWidgetCodeDictionary()
                .checkWidgetCodesSoureLink()

                .logout();
    }

    public void testKSS() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик ОКОФ КСС КУ Логика");
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetsFull()
                .clickWidgetShowMore()
                .checkWidgetsFolder()
                .checkWidgetsLinks()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickWidgetShowMore()
                .checkWidgetCodesFull()
                .clickWidgetShowMore()
                .checkWidgetCodeDictionary()
                .checkWidgetCodesSourceLink()

                .logout();
    }

    private int getNumberOfSystem() {
        return getMultiplicityOfWeekNumber() % 4;
    }

}

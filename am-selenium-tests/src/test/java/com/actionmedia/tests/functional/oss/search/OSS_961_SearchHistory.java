package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_961_SearchHistory extends AbstractDomainTest {

    private static final String[] QUERY_LIST = new String[]{
            "налог на имущество",
            "налог на имущество декларация",
            "налоговая декларация по усн",
            "налог на имущество 2014"
    };
    private static final String QUERY_RECOMMEND = "налог";
    private static final String QUERY_TYPO_LAW = "yfkjujdsq rjltrc";
    private static final String QUERY_LAW = "налоговый кодекс";
    private static final String QUERY_FORMS = "форма т-10";
    private static final String QUERY_DICTIONARY = "календарь";
    private static final String QUERY_VIDEO = "3212313213132";
    private static final String QUERY_FOR_NOT_LOGIN = "налог на имущество";
    private static final String QUERY_SIMPLE = "1";
    private static final String VIEW = "Закон";
    private static final String REGION = "Москва";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-961", testCaseVersion = "1")
    public void oss_961_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется История поисковых запросов БСС КУ");
        bss_961_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется История поисковых запросов КСС КУ");
        kss_961_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется История поисковых запросов ЮСС КУ");
        uss_961_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется История поисковых запросов ФСС КУ");
        fss_961_test();
    }

    private void bss_961_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputSearchHistory(QUERY_LIST)
                .inputTextInSearchBox(QUERY_RECOMMEND)
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()

                .clickFirstItemFromSearchHistory()
                .checkCurrentItemIsSelected(MainMenuButtons.RECOMEND)
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_TYPO_LAW)
                .clickSearchButton()
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()
                .checkQueryIsPresentInSearchHistory(QUERY_LAW)
                .checkQueryIsNotPresentInSearchHistory(QUERY_TYPO_LAW)

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_SIMPLE)
                .inputViewInExtendedByName(VIEW)
                .selectRegionByName(REGION)
                .clickSearchExtendedButton()
                .checkQueryIsPresentInSearchHistory(QUERY_SIMPLE)

                .clickFirstItemFromSearchHistory()
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY_SIMPLE + "»")
                .checkExtendedSearchString("Вид — «" + VIEW + "», регион — «" + REGION + "»")

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_FORMS)
                .clickSearchButton()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .clickSearchButton()
                .navigateToFormsPage()
                .checkQueryIsPresentInSearchHistory(QUERY_FORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERY_DICTIONARY)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .checkQueryIsNotPresentInSearchHistory(QUERY_FORMS)

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_VIDEO)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERY_VIDEO)
                .logout();

        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY_FOR_NOT_LOGIN)
                .clickSearchButton()
                .checkSearchHistoryIsNotPresent();
    }

    private void kss_961_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputSearchHistory(QUERY_LIST)
                .inputTextInSearchBox(QUERY_RECOMMEND)
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()

                .clickFirstItemFromSearchHistory()
                .checkCurrentItemIsSelected(MainMenuButtons.ANSWERS)
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_TYPO_LAW)
                .clickSearchButton()
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()
                .checkQueryIsPresentInSearchHistory(QUERY_LAW)
                .checkQueryIsNotPresentInSearchHistory(QUERY_TYPO_LAW)

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_SIMPLE)
                .inputViewInExtendedByName(VIEW)
                .selectRegionByName(REGION)
                .clickSearchExtendedButton()
                .checkQueryIsPresentInSearchHistory(QUERY_SIMPLE)

                .clickFirstItemFromSearchHistory()
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY_SIMPLE + "»")
                .checkExtendedSearchString("Вид — «" + VIEW + "», регион — «" + REGION + "»")

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_FORMS)
                .clickSearchButton()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .clickSearchButton()
                .navigateToFormsPage()
                .checkQueryIsPresentInSearchHistory(QUERY_FORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERY_DICTIONARY)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .checkQueryIsNotPresentInSearchHistory(QUERY_FORMS)

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_VIDEO)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERY_VIDEO)
                .logout();

        enterToKssWithoutLogin()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY_FOR_NOT_LOGIN)
                .clickSearchButton()
                .checkSearchHistoryIsNotPresent();
    }

    private void uss_961_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputSearchHistory(QUERY_LIST)
                .inputTextInSearchBox(QUERY_RECOMMEND)
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()

                .clickFirstItemFromSearchHistory()
                .checkCurrentItemIsSelected(MainMenuButtons.RECOMEND)
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_TYPO_LAW)
                .clickSearchButton()
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()
                .checkQueryIsPresentInSearchHistory(QUERY_LAW)
                .checkQueryIsNotPresentInSearchHistory(QUERY_TYPO_LAW)

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_SIMPLE)
                .inputViewInExtendedByName(VIEW)
                .selectRegionByName(REGION)
                .clickSearchExtendedButton()
                .checkQueryIsPresentInSearchHistory(QUERY_SIMPLE)

                .clickFirstItemFromSearchHistory()
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY_SIMPLE + "»")
                .checkExtendedSearchString("Вид — «" + VIEW + "», регион — «" + REGION + "»")

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_FORMS)
                .clickSearchButton()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .clickSearchButton()
                .navigateToFormsPage()
                .checkQueryIsPresentInSearchHistory(QUERY_FORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERY_DICTIONARY)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .checkQueryIsNotPresentInSearchHistory(QUERY_FORMS)

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_VIDEO)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERY_VIDEO)
                .logout();

        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY_FOR_NOT_LOGIN)
                .clickSearchButton()
                .checkSearchHistoryIsNotPresent();
    }

    private void fss_961_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputSearchHistory(QUERY_LIST)
                .inputTextInSearchBox(QUERY_RECOMMEND)
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()

                .clickFirstItemFromSearchHistory()
                .checkCurrentItemIsSelected(MainMenuButtons.FSS_SOLUTIONS)
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_TYPO_LAW)
                .clickSearchButton()
                .checkSearchHistoryIsPresent()
                .checkSearchHistoryQueryCount()
                .checkSearchHistoryLayout()
                .checkQueryIsPresentInSearchHistory(QUERY_LAW)
                .checkQueryIsNotPresentInSearchHistory(QUERY_TYPO_LAW)

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_SIMPLE)
                .inputViewInExtendedByName(VIEW)
                .selectRegionByName(REGION)
                .clickSearchExtendedButton()
                .checkQueryIsPresentInSearchHistory(QUERY_SIMPLE)

                .clickFirstItemFromSearchHistory()
                .checkCurrentUrlContainsUrlFirstQueryFromSearchHistory()
                .clickSearchExtendedButton()
                .checkSearchTitle("Результаты поиска по реквизитам: «" + QUERY_SIMPLE + "»")
                .checkExtendedSearchString("Вид — «" + VIEW + "», регион — «" + REGION + "»")

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY_FORMS)
                .clickSearchButton()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .clickSearchButton()
                .navigateToFormsPage()
                .checkQueryIsPresentInSearchHistory(QUERY_FORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERY_DICTIONARY)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY_DICTIONARY)
                .checkQueryIsNotPresentInSearchHistory(QUERY_FORMS)

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY_VIDEO)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERY_VIDEO)
                .logout();

        enterToFssWithoutLogin()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_FOR_NOT_LOGIN)
                .clickSearchButton()
                .checkSearchHistoryIsNotPresent();
    }
}

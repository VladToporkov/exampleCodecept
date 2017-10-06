package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_64_SearchHistory extends AbstractDomainTest {

    private static final String[] QUERY = new String[]{"налог на имущество", "налог на имущество декларация", "налоговая декларация по усн", "налог на имущество 2014", "налоговые вычеты на детей", "налоговые регистры для расчета ндфл", "налоговая ставка по транспортному налогу", "1"};
    public static final String QUERY1 = "налог";
    public static final String QUERYFALSE = "нологовый коdекс";
    public static final String QUERYTRUE = "налоговый кодекс";
    public static final String QUERYFORMS = "форма т-10";
    public static final String QUERYDICTIONARY = "календарь";
    public static final String QUERYFALSE2 = "qwteuqteuqtetquetquet";
    public static final String QUERY7 = "налог на имущество";
    public static final String QUERYPROPS = "1";
    public static final String TYPE = "Закон";
    public static final String CITY = "Москва";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-64", testCaseVersion = "1")
    public void oss_64_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется История поисковых запросов КСС КУ");
        kss_64_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется История поисковых запросов  КСС БУ");
        kss_64_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История поисковых запросов КСС ВИП");
        kss_64_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется История поисковых запросов БСС КУ");
        bss_64_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется История поисковых запросов БСС ВИП");
        bss_64_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется История поисковых запросов БСС УПР");
        bss_64_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется История поисковых запросов БСС БУ");
        bss_64_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется История поисковых запросов ЮСС КУ");
        uss_64_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется История поисковых запросов ЮСС ДОК");
        uss_64_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется История поисковых запросов ФСС КУ");
        fss_64_test();
    }

    private void kss_64_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputSearchHistory(QUERY)
                .checkSearchHistory(true, null)

                .inputTextInSearchBox(QUERY1)
                .checkSearchHistory(false, QUERY1)

                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYTRUE)
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE)
                .checkSearchHistory(true, null)

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYPROPS)
                .checkMainSearchFilter(QUERYPROPS, TYPE, CITY)

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFORMS)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYFORMS)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYDICTIONARY)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToAnswersPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToLawBasePage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToDictionaryPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .navigateToFormsPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToVideoPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToMagazinesPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)

                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE2)
                .logout()

                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY7)
                .clickSearchButton()
                .checkNotPresentSearheQueryInHistory();
    }

    private void bss_64_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputSearchHistory(QUERY)
                .checkSearchHistory(true, null)

                .inputTextInSearchBox(QUERY1)
                .checkSearchHistory(false, QUERY1)

                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYTRUE)
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE)
                .checkSearchHistory(true, null)

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYPROPS)
                .checkMainSearchFilter(QUERYPROPS, TYPE, CITY)

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFORMS)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYFORMS)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYDICTIONARY)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToRecomendPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToLawBasePage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToDictionaryPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .navigateToFormsPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToVideoPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToMagazinesPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)

                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE2)
                .logout()

                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY7)
                .clickSearchButton()
                .navigateToRecomendPage()
                .checkNotPresentSearheQueryInHistory();
    }

    private void uss_64_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputSearchHistory(QUERY)
                .checkSearchHistory(true, null)

                .inputTextInSearchBox(QUERY1)
                .checkSearchHistory(false, QUERY1)

                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYTRUE)
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE)
                .checkSearchHistory(true, null)

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYPROPS)
                .checkMainSearchFilter(QUERYPROPS, TYPE, CITY)

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFORMS)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYFORMS)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYDICTIONARY)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToRecomendPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToLawBasePage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToDictionaryPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .navigateToFormsPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToServicesPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToVideoPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToMagazinesPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)


                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE2)
                .logout()

                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY7)
                .clickSearchButton()
                .navigateToRecomendPage()
                .checkNotPresentSearheQueryInHistory();
    }

    private void fss_64_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputSearchHistory(QUERY)
                .checkSearchHistory(true, null)

                .inputTextInSearchBox(QUERY1)
                .checkSearchHistory(false, QUERY1)

                .inputTextInSearchBox(QUERYFALSE)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYTRUE)
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE)
                .checkSearchHistory(true, null)

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYPROPS)
                .checkMainSearchFilter(QUERYPROPS, TYPE, CITY)

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFORMS)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYFORMS)
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYDICTIONARY)
                .clickSearchButton()
                .checkQueryIsPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToSolutionsPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToLawBasePage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToDictionaryPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .navigateToFormsPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToVideoPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)
                .navigateToMagazinesPage()
                .checkQueryIsNotPresentInSearchHistory(QUERYFORMS)
                .checkQueryIsNotPresentInSearchHistory(QUERYDICTIONARY)


                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFALSE2)
                .clickSearchButton()
                .checkQueryIsNotPresentInSearchHistory(QUERYFALSE2)
                .logout()

                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY7)
                .clickSearchButton()
                .navigateToSolutionsPage()
                .checkNotPresentSearheQueryInHistory();
    }

}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 13/01/16.
 */
public class OSS_390_ExtendedSearchDateFields extends AbstractDomainTest {

    private static final String QUERY = "123";
    private static final String SEARCH_EXACT_PHRASE_FROM = "Дата принятия: с ";
    private static final String SEARCH_EXACT_PHRASE_TO = "Дата принятия: по ";
    private static final String SEARCH_EXACT_PHRASE_BETWEEN = "Дата принятия: с %s по %s";

    private static final String CORRECT_DATE_FROM = "12.12.2012";
    private static final String CORRECT_DATE_TO = "13.12.2012";
    private static final String INCORRECT_DATE = "22.22.2222";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-390", testCaseVersion = "1")
    public void oss_390_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По дате КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По дате КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По дате КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По дате БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По дате БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По дате БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По дате БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По дате ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По дате ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По дате ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()

                .inputTextInStartDateField(INCORRECT_DATE)
                .inputTextInEndDateField(INCORRECT_DATE)
                .checkSearchExtendedButtonsIsDisabled()

                .clickClearFields()

                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_FROM + CORRECT_DATE_FROM)
                .checkSearchResultsDateFilterFrom(CORRECT_DATE_FROM)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_TO + CORRECT_DATE_TO)
                .checkSearchResultsDateFilterTo(CORRECT_DATE_TO)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(String.format(SEARCH_EXACT_PHRASE_BETWEEN, CORRECT_DATE_FROM, CORRECT_DATE_TO))
                .checkSearchResultsDateFilterBetween(CORRECT_DATE_FROM, CORRECT_DATE_TO)

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()

                .inputTextInStartDateField(INCORRECT_DATE)
                .inputTextInEndDateField(INCORRECT_DATE)
                .checkSearchExtendedButtonsIsDisabled()

                .clickClearFields()

                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_FROM + CORRECT_DATE_FROM)
                .checkSearchResultsDateFilterFrom(CORRECT_DATE_FROM)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_TO + CORRECT_DATE_TO)
                .checkSearchResultsDateFilterTo(CORRECT_DATE_TO)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(String.format(SEARCH_EXACT_PHRASE_BETWEEN, CORRECT_DATE_FROM, CORRECT_DATE_TO))
                .checkSearchResultsDateFilterBetween(CORRECT_DATE_FROM, CORRECT_DATE_TO)

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()

                .inputTextInStartDateField(INCORRECT_DATE)
                .inputTextInEndDateField(INCORRECT_DATE)
                .checkSearchExtendedButtonsIsDisabled()

                .clickClearFields()

                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_FROM + CORRECT_DATE_FROM)
                .checkSearchResultsDateFilterFrom(CORRECT_DATE_FROM)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_TO + CORRECT_DATE_TO)
                .checkSearchResultsDateFilterTo(CORRECT_DATE_TO)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(String.format(SEARCH_EXACT_PHRASE_BETWEEN, CORRECT_DATE_FROM, CORRECT_DATE_TO))
                .checkSearchResultsDateFilterBetween(CORRECT_DATE_FROM, CORRECT_DATE_TO)

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()

                .inputTextInStartDateField(INCORRECT_DATE)
                .inputTextInEndDateField(INCORRECT_DATE)
                .checkSearchExtendedButtonsIsDisabled()

                .clickClearFields()

                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_FROM + CORRECT_DATE_FROM)
                .checkSearchResultsDateFilterFrom(CORRECT_DATE_FROM)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE_TO + CORRECT_DATE_TO)
                .checkSearchResultsDateFilterTo(CORRECT_DATE_TO)

                .clickExtendedButtonInSearchBox()
                .clickClearFields()
                .inputTextInStartDateField(CORRECT_DATE_FROM)
                .inputTextInEndDateField(CORRECT_DATE_TO)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(String.format(SEARCH_EXACT_PHRASE_BETWEEN, CORRECT_DATE_FROM, CORRECT_DATE_TO))
                .checkSearchResultsDateFilterBetween(CORRECT_DATE_FROM, CORRECT_DATE_TO)

                .logout();
    }
}

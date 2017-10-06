package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 14/12/15.
 */
public class OSS_2_ExtendedSearchExactPhrase extends AbstractDomainTest {

    private static final String QUERY = "123";
    private static final String QUERY_STEP3 = "о рассмотрении проекта федерального закона";
    private static final String QUERY_STEP5 = "о россмотрении праэкта фидирального зокона";

    private static final String SEARCH_EXACT_PHRASE = "Поиск точной фразы";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2", testCaseVersion = "1")
    public void oss_2_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам)  КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) ЮСС ВИП");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-2:Поисковые фильтры Только точную фразу (Поиск по реквизитам) ФСС КУ");
        fss_test();
    }

    public void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkExactPhraseIsNotActivated()
                .checkExactPhraseIsNotChecked()

                .inputTextInSearchBox(QUERY)
                .checkExactPhraseIsNotChecked()
                .checkExactPhraseIsActivated()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP5)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")
                .checkTypoWasFixed(QUERY_STEP5, QUERY_STEP3)

                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .logout();
    }

    public void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkExactPhraseIsNotActivated()
                .checkExactPhraseIsNotChecked()

                .inputTextInSearchBox(QUERY)
                .checkExactPhraseIsNotChecked()
                .checkExactPhraseIsActivated()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP5)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")
                .checkTypoWasFixed(QUERY_STEP5, QUERY_STEP3)

                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .logout();
    }

    public void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkExactPhraseIsNotActivated()
                .checkExactPhraseIsNotChecked()

                .inputTextInSearchBox(QUERY)
                .checkExactPhraseIsNotChecked()
                .checkExactPhraseIsActivated()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP5)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")
                .checkTypoWasFixed(QUERY_STEP5, QUERY_STEP3)

                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .logout();
    }

    public void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkExactPhraseIsNotActivated()
                .checkExactPhraseIsNotChecked()

                .inputTextInSearchBox(QUERY)
                .checkExactPhraseIsNotChecked()
                .checkExactPhraseIsActivated()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP5)
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickSearchExtendedButton()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")
                .checkTypoWasFixed(QUERY_STEP5, QUERY_STEP3)

                .clickDateSortedFilter()
                .clickActualStatusInFilter()
                .checkExtendedSearchString(SEARCH_EXACT_PHRASE)
                .checkCurrentUrlContainsText("exact=yes")

                .logout();
    }
}

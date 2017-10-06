package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/01/16.
 */
public class OSS_323_ExtendedSearchOnlyInTitles extends AbstractDomainTest {

    private static final String QUERY = "123";
    private static final String QUERY_STEP3 = "о рассмотрении проекта федерального закона";

    private static final String SEARCH_EXACT_PHRASE = "Вы искали только в заголовке документов.";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-323", testCaseVersion = "2")
    public void oss_323_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.expert");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.expert");
        updateLoginToInfo("budget");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам)  КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.expert");
        updateLoginToInfo("vip");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.expert");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("vip");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("usn");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.expert");
        updateLoginToInfo("budget");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.expert");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.expert");
        updateLoginToInfo("doc");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) ЮСС ВИП");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.expert");
        report("Проверяется OSS-323:Поисковые фильтры Только в заголовках (Поиск по реквизитам) ФСС КУ");
        fss_test();
    }

    public void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY)
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkOnlyInTitlesCheckBoxIsEnabled()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()
                .checkSearchResultsForExpersHasDifferentAbbr()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .selectOnlyInTitlesCheckBox()
                .clickSearchExtendedButton()
                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE)
                .checkSearchResultsForExpersHasOneAbbr()

                .logout();
    }

    public void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY)
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkOnlyInTitlesCheckBoxIsEnabled()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()
                .checkSearchResultsForExpersHasDifferentAbbr()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .selectOnlyInTitlesCheckBox()
                .clickSearchExtendedButton()
                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE)
                .checkSearchResultsForExpersHasOneAbbr()

                .logout();
    }

    public void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY)
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkOnlyInTitlesCheckBoxIsEnabled()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()
                .checkSearchResultsForExpersHasDifferentAbbr()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .selectOnlyInTitlesCheckBox()
                .clickSearchExtendedButton()
                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE)
                .checkSearchResultsForExpersHasOneAbbr()

                .logout();
    }

    public void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkOnlyInTitlesCheckBoxIsDisabled()
                .checkOnlyInTitlesCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY)
                .checkOnlyInTitlesCheckBoxIsNotSelected()
                .checkOnlyInTitlesCheckBoxIsEnabled()

                .inputTextInSearchBox(QUERY_STEP3)
                .clickSearchExtendedButton()
                .checkSearchResultOnLawBasePageIsOpened()
                .checkSearchResultsForExpersHasDifferentAbbr()

                .clickExtendedButtonInSearchBox()
                .inputTextInSearchBox(QUERY_STEP3)
                .selectOnlyInTitlesCheckBox()
                .clickSearchExtendedButton()
                .checkExtendedSearchStringContains(SEARCH_EXACT_PHRASE)
                .checkSearchResultsForExpersHasOneAbbr()

                .logout();
    }
}

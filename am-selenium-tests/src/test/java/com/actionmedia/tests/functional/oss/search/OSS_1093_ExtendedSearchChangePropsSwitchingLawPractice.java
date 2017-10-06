package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/11/15.
 */
public class OSS_1093_ExtendedSearchChangePropsSwitchingLawPractice extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1093", testCaseVersion = "1")
    public void oss_1093_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Сортировка Правовая база БСС КУ");
        testBss();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Сортировка Правовая база КСС КУ");
        testKss();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Сортировка Правовая база ЮСС КУ");
        testUss();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Сортировка Правовая база ФСС КУ");
        testFss();
    }

    private void testBss() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox("123")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilter()
                .checkExtendedSearchRemoveAllFilters()
                .checkCurrentUrlContainsText("tags=421")

                .navigateToLawBasePage()
                .inputTextInSearchBox("комитет государственных закупок")
                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .setExtended("Решение", "Заключение договоров", "Арбитражный суд Мурманской области")
                .clickOnButtonSearchOnExtendedForm()
                .switchToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .switchOnInLawOnExtendedSearchForm()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickOnButtonSearchOnExtendedForm()
                .checkExtendedSearchRemoveAllFilters()
                .checkStatusFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox("")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult()
                .checkMainLawBasePageIsOpened()
                .logout();
    }

    private void testKss() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox("123")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilter()
                .checkExtendedSearchRemoveAllFilters()

                .navigateToLawBasePage()
                .inputTextInSearchBox("комитет государственных закупок")
                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .setExtended("Решение", "Заключение договоров", "Арбитражный суд Мурманской области")
                .clickOnButtonSearchOnExtendedForm()
                .switchToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .switchOnInLawOnExtendedSearchForm()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickOnButtonSearchOnExtendedForm()
                .checkExtendedSearchRemoveAllFilters()
                .checkStatusFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox("")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult()
                .checkMainLawBasePageIsOpened()
                .logout();
    }

    private void testUss() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox("123")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilter()
                .checkExtendedSearchRemoveAllFilters()

                .navigateToLawBasePage()
                .inputTextInSearchBox("комитет государственных закупок")
                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .setExtended("Решение", "Заключение договоров", "Арбитражный суд Мурманской области")
                .clickOnButtonSearchOnExtendedForm()
                .switchToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .switchOnInLawOnExtendedSearchForm()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickOnButtonSearchOnExtendedForm()
                .checkExtendedSearchRemoveAllFilters()
                .checkStatusFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox("")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilterAndDoNotWaitSearchResult()
                .checkMainLawPracticePageIsOpened()

                .navigateToLawPracticePage()
                .switchToLawBasePage()
                .inputTextInSearchBox("")
                .clickExtendedButtonInSearchBox()
                .setExtended("Постановление", "Верховный суд РФ", null)
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawBaseLinkFilterAndDoNotWaitSearchResult()
                .checkMainLawBasePageIsOpened()
                .logout();
    }

    private void testFss() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox("123")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnExactPhraseOnExtendedSearchForm()
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilter()
                .checkExtendedSearchRemoveAllFilters()
                .checkCurrentUrlContainsText("tags=421")

                .navigateToLawBasePage()
                .inputTextInSearchBox("комитет государственных закупок")
                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .setExtended("Решение", "Заключение договоров", "Арбитражный суд Мурманской области")
                .clickOnButtonSearchOnExtendedForm()
                .switchToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .switchOnInLawOnExtendedSearchForm()
                .checkResultTextFiltersOnExtendedFormIsNotVisible()

                .clickOnButtonSearchOnExtendedForm()
                .checkExtendedSearchRemoveAllFilters()
                .checkStatusFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox("")
                .clickExtendedButtonInSearchBox()
                .setExtended("Закон, Постановление", null, "Москва")
                .clickOnButtonSearchOnExtendedForm()
                .clickInLawPracticeLinkFilterAndDoNotWaitingSearchResult()
                .checkMainLawBasePageIsOpened()
                .logout();
    }
}

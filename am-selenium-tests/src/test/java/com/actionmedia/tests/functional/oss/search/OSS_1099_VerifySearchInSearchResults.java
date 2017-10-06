package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_1099_VerifySearchInSearchResults extends AbstractDomainTest {

    private static final String STATUS_FILTER_NAME = "Утратившие силу";
    private static final String FIRST_QUERY = "закон";
    private static final String SECOND_QUERY = "налог";
    private static final String THIRD_QUERY = "постановление";
    private static final String EMPTY_QUERY = "";
    private static final String TYPE = "Закон";
    private static final String CITY = "Москва";
    private static final String FOURTH_QUERY = "О внесение изменений в закон";
    private static final String TYPE_DOCUMENT_FILTER_NAME = "Региональные";
    private static final String SORTED_FILTER_NAME = "По дате";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1099", testCaseVersion = "1")
    public void oss_1099_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Поиск в найденном. Логика. БСС");
        bss_1099();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Поиск в найденном. Логика. КСС");
        kss_1099();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Поиск в найденном. Логика. ЮСС");
        uss_1099();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Поиск в найденном. Логика. ФСС");
        fss_1099();
    }

    private void bss_1099() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(THIRD_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY, THIRD_QUERY)
                .checkSortedFilter(SORTED_FILTER_NAME)
                .checkTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .checkStatusFilter(STATUS_FILTER_NAME)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(EMPTY_QUERY)
                .clickSearchButton()
                .inputTextInSearchBox(FOURTH_QUERY)
                .clickSearchInResultCheckBox()
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkExtendedSearch(TYPE, CITY, FOURTH_QUERY)

                .clickInLawPracticeLinkFilter()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .logout();
    }

    private void kss_1099() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(THIRD_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY, THIRD_QUERY)
                .checkSortedFilter(SORTED_FILTER_NAME)
                .checkTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .checkStatusFilter(STATUS_FILTER_NAME)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(EMPTY_QUERY)
                .clickSearchButton()
                .inputTextInSearchBox(FOURTH_QUERY)
                .clickSearchInResultCheckBox()
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkExtendedSearch(TYPE, CITY, FOURTH_QUERY)

                .clickInLawPracticeLinkFilter()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .logout();
    }

    private void uss_1099() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(THIRD_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY, THIRD_QUERY)
                .checkSortedFilter(SORTED_FILTER_NAME)
                .checkTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .checkStatusFilter(STATUS_FILTER_NAME)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(EMPTY_QUERY)
                .clickSearchButton()
                .inputTextInSearchBox(FOURTH_QUERY)
                .clickSearchInResultCheckBox()
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkExtendedSearch(TYPE, CITY, FOURTH_QUERY)

                .clickInLawPracticeLinkFilter()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .logout();
    }

    private void fss_1099() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .clickNotActiveStatus()
                .clickDateFilter()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(THIRD_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY, THIRD_QUERY)
                .checkSortedFilter(SORTED_FILTER_NAME)
                .checkTypeDocumentFilter(TYPE_DOCUMENT_FILTER_NAME)
                .checkStatusFilter(STATUS_FILTER_NAME)
                .checkHighlightingRequest()

                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, CITY)
                .clickOnButtonSearchOnExtendedForm()
                .inputTextInSearchBox(EMPTY_QUERY)
                .clickSearchButton()
                .inputTextInSearchBox(FOURTH_QUERY)
                .clickSearchInResultCheckBox()
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkExtendedSearch(TYPE, CITY, FOURTH_QUERY)

                .clickInLawPracticeLinkFilter()
                .inputTextInSearchBox(FIRST_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickSearchInResultCheckBox()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchInResultCheckBoxIsPresent()
                .checkSearchInResultCheckboxIsNoSelected()
                .checkPresentSearchResultText(FIRST_QUERY, SECOND_QUERY)
                .checkHighlightingRequest()

                .logout();
    }
}

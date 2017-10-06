package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/12/15.
 */
public class OSS_389_ExtendedSearchByDocumentNumber extends AbstractDomainTest {

    private static final String DOC_NUMBER = "118-ФЗ";
    private static final String DOC_NUMBER_STEP_2 = "382";
    private static final String DOC_NUMBER_STEP_3 = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-389", testCaseVersion = "2")
    public void oss_389_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам)  КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По № (Поиск по реквизитам) ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(DOC_NUMBER)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(DOC_NUMBER)
                .checkSearchResultsHeadersContainDocumentNumber(DOC_NUMBER)

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase()
                .goBack()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListNavigation()

                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_3)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice()

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(DOC_NUMBER)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(DOC_NUMBER)
                .checkSearchResultsHeadersContainDocumentNumber(DOC_NUMBER)

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase()
                .goBack()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListNavigation()

                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_3)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice()

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(DOC_NUMBER)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(DOC_NUMBER)
                .checkSearchResultsHeadersContainDocumentNumber(DOC_NUMBER)

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase()
                .goBack()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListNavigation()

                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_3)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .inputTextInNumberField(DOC_NUMBER)
                .clickOnButtonSearchOnExtendedForm()

                .checkExtendedSearchStringContains(DOC_NUMBER)
                .checkSearchResultsHeadersContainDocumentNumber(DOC_NUMBER)

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawBase()
                .goBack()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListNavigation()

                .clickExtendedButtonInSearchBox()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_2)
                .checkExtendedSearchAdviceList(DOC_NUMBER_STEP_2)
                .checkSearchAdviceListByDocumentsCountOnExtendedSearchForm()

                .clickExtendedButtonInSearchBox()
                .inputTextInNumberFieldWithoutCloseTheAdviceList(DOC_NUMBER_STEP_3)
                .checkSearchAdviceListByDocumentNameOnExtendedSearchFormLawPractice()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 03.03.2015
 */
public class OSS_322_OverallDisplaySearchResultNoneFoundDetails extends AbstractDomainTest {

    private static final String QUERY = "qweqrqrqrqrqwerwrwq";
    private static final String TYPE = "Постановление";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-322", testCaseVersion = "2")
    public void oss_322_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) КСС КУ");
        kss_322_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам)  КСС БУ");
        kss_322_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) КСС ВИП");
        kss_322_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) БСС КУ");
        bss_322_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) БСС ВИП");
        bss_322_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) БСС УПР");
        bss_322_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) БСС БУ");
        bss_322_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) ЮСС КУ");
        uss_322_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) ЮСС ДОК");
        uss_322_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Поиск по реквизитам) ФСС КУ");
        fss_322_test();
    }

    private void kss_322_test() {
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkDisplayLawSectionFilter()

                .logout()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(false)
                .checkNotPresentFormsDocumentHouse()
                .checkDisplayLawSectionFilter();
    }

    private void bss_322_test() {
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkDisplayLawSectionFilter()

                .logout()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(false)
                .checkNotPresentFormsDocumentHouse()
                .checkDisplayLawSectionFilter();
    }

    private void uss_322_test() {
        enterToUssWithoutLogin()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkDisplayLawSectionFilter()

                .logout()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(false)
                .checkNotPresentFormsDocumentHouse()
                .checkDisplayLawSectionFilter();
    }

    private void fss_322_test() {
        enterToFssWithoutLogin()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(true)
                .checkPresentFormsDocumentForHour()
                .checkDisplayLawSectionFilter()

                .logout()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, null)
                .clickOnButtonSearchOnExtendedForm()
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)
                .checkDisplayingText(false)
                .checkNotPresentFormsDocumentHouse()
                .checkDisplayLawSectionFilter();
    }
}

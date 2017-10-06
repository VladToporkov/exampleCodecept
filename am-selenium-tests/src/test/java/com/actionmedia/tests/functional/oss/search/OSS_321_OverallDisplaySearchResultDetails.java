package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 03.03.2015
 */
public class OSS_321_OverallDisplaySearchResultDetails extends AbstractDomainTest {

    private static final String QUERY = "123";
    private static final String TYPE = "Постановление";
    private static final String REGION = "Москва";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-321", testCaseVersion = "3")
    public void oss_321_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) КСС КУ");
        kss_321_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам)  КСС БУ");
        kss_321_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) КСС ВИП");
        kss_321_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) БСС КУ");
        bss_321_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) БСС ВИП");
        bss_321_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) БСС УПР");
        bss_321_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) БСС БУ");
        bss_321_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) ЮСС КУ");
        uss_321_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) ЮСС ДОК");
        uss_321_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Поиск по реквизитам) ФСС КУ");
        fss_321_test();
    }

    private void kss_321_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, REGION)
                .clickOnButtonSearchOnExtendedForm()

                .checkSearchResultOnLawBasePageIsOpened(false)
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)

                .checkHighlightingRequest()

                .checkSearchInResultCheckBoxIsPresent()
                .logout();
    }

    private void bss_321_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, REGION)
                .clickOnButtonSearchOnExtendedForm()

                .checkSearchResultOnLawBasePageIsOpened(false)
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)

                .checkHighlightingRequest()

                .checkSearchInResultCheckBoxIsPresent()
                .logout();
    }

    private void uss_321_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, REGION)
                .clickOnButtonSearchOnExtendedForm()

                .checkSearchResultOnLawBasePageIsOpened(false)
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)

                .checkHighlightingRequest()

                .checkSearchInResultCheckBoxIsPresent()
                .logout();
    }

    private void fss_321_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickExtendedButtonInSearchBox()
                .setExtended(TYPE, null, REGION)
                .clickOnButtonSearchOnExtendedForm()

                .checkSearchResultOnLawBasePageIsOpened(false)
                .checkDisplaySearchResultsForDetails(QUERY)
                .checkDisplayingSelectedTypeFilters(TYPE)

                .checkHighlightingRequest()

                .checkSearchInResultCheckBoxIsPresent()
                .logout();
    }
}

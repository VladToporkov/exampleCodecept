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
public class OSS_382_DocumentTypeFilter extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-382", testCaseVersion = "1")
    public void oss_382_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По типу документов (Правовая база) ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypeDocumentFilter("Все документы")
                .checkDepartmentFilter()
                .checkTypeDocumentFilters()

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypeDocumentFilter("Все документы")
                .checkDepartmentFilter()
                .checkTypeDocumentFilters()

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypeDocumentFilter("Все документы")
                .checkDepartmentFilter()
                .checkTypeDocumentFilters()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTypeDocumentFilter("Все документы")
                .checkDepartmentFilter()
                .checkTypeDocumentFilters()

                .logout();
    }
}

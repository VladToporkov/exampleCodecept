package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 03.02.2015.
 */
public class OSS_48_VerifyOpenDocumentSearchResult extends AbstractDomainTest {

    private static final String QUERY = "кодекс";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-48", testCaseVersion = "1")
    public void oss_48_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Подсветка поискового запроса в документе КСС КУ");
        kss_48_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Подсветка поискового запроса в документе  КСС БУ");
        kss_48_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Подсветка поискового запроса в документе КСС ВИП");
        kss_48_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Подсветка поискового запроса в документе БСС КУ");
        bss_48_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Подсветка поискового запроса в документе БСС ВИП");
        bss_48_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Подсветка поискового запроса в документе БСС УПР");
        bss_48_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Подсветка поискового запроса в документе БСС БУ");
        bss_48_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Подсветка поискового запроса в документе ЮСС КУ");
        uss_48_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Подсветка поискового запроса в документе ЮСС ДОК");
        uss_48_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Подсветка поискового запроса в документе ФСС КУ");
        fss_48_test();
    }

    private void kss_48_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkOpenDocument(QUERY)
                .navigateToLawBasePage()
                .checkOpenDocument(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkOpenDocument(QUERY)
                .navigateToMagazinesPage()
                .checkOpenDocument(QUERY)
                .logout();
    }

    private void bss_48_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkOpenDocument(QUERY)
                .navigateToLawBasePage()
                .checkOpenDocument(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkOpenDocument(QUERY)
                .navigateToMagazinesPage()
                .checkOpenDocument(QUERY)
                .logout();
    }

    private void uss_48_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkOpenDocument(QUERY)
                .navigateToLawBasePage()
                .checkOpenDocument(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkOpenDocument(QUERY)
                .navigateToMagazinesPage()
                .checkOpenDocument(QUERY)
                .logout();
    }

    private void fss_48_test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkOpenDocument(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToLawBasePage()
                .checkOpenDocument(QUERY)
                .navigateToDictionaryPage()
                .checkOpenDocument(QUERY)
                .navigateToMagazinesPage()
                .checkOpenDocument(QUERY)
                .logout();
    }
}
package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 03.02.2015.
 */
public class OSS_338_VerifyHighlightingRequest extends AbstractDomainTest {

    private static final String QUERY = "Ограничения на трудоустройство";
    private static final String QUERYFSS = "трудоустройство";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-338", testCaseVersion = "1")
    public void oss_338_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Подсветка запроса КСС КУ");
        kss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Подсветка запроса  КСС БУ");
        kss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Подсветка запроса КСС ВИП");
        kss_338_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Подсветка запроса БСС КУ");
        bss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("vip");
        report("Проверяется Подсветка запроса БСС ВИП");
        bss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("usn");
        report("Проверяется Подсветка запроса БСС УПР");
        bss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("budget");
        report("Проверяется Подсветка запроса БСС БУ");
        bss_338_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Подсветка запроса ЮСС КУ");
        uss_338_test();

        updateLoginAsInfo("user.expert");
        updateLoginToInfo("doc");
        report("Проверяется Подсветка запроса ЮСС ДОК");
        uss_338_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("user.expert");
        report("Проверяется Подсветка запроса ФСС КУ");
        fss_338_test();
    }

    private void kss_338_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkHighlightingRequest(QUERY)
                .navigateToLawBasePage()
                .checkHighlightingRequest(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkHighlightingRequest(QUERY)
                .navigateToMagazinesPage()
                .checkHighlightingRequest(QUERY)
                .logout();
    }

    private void bss_338_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkHighlightingRequest(QUERY)
                .navigateToLawBasePage()
                .checkHighlightingRequest(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkHighlightingRequest(QUERY)
                .navigateToMagazinesPage()
                .checkHighlightingRequest(QUERY)
                .logout();
    }

    private void uss_338_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkHighlightingRequest(QUERY)
                .navigateToLawBasePage()
                .checkHighlightingRequest(QUERY)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERY)
                .navigateToDictionaryPage()
                .checkHighlightingRequest(QUERY)
                .navigateToMagazinesPage()
                .checkHighlightingRequest(QUERY)
                .logout();
    }

    private void fss_338_test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkHighlightingRequest(QUERYFSS)
                .navigateToLawBasePage()
                .checkHighlightingRequest(QUERYFSS)
                .navigateToFormsPage()
                .checkOpenDocumentNotCheckHighlightingWordDocument(QUERYFSS)
                .navigateToDictionaryPage()
                .checkHighlightingRequest(QUERYFSS)
                .navigateToMagazinesPage()
                .checkHighlightingRequest(QUERYFSS)
                .logout();
    }
}
package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1264_WidgetMagazinesPresent extends AbstractDomainTest {

    private static final String QUERY = "книги";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1264", testCaseVersion = "1")
    public void oss_1264_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг БСС КУ");
        bss_1264_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг КСС КУ");
        kss_1264_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ЮСС КУ");
        uss_1264_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ФСС КУ");
        fss_1264_test();
    }

    private void kss_1264_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()
                .logout();
    }

    private void bss_1264_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()
                .logout();
    }

    private void uss_1264_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()
                .logout();
    }

    private void fss_1264_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()
                .logout();
    }
}

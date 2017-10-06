package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_1247_WidgetLawPagePresent extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1247", testCaseVersion = "1")
    public void oss_1247_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Правовая база БСС КУ");
        bss_1247_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Правовая база КСС КУ");
        kss_1247_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Правовая база ЮСС КУ");
        uss_1247_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Правовая база ФСС КУ");
        fss_1247_test();
    }

    private void bss_1247_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .checkClickInMainLinkInLawWidget()
                .checkLinksWidgetLawPage()
                .logout();
    }

    private void kss_1247_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .checkClickInMainLinkInLawWidget()
                .checkLinksWidgetLawPage()
                .logout();
    }

    private void uss_1247_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .checkClickInMainLinkInLawWidget()
                .checkLinksWidgetLawPage()
                .logout();
    }

    private void fss_1247_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetLawPresent()
                .checkClickInMainLinkInLawWidget()
                .checkLinksWidgetLawPage()
                .logout();
    }
}

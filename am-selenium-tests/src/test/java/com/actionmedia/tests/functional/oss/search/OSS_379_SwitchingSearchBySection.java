package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;


public class OSS_379_SwitchingSearchBySection extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-379", testCaseVersion = "1")
    public void oss_379_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Переключение поиска по разделам КСС КУ");
        kss_379_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Переключение поиска по разделам  КСС БУ");
        kss_379_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Переключение поиска по разделам КСС ВИП");
        kss_379_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Переключение поиска по разделам БСС КУ");
        bss_379_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Переключение поиска по разделам БСС ВИП");
        bss_379_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Переключение поиска по разделам БСС УПР");
        bss_379_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Переключение поиска по разделам БСС БУ");
        bss_379_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Переключение поиска по разделам ЮСС КУ");
        uss_379_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Переключение поиска по разделам ЮСС ДОК");
        uss_379_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Переключение поиска по разделам ФСС КУ");
        fss_379_test();
    }

    private void kss_379_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilterIsPresent()
                .checkLinksSectionFilter()

                .logout();
    }

    private void bss_379_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter()
                .checkLinksSectionFilter()

                .logout();
    }

    private void uss_379_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter()
                .checkLinksSectionFilter()

                .logout();
    }

    private void fss_379_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter()
                .checkLinksSectionFilter()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 17/12/15.
 */
public class OSS_1082_JudicialActsFilter extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1082", testCaseVersion = "2")
    public void oss_1082_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) КСС КУ");
        kss_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) КСС БУ");
        kss_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) КСС ВИП");
        kss_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) БСС КУ");
        bss_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) БСС ВИП");
        bss_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) БСС УПР");
        bss_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) БСС БУ");
        bss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) ЮСС КУ");
        uss_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) ЮСС ДОК");
        uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Поисковые фильтры По судебным актам (Судебная практика) ФСС КУ");
        fss_test();
    }

    private void kss_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkJudicialActsFilter()
                .checkLinksJudicialActsFilter()

                .logout();
    }

    private void bss_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkJudicialActsFilter()
                .checkLinksJudicialActsFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkCurrentUrlContainsText("tags=421")

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickOnButtonSearchOnExtendedForm()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .selectRandomLobby()
                .clickSearchExtendedButton()
                .checkCurrentUrlContainsText("tags=421")

                .logout();
    }

    private void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkJudicialActsFilter()
                .checkLinksJudicialActsFilter()

                .logout();
    }

    private void fss_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkJudicialActsFilter()
                .checkLinksJudicialActsFilter()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .clickInLawPracticeLinkFilter()
                .checkCurrentUrlContainsText("tags=421")

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickOnButtonSearchOnExtendedForm()
                .switchOnInLawPracticeOnExtendedSearchForm()
                .selectRandomLobby()
                .clickSearchExtendedButton()
                .checkCurrentUrlContainsText("tags=421")

                .logout();
    }
}

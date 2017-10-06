package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_378_WidgetVideoPresent extends AbstractDomainTest {

    private static final String QUERY = "случаи";
    private static final String QUERYBSS = "договор";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-378", testCaseVersion = "1")
    public void oss_378_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик видео КСС КУ");
        kss_378_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик видео  КСС БУ");
        kss_378_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик видео КСС ВИП");
        kss_378_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик видео БСС КУ");
        bss_378_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик видео БСС ВИП");
        bss_378_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик видео БСС УПР");
        bss_378_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик видео БСС БУ");
        bss_378_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик видео ЮСС КУ");
        uss_378_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик видео ЮСС ДОК");
        uss_378_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик видео ФСС КУ");
        fss_378_test();
    }

    private void kss_378_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()
                .checkClickInMainLinkInWidgetVideo()
                .checkLinksWidgetVideo()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .logout();
    }

    private void bss_378_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()
                .checkClickInMainLinkInWidgetVideo()
                .checkLinksWidgetVideo()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .logout();
    }

    private void uss_378_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()
                .checkClickInMainLinkInWidgetVideo()
                .checkLinksWidgetVideo()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .logout();
    }

    private void fss_378_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()
                .checkClickInMainLinkInWidgetVideo()
                .checkLinksWidgetVideo()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent()

                .logout();
    }
}

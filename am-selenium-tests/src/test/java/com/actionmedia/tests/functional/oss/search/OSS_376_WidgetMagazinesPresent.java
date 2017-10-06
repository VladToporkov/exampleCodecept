package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_376_WidgetMagazinesPresent extends AbstractDomainTest {

    private static final String QUERY = "книги";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-376", testCaseVersion = "1")
    public void oss_376_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг КСС КУ");
        kss_376_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Журналов и книг  КСС БУ");
        kss_376_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Журналов и книг КСС ВИП");
        kss_376_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг БСС КУ");
        bss_376_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Журналов и книг БСС ВИП");
        bss_376_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик Журналов и книг БСС УПР");
        bss_376_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Журналов и книг БСС БУ");
        bss_376_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ЮСС КУ");
        uss_376_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик Журналов и книг ЮСС ДОК");
        uss_376_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Журналов и книг ФСС КУ");
        fss_376_test();
    }

    private void kss_376_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()


                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .logout();
    }

    private void bss_376_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .logout();
    }

    private void uss_376_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .logout();
    }

    private void fss_376_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetMagazinesPresent()
                .checkClickInMainLinkInMagazinesWidget()
                .checkLinksWidgetMagazines()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkMagazinesSearchWidgetIsNotPresent()

                .logout();
    }
}

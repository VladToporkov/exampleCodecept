package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_375_WidgetFormPresent extends AbstractDomainTest {

    private static final String QUERY = "справка";
    private static final String QUERYFSS = "отчет";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-375", testCaseVersion = "1")
    public void oss_375_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Формы КСС КУ");
        kss_375_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Формы  КСС БУ");
        kss_375_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Формы КСС ВИП");
        kss_375_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Формы БСС КУ");
        bss_375_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Формы БСС ВИП");
        bss_375_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик Формы БСС УПР");
        bss_375_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Формы БСС БУ");
        bss_375_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Формы ЮСС КУ");
        uss_375_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик Формы ЮСС ДОК");
        uss_375_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Формы ФСС КУ");
        fss_375_test();
    }

    private void kss_375_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()
                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .logout();
    }

    private void bss_375_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()
                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .logout();
    }

    private void uss_375_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()
                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .logout();
    }

    private void fss_375_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()
                .checkClickInMainLinkInFormsWidget()
                .checkLinksWidgetForms()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()

                .logout();
    }
}

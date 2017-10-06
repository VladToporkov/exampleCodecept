package com.actionmedia.tests.services.searchwidgettype;

import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

public class BSS_WidgetTypeSearch extends SearchWidgetBaseTest {

    @Test
    public void bss_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        check_bss();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        check_bss();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        check_bss();

        updateSystemInfo(SystemPubs.bss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        check_bss();
    }

    private void check_bss() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(KODY_QUERY_1)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkKodySearchWidgetIsPresent()
                .checkKodySearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(KODY_QUERY_2)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkKodySearchWidgetIsPresent()
                .checkKodySearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(KODY_QUERY_3)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkKodySearchWidgetIsPresent()
                .checkKodySearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(DICTIONARY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkDictionarySearchWidgetIsPresent()
                .checkDictionarySearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(LAW_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkLawSearchWidgetIsPresent()
                .checkLawSearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(MAGAZINES_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkMagazinesSearchWidgetIsPresent()
                .checkMagazinesSearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox(FORMS_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkFormsSearchWidgetIsPresent()
                .checkFormsSearchWidgetIsNotEmpty()

                .navigateToRecomendPage()
                .inputTextInSearchBox("новые 2-ндфл и 6-ндфл")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkVideoSearchWidgetIsPresent()
                .checkVideoSearchWidgetIsNotEmpty()

                .logout();
    }
}

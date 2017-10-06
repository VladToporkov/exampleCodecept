package com.actionmedia.tests.services.searchwidgettype;

import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

public class FSS_WidgetTypeSearch extends SearchWidgetBaseTest {

    @Test
    public void fss_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        check_fss();
    }

    private void check_fss() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(DICTIONARY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkDictionarySearchWidgetIsPresent()
                .checkDictionarySearchWidgetIsNotEmpty()

                .navigateToSolutionsPage()
                .inputTextInSearchBox(LAW_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkLawSearchWidgetIsPresent()
                .checkLawSearchWidgetIsNotEmpty()

                .navigateToSolutionsPage()
                .inputTextInSearchBox(MAGAZINES_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkMagazinesSearchWidgetIsPresent()
                .checkMagazinesSearchWidgetIsNotEmpty()

                .navigateToSolutionsPage()
                .inputTextInSearchBox("положение об управленческой отчетности компании «альфа»")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkFormsSearchWidgetIsPresent()
                .checkFormsSearchWidgetIsNotEmpty()

                .navigateToSolutionsPage()
                .inputTextInSearchBox("банкротство и ликвидация компании")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkVideoSearchWidgetIsPresent()
                .checkVideoSearchWidgetIsNotEmpty()

                .logout();
    }
}

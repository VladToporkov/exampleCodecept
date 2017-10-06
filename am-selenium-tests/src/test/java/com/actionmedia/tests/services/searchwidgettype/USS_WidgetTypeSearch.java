package com.actionmedia.tests.services.searchwidgettype;

import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

public class USS_WidgetTypeSearch extends SearchWidgetBaseTest {

    @Test
    public void uss_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        check_uss();
    }

    private void check_uss() {
        loginUss()
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
                .inputTextInSearchBox("ооо-2016: что изменилось и какие сложности появились на практике")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkVideoSearchWidgetIsPresent()
                .checkVideoSearchWidgetIsNotEmpty()

                .logout();
    }
}

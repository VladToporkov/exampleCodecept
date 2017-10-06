package com.actionmedia.tests.services.searchwidgettype;

import com.actionmedia.autotest.utils.SystemPubs;
import org.testng.annotations.Test;

public class KSS_WidgetTypeSearch extends SearchWidgetBaseTest {

    @Test
    public void kss_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        check_kss();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        check_kss();

        updateSystemInfo(SystemPubs.kss);
        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        check_kss();
    }

    private void check_kss() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(DICTIONARY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkDictionarySearchWidgetIsPresent()
                .checkDictionarySearchWidgetIsNotEmpty()

                .navigateToAnswersPage()
                .inputTextInSearchBox(LAW_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkLawSearchWidgetIsPresent()
                .checkLawSearchWidgetIsNotEmpty()

                .navigateToAnswersPage()
                .inputTextInSearchBox("какая печать должна стоять на кадровых документах кадровое дело")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkMagazinesSearchWidgetIsPresent()
                .checkMagazinesSearchWidgetIsNotEmpty()

                .navigateToAnswersPage()
                .inputTextInSearchBox(FORMS_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkFormsSearchWidgetIsPresent()
                .checkFormsSearchWidgetIsNotEmpty()

                .navigateToAnswersPage()
                .inputTextInSearchBox("новое об иностранцах в 2016 году")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchErrorIsNotPresent()
                .checkVideoSearchWidgetIsPresent()
                .checkVideoSearchWidgetIsNotEmpty()

                .logout();
    }
}

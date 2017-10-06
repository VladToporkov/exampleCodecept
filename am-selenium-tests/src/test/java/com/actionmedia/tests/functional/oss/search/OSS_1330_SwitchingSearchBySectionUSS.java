package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 15/11/15.
 */
public class OSS_1330_SwitchingSearchBySectionUSS extends AbstractDomainTest {

    private static final String QUERY = "1";
    private static final String SECOND_QUERY = "132123123213";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1330", testCaseVersion = "1")
    public void oss_1330_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Переключение поиска по разделам ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Переключение поиска по разделам ЮСС ДОК");
        test();
    }

    private void test() {
        loginUss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.DICTIONARY)

                .navigateToVideoPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.VIDEO)

                .logout();
    }
}


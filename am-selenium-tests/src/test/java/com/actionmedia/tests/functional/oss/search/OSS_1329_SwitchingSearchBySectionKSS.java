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
public class OSS_1329_SwitchingSearchBySectionKSS extends AbstractDomainTest {

    private static final String QUERY = "1";
    private static final String SECOND_QUERY = "132123123213";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1329", testCaseVersion = "1")
    public void oss_1329_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Переключение поиска по разделам КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Переключение поиска по разделам  КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Переключение поиска по разделам КСС ВИП");
        test();
    }

    private void test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.ANSWERS)

                .navigateToFormsPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.FORMS)

                .logout();
    }
}

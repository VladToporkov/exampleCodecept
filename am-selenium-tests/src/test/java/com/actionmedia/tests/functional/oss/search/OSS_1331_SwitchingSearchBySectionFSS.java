package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 16/11/15.
 */
public class OSS_1331_SwitchingSearchBySectionFSS extends AbstractDomainTest {

    private static final String QUERY = "1";
    private static final String SECOND_QUERY = "132123123213";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1331", testCaseVersion = "1")
    public void oss_1331_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Переключение поиска по разделам ФСС");
        test();
    }

    private void test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.DICTIONARY)

                .logout();
    }
}

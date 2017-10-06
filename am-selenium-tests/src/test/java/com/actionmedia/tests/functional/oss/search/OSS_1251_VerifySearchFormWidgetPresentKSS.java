package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 23/10/15.
 */
public class OSS_1251_VerifySearchFormWidgetPresentKSS extends AbstractDomainTest {

    private static final String QUERY = "справка";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1251", testCaseVersion = "1")
    public void oss_1251_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Формы КСС КУ");
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .mouseHoverSecondItemFormWidget()
                .checkSecondItemFormWidgetIsGreen()

                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()
                .logout();
    }
}

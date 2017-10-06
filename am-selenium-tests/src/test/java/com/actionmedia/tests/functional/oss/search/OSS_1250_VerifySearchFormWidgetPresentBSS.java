package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 23/10/15.
 */
public class OSS_1250_VerifySearchFormWidgetPresentBSS extends AbstractDomainTest {

    private static final String QUERY = "справка";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1250", testCaseVersion = "1")
    public void oss_1250_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Формы БСС КУ");
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .mouseHoverFirstItemFormWidget()
                .checkFirstItemFormWidgetIsRed()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()
                .logout();
    }
}

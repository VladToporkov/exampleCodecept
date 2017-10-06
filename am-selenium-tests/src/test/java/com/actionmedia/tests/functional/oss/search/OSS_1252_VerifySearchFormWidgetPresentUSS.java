package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 23/10/15.
 */
public class OSS_1252_VerifySearchFormWidgetPresentUSS extends AbstractDomainTest {

    private static final String QUERY = "справка";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1252", testCaseVersion = "1")
    public void oss_1252_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Формы ЮСС КУ");
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .mouseHoverThirdItemFormWidget()
                .checkThirdItemFormWidgetIsPurple()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()
                .logout();
    }
}

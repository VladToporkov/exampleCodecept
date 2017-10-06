package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 23/10/15.
 */
public class OSS_1253_VerifySearchFormWidgetPresentFSS extends AbstractDomainTest {

    private static final String QUERY = "бюджет";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1253", testCaseVersion = "1")
    public void oss_1253_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик Формы ФСС КУ");
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetFormsPresent()

                .mouseHoverSecondItemFormWidget()
                .checkSecondItemFormWidgetIsGreen()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkFormsSearchWidgetIsNotPresent()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 05/11/15.
 */
public class OSS_1292_WidgetVideoPresentFSS extends AbstractDomainTest {

    private static final String QUERY = "случаи";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1292", testCaseVersion = "1")
    public void oss_1292_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик видео ФСС КУ");
        test();
    }

    private void test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetVideoPresent()

                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkVideoSearchWidgetIsNotPresent();
    }
}

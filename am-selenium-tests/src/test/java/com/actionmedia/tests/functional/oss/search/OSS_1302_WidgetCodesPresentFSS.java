package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/11/15.
 */
public class OSS_1302_WidgetCodesPresentFSS extends AbstractDomainTest {

    private static final String QUERY = "окоф 3 21";
    private static final String SECOND_QUERY = "182 1 05 010 12 01 1000 110";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1302", testCaseVersion = "1")
    public void oss_1302_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик кодов ФСС КУ");
        test();
    }

    private void test() {
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .navigateToFormsPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetCodeDictionary()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 15/10/15.
 */
public class OSS_1133_VerifySearchMisprintFSS extends AbstractDomainTest {

    private static final String FIRST_QUERY_FALSE = "праект";
    private static final String FIRST_QUERY_TRUE = "проект";

    private static final String SECOND_QUERY_FALSE = "cthdbc";
    private static final String SECOND_QUERY_TRUE = "сервис";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1133", testCaseVersion = "1")
    public void oss_1133_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Исправление опечаток ФСС КУ");
        test();
    }

    public void test() {
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(FIRST_QUERY_TRUE, FIRST_QUERY_FALSE)

                .navigateToFormsPage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .logout();

    }
}

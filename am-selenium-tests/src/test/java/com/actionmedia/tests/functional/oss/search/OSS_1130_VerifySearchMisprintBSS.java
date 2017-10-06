package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 14/10/15.
 */
public class OSS_1130_VerifySearchMisprintBSS extends AbstractDomainTest {

    private static final String FIRST_QUERY_FALSE = "зокон";
    private static final String FIRST_QUERY_TRUE = "закон";

    private static final String SECOND_QUERY_FALSE = "yfkjujdsq rjltrc";
    private static final String SECOND_QUERY_TRUE = "налоговый кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1130", testCaseVersion = "1")
    public void oss_1130_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Исправление опечаток БСС КУ");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Исправление опечаток БСС УСН");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Исправление опечаток БСС БУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Исправление опечаток БСС ВИП");
        test();
    }

    public void test() {
        loginBss()
                .navigateToLawBasePage()
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

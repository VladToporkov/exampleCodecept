package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 14/10/15.
 */
public class OSS_1131_VerifySearchMisprintKSS extends AbstractDomainTest {

    private static final String FIRST_QUERY_FALSE = "зокон";
    private static final String FIRST_QUERY_TRUE = "закон";

    private static final String SECOND_QUERY_FALSE = "dhtlyst eckjdbz трода";
    private static final String SECOND_QUERY_TRUE = "вредные условия труда";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1131", testCaseVersion = "1")
    public void oss_1131_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Исправление опечаток КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Исправление опечаток КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Исправление опечаток КСС ВИП");
        test();
    }

    public void test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(FIRST_QUERY_TRUE, FIRST_QUERY_FALSE)

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .logout();

    }
}

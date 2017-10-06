package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 15/10/15.
 */
public class OSS_1132_VerifySearchMisprintUSS extends AbstractDomainTest {

    private static final String FIRST_QUERY_FALSE = "зокон";
    private static final String FIRST_QUERY_TRUE = "закон";

    private static final String SECOND_QUERY_FALSE = "uhf;lfycrbq rjltrc";
    private static final String SECOND_QUERY_TRUE = "гражданский кодекс";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1132", testCaseVersion = "1")
    public void oss_1132_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Исправление опечаток ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Исправление опечаток ЮСС ВИП");
        test();
    }

    public void test() {
        loginUss()
                .navigateToLawPracticePage()
                .inputTextInSearchBox(FIRST_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkErrataInSearchQuery(FIRST_QUERY_TRUE, FIRST_QUERY_FALSE)

                .navigateToMagazinesPage()
                .inputTextInSearchBox(SECOND_QUERY_FALSE)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkKeyboardLayoutInSearchQuery(SECOND_QUERY_TRUE, SECOND_QUERY_FALSE)

                .logout();

    }
}

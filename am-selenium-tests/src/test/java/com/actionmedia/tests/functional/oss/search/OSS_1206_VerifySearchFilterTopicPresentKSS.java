package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 19/10/15.
 */
public class OSS_1206_VerifySearchFilterTopicPresentKSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1206", testCaseVersion = "1")
    public void oss_1206_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Поисковые фильтры по темам КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Поисковые фильтры по темам КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Поисковые фильтры по темам КСС ВИП");
        test();
    }

    public void test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()
                .logout();
    }
}
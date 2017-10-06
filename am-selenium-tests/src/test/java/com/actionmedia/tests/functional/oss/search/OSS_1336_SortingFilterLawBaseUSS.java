package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/11/15.
 */
public class OSS_1336_SortingFilterLawBaseUSS extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1336", testCaseVersion = "1")
    public void oss_1336_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Сортировка (Правовая база) ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Сортировка (Правовая база) ЮСС ВИП");
        test();
    }

    private void test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDateFilter()

                .clickInLawPracticeLinkFilter()
                .checkDateFilter()
                .logout();
    }
}

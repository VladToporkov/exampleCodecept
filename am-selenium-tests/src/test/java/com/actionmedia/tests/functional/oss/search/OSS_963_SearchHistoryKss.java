package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_963_SearchHistoryKss extends AbstractDomainTest {

    private static final String[] QUERY = new String[]{
            "налог на имущество",
            "налог на имущество декларация",
            "налоговая декларация по усн",
            "налог на имущество 2014",
            "налоговые вычеты на детей",
            "налоговые регистры для расчета ндфл",
            "налоговая ставка по транспортному налогу",
            "1"};

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-963", testCaseVersion = "1")
    public void oss_963_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется История поисковых запросов КСС КУ");
        loginKss()
                .navigateToLawBasePage()
                .inputSearchHistory(QUERY)
                .clearSearchBox()
                .checkSearchHistory(QUERY)
                .logout();
    }
}

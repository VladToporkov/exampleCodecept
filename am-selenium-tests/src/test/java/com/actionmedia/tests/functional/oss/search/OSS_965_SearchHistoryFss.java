package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_965_SearchHistoryFss extends AbstractDomainTest {

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
    @TestLink(testCaseId = "OSS-965", testCaseVersion = "1")
    public void oss_965_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется История поисковых запросов ФСС КУ");
        loginFss()
                .navigateToDictionaryPage()
                .inputSearchHistory(QUERY)
                .clearSearchBox()
                .checkSearchHistory(QUERY)
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/11/15.
 */
public class OSS_1300_WidgetCodesPresentKSS extends AbstractDomainTest {

    private static final String QUERY = "окоф авто";
    private static final String SECOND_QUERY = "кбк 1";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1300", testCaseVersion = "1")
    public void oss_1300_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик Кодов КСС КУ");
        test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Кодов КСС БУ");
        test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Кодов КСС ВИП");
        test();
    }

    private void test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetCodeDictionary()

                .logout();
    }
}


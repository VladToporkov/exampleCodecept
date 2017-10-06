package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 09/11/15.
 */
public class OSS_1301_WidgetCodesPresentUSS extends AbstractDomainTest {

    private static final String QUERY = "14 2915255";
    private static final String SECOND_QUERY = "кбк авто";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1301", testCaseVersion = "1")
    public void oss_1301_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик Кодов ЮСС КУ");
        test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик Кодов ЮСС ВИП");
        test();
    }

    private void test() {
        loginUss()
                .navigateToLawPracticePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .navigateToServicesPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetCodeDictionary()

                .logout();
    }
}


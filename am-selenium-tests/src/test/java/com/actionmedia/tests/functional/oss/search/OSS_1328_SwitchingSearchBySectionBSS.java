package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.components.MainMenuButtons;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel Popov on 15/11/15.
 */
public class OSS_1328_SwitchingSearchBySectionBSS extends AbstractDomainTest {

    private static final String QUERY = "1";
    private static final String SECOND_QUERY = "132123123213";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1328", testCaseVersion = "1")
    public void oss_1328_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Переключение поиска по разделам БСС КУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Переключение поиска по разделам БСС ВИП");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Переключение поиска по разделам БСС УПР");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Переключение поиска по разделам БСС БУ");
        test();
    }

    private void test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.LAW_BASE)

                .navigateToServicesPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSectionFilter(MainMenuButtons.SERVICES)

                .logout();
    }
}

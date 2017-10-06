package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/06/16.
 */
public class OSS_1651_ProfstandartsWidget_KSS extends AbstractDomainTest {

    private static String PROFSTANDARTS_BLOCK_SEARCH_INPUT_NAME = "Поиск стандарта";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1651", testCaseVersion = "2")
    public void oss_1651_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок Профстандарты в раздел Правовая база КСС КУ");
        test_with_login();

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Проверяется Блок Профстандарты в раздел Правовая база КСС БУ");
        test_with_login();

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Проверяется Блок Профстандарты в раздел Правовая база КСС ВИП");
        test_with_login();
    }

    private void test_with_login() {
        loginKss()
                .navigateToLawBasePage()
                .checkProfstandartsWidgetTitleHasWordProfstandarts()
                .checkProfstandartsWidgetTitleHasNoticeNew()
                .checkProfstandartsWidgetCountProfstandartsIsPresent()
                .checkProfstandartsWidgetLinkAllAcceptedIsPresent()
                .checkProfstandartsWidgetLinkHRIsPresent()
                .checkProfstandartsWidgetLinkSpecialistSafetyIsPresent()
                .checkProfstandartsWidgetLinkRecruiterIsPresent()
                .checkProfstandartsWidgetSearchWidgetHasName(PROFSTANDARTS_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

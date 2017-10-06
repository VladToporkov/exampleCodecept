package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/06/16.
 */
public class OSS_1654_PopularWidget_KSS extends AbstractDomainTest {

    private static String POPULAR_BLOCK_SEARCH_INPUT_NAME = "Поиск региональных документов";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1654", testCaseVersion = "2")
    public void oss_1654_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блок Популярное в раздел Правовая база КСС КУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Проверяется Блок Популярное в раздел Правовая база КСС БУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Проверяется Блок Популярное в раздел Правовая база КСС ВИП");
        test_without_login();
        test_with_login();
    }

    private void test_without_login() {
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsNotDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME);
    }

    private void test_with_login() {
        loginKss()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

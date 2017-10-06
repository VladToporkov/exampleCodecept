package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/06/16.
 */
public class OSS_1653_PopularInWidget_BSS extends AbstractDomainTest {

    private static String POPULAR_BLOCK_SEARCH_INPUT_NAME = "Поиск региональных документов";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1653", testCaseVersion = "2")
    public void oss_1653_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок Популярное в раздел Правовая база БСС КУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Блок Популярное в раздел Правовая база БСС БУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Проверяется Блок Популярное в раздел Правовая база БСС УСН");
        test_without_login();
        test_with_login();

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Блок Популярное в раздел Правовая база БСС ВИП");
        test_without_login();
        test_with_login();
    }

    private void test_without_login() {
        enterToBssWithoutLogin()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsNotDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME);
    }

    private void test_with_login() {
        loginBss()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

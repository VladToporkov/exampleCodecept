package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/06/16.
 */
public class OSS_1655_PopularWidget_USS extends AbstractDomainTest {

    private static String POPULAR_BLOCK_SEARCH_INPUT_NAME = "Поиск региональных документов";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1655", testCaseVersion = "2")
    public void oss_1655_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блок Популярное в раздел Правовая база ЮСС КУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        report("Проверяется Блок Популярное в раздел Правовая база ЮСС ВИП");
        test_without_login();
        test_with_login();
    }

    private void test_without_login() {
        enterToUssWithoutLogin()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsNotDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME);
    }

    private void test_with_login() {
        loginUss()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

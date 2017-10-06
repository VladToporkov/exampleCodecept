package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/06/16.
 */
public class OSS_1659_PopularWidget_GO extends AbstractDomainTest {

    private static String POPULAR_BLOCK_SEARCH_INPUT_NAME = "Поиск региональных документов";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1659", testCaseVersion = "2")
    public void oss_1659_test() {
        //go
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блок Популярное в раздел Правовая база ГЗ КУ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блок Популярное в раздел Правовая база ГЗ МИНИ");
        test_without_login();
        test_with_login();

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блок Популярное в раздел Правовая база ГЗ ВИП");
        test_without_login();
        test_with_login();
    }

    private void test_without_login() {
        enterToGoWithoutLogin()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsNotDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME);
    }

    private void test_with_login() {
        loginGo()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

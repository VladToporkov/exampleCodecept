package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 20/06/16.
 */
public class OSS_1658_PopularWidget_GF extends AbstractDomainTest {

    private static String POPULAR_BLOCK_SEARCH_INPUT_NAME = "Поиск региональных документов";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1658", testCaseVersion = "2")
    public void oss_1658_test() {
        //gf
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блок Популярное в раздел Правовая база ГФ КУ");
        test_without_login();
        test_with_login();
    }

    private void test_without_login() {
        enterToGFWithoutLogin()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsNotDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME);
    }

    private void test_with_login() {
        loginGF()
                .navigateToLawBasePage()
                .checkPopularWidgetIsPresent()
                .checkPopularWidgetTitleHasWordPopular()
                .checkPopularWidgetContainsLinksWithDocuments()
                .checkPopularWidgetLinkChangeRegionIsDisplayed()
                .checkPopularWidgetCheckSearchInputHasName(POPULAR_BLOCK_SEARCH_INPUT_NAME)
                .logout();
    }
}

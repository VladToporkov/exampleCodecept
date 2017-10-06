package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/10/15.
 */
public class OSS_1284_WidgetHandbookPresentBSS extends AbstractDomainTest {

    private static final String QUERY = "случаи";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1284", testCaseVersion = "1")
    public void oss_1284_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик Справочников БСС КУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик Справочников БСС ВИП");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик Справочников БСС УПР");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик Справочников БСС БУ");
        test();
    }

    public void test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetDictionaryPresent()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkDictionarySearchWidgetIsNotPresent()

                .logout();
    }
}

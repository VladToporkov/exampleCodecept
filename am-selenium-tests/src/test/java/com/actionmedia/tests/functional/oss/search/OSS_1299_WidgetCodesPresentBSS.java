package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 08/11/15.
 */
public class OSS_1299_WidgetCodesPresentBSS extends AbstractDomainTest {

    private static final String QUERY = "окоф 11";
    private static final String SECOND_QUERY = "кбк вино";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1299", testCaseVersion = "1")
    public void oss_1299_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик кодов БСС КУ");
        test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик кодов БСС ВИП");
        test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик кодов БСС ЮСН");
        test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик кодов БСС БУ");
        test();
    }

    private void test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(SECOND_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetCodeDictionary()

                .logout();
    }
}

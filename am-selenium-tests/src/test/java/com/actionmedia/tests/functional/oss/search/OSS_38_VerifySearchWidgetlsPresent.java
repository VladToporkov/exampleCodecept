package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 29.01.2015.
 */
public class OSS_38_VerifySearchWidgetlsPresent extends AbstractDomainTest {

    private static final String QUERY = "Окоф 11";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-38", testCaseVersion = "1")
    public void oss_38_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Колдунщик ОКОФ КСС КУ");
        kss_38_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик ОКОФ  КСС БУ");
        kss_38_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик ОКОФ КСС ВИП");
        kss_38_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Колдунщик ОКОФ БСС КУ");
        bss_38_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Колдунщик ОКОФ БСС ВИП");
        bss_38_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Колдунщик ОКОФ БСС УПР");
        bss_38_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Колдунщик ОКОФ БСС БУ");
        bss_38_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Колдунщик ОКОФ ЮСС КУ");
        uss_38_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Колдунщик ОКОФ ЮСС ДОК");
        uss_38_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Колдунщик ОКОФ ФСС КУ");
        fss_38_test();
    }

    private void kss_38_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .clickWidgetShowMore()

                .checkWidgetsFull()

                .clickWidgetShowMore()

                .checkWidgetsFolder()

                .checkWidgetsLinks()

                .logout();
    }

    private void bss_38_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .clickWidgetShowMore()

                .checkWidgetsFull()

                .clickWidgetShowMore()

                .checkWidgetsFolder()

                .checkWidgetlsLinks()

                .logout();
    }

    private void uss_38_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .clickWidgetShowMore()

                .checkWidgetsFull()

                .clickWidgetShowMore()

                .checkWidgetsFolder()

                .checkWidgetsLinks()

                .logout();
    }

    private void fss_38_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkWidgetsFolder()

                .clickWidgetShowMore()

                .checkWidgetsFull()

                .clickWidgetShowMore()

                .checkWidgetsFolder()

                .checkWidgetsLinks()

                .logout();
    }

}

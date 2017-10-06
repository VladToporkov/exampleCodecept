package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_319_VerifySearchOutputResultLawPageNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-319", testCaseVersion = "1")
    public void oss_319_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) КСС КУ");
        kss_319_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база)  КСС БУ");
        kss_319_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) КСС ВИП");
        kss_319_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС КУ");
        bss_319_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС ВИП");
        bss_319_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС УПР");
        bss_319_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) БСС БУ");
        bss_319_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ЮСС КУ");
        uss_319_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ЮСС ДОК");
        uss_319_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Правовая база) ФСС КУ");
        fss_319_test();
    }

    private void kss_319_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void bss_319_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void uss_319_test() {
        loginUss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void fss_319_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }
}

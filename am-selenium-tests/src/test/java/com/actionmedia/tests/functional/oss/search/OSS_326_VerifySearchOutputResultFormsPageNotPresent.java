package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_326_VerifySearchOutputResultFormsPageNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-326", testCaseVersion = "1")
    public void oss_326_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) КСС КУ");
        kss_326_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы)  КСС БУ");
        kss_326_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) КСС ВИП");
        kss_326_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) БСС КУ");
        bss_326_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) БСС ВИП");
        bss_326_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) БСС УПР");
        bss_326_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) БСС БУ");
        bss_326_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) ЮСС КУ");
        uss_326_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) ЮСС ДОК");
        uss_326_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Нет найденных ... (Формы) ФСС КУ");
        fss_326_test();
    }

    private void kss_326_test() {
        loginKss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void bss_326_test() {
        loginBss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void uss_326_test() {
        loginUss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }

    private void fss_326_test() {
        loginFss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsNotPresent()

                .checkLinksOnTypo()

                .logout();
    }
}

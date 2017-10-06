package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_313_VerifySearchOutputResultAnswerPageIsPresent extends AbstractDomainTest {

    private static final String QUERYKSS = "Повышение по должности";
    private static final String QUERYBSS = "Повышение по должности";
    private static final String QUERYUSS = "зарплата";
    private static final String QUERYFSS = "зарплата";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-313", testCaseVersion = "1")
    public void oss_313_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) КСС КУ");
        kss_313_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации)  КСС БУ");
        kss_313_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) КСС ВИП");
        kss_313_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) БСС КУ");
        bss_313_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) БСС ВИП");
        bss_313_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) БСС УПР");
        bss_313_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) БСС БУ");
        bss_313_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) ЮСС КУ");
        uss_313_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) ЮСС ДОК");
        uss_313_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Рекомендации) ФСС КУ");
        fss_313_test();
    }

    private void kss_313_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERYKSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()
                .logout();
    }

    private void bss_313_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()
                .logout();
    }

    private void uss_313_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()
                .logout();
    }

    private void fss_313_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnSolutionsPageIsOpened()
                .logout();
    }
}

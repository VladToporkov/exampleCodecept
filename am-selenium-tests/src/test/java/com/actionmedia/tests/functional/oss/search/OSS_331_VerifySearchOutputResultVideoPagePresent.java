package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_331_VerifySearchOutputResultVideoPagePresent extends AbstractDomainTest {

    private static final String QUERYKSS = "лекция";
    private static final String QUERYBSS = "налог";
    private static final String QUERYUSS = "особенности";
    private static final String QUERYFSS = "правила";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-331", testCaseVersion = "1")
    public void oss_331_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) КСС КУ");
        kss_331_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео)  КСС БУ");
        kss_331_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) КСС ВИП");
        kss_331_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) БСС КУ");
        bss_331_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) БСС ВИП");
        bss_331_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) БСС УПР");
        bss_331_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) БСС БУ");
        bss_331_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) ЮСС КУ");
        uss_331_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) ЮСС ДОК");
        uss_331_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Видео) ФСС КУ");
        fss_331_test();
    }

    private void kss_331_test() {
        loginKss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYKSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnVideosPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void bss_331_test() {
        loginBss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnVideosPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void uss_331_test() {
        loginUss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnVideosPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void fss_331_test() {
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnVideoPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }
}

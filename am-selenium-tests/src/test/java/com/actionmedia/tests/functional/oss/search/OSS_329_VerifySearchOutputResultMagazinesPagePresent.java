package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_329_VerifySearchOutputResultMagazinesPagePresent extends AbstractDomainTest {

    private static final String QUERYKSS = "аттестация сотрудников";
    private static final String QUERYBSS = "приватизация жилья";
    private static final String QUERYUSS = "агентский договор";
    private static final String QUERYFSS = "лимит расчетов наличными";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-329", testCaseVersion = "1")
    public void oss_329_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) КСС КУ");
        kss_329_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги)  КСС БУ");
        kss_329_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) КСС ВИП");
        kss_329_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) БСС КУ");
        bss_329_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) БСС ВИП");
        bss_329_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) БСС УПР");
        bss_329_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) БСС БУ");
        bss_329_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) ЮСС КУ");
        uss_329_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) ЮСС ДОК");
        uss_329_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Журналы и книги) ФСС КУ");
        fss_329_test();
    }

    private void kss_329_test() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYKSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnMagazinesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void bss_329_test() {
        loginBss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnMagazinesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void uss_329_test() {
        loginUss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnMagazinesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void fss_329_test() {
        loginFss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnMagazinesPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }
}

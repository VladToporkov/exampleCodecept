package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_327_VerifySearchOutputResultDictionaryPagePresent extends AbstractDomainTest {

    private static final String QUERYKSS = "календарь";
    private static final String QUERYBSS = "адрес";
    private static final String QUERYUSS = "виды услуг";
    private static final String QUERYFSS = "календарь";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-327", testCaseVersion = "2")
    public void oss_327_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) КСС КУ");
        kss_327_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник)  КСС БУ");
        kss_327_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) КСС ВИП");
        kss_327_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) БСС КУ");
        bss_327_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) БСС ВИП");
        bss_327_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) БСС УПР");
        bss_327_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) БСС БУ");
        loginBss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkTopicFilter()

                .checkSearchResultOnDictionaryPageIsOpened()

                .checkSearchResultItemList()

                .logout();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) ЮСС КУ");
        uss_327_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) ЮСС ДОК");
        uss_327_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение. Поисковая выдача. Есть найденные ... (Справочник) ФСС КУ");
        fss_327_test();
    }

    private void kss_327_test() {
        loginKss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYKSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnDictionaryPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void bss_327_test() {
        loginBss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYBSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnDictionaryPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void uss_327_test() {
        loginUss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYUSS)
                .clickSearchButtonAndNavigateToSearchResultPage()

                .checkSearchResultOnDictionaryPageIsOpened()

                .checkSearchResultItemList()

                .logout();
    }

    private void fss_327_test() {
        loginFss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERYFSS)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkTopicFilter()

                .checkSearchResultOnDictionaryPageIsOpened()

                .checkSearchResultItemList()


                .logout();
    }
}

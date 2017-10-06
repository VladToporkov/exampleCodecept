package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_396_DictionaryOverallDisplay extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-396", testCaseVersion = "1")
    public void oss_396_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) КСС КУ");
        kss_396_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение раздела (Справочник) КСС БУ");
        kss_396_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела (Справочник) КСС ВИП");
        kss_396_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) БСС КУ");
        bss_396_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение раздела (Справочник) БСС ВИП");
        bss_396_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение раздела (Справочник) БСС УПР");
        bss_396_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение раздела (Справочник) БСС БУ");
        bss_396_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) ЮСС КУ");
        uss_396_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Общее отображение раздела (Справочник) ЮСС ДОК");
        uss_396_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение раздела (Справочник) ФСС КУ");
        fss_396_test();
    }

    private void kss_396_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkElementsOnDictionaryBoard()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkAllDictionaryRubricatorButtonIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkAssistantButtonIsPresent()

                .logout();
    }

    private void bss_396_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkElementsOnDictionaryBoard()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkHelpersIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkAllDictionaryRubricatorButtonIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkAssistantButtonIsPresent()

                .logout();
    }

    private void uss_396_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkElementsOnDictionaryBoard()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkHelpersIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkAllDictionaryRubricatorButtonIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkAssistantButtonIsPresent()

                .logout();
    }

    private void fss_396_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDictionaryBoardIsDisplayed()

                .checkElementsOnDictionaryBoard()

                .checkDictionaryNewsBlockIsDisplayed()

                .checkPopularBlockIsDisplayed()

                .checkAllDictionaryRubricatorButtonIsPresent()

                .checkMyFavoritesRubricatorButtonIsPresent()

                .checkFssAssistantButtonIsPresent()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: a.kulakov
 * Date: 20.03.2015
 * Time: 15:09
 */
public class OSS_523_VerifyVideosDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-523", testCaseVersion = "1")
    public void oss_523_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется OSS-523:Общее отображение раздела (Видео) КСС КУ");
        kss_523_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется OSS-523:Общее отображение раздела (Видео) БСС КУ");
        bss_523_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-523:Общее отображение раздела (Видео) ЮСС КУ");
        uss_523_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется OSS-523:Общее отображение раздела (Видео) ЮСС КУ");
        fss_523_test();
    }

    private void kss_523_test() {
        loginKss()
                .navigateToVideoPage()

                // Большое превью (ссылка на видео)
                .checkNewVideoBlock()

                // Название видео (ссылка на видео)
                .checkNewVideoName()

                // ИФ автора видео и его должность (если у видео есть автор)
                // .dummy

                // Доп. информация по видео (краткое содержание)
                // .dummy

                // Проверяется блок с остальными видео
                .checkVideoBlocksIsNotEmpty()

                // "Проверяется формат блока видео"
                .checkVideoBlockFormat()

                // "Проверяется кнопка рубрикатора видеосеминаров присутсвует"
                .checkVideoRubricatorButtonIsPresent()

                //"Проверяется кнопка Мое избранное присутсвует"
                .checkMyFavoritesRubricatorButtonIsPresent()

                // "Проверяется кнопка онлайн консультанта 'Помощник' присутсвует"
                .checkHelperButtonIsPresent()

                .logout();
    }

    private void bss_523_test() {
        loginBss()
                .navigateToVideoPage()

                // Большое превью (ссылка на видео)
                .checkNewVideoBlock()

                // Название видео (ссылка на видео)
                .checkNewVideoName()

                // ИФ автора видео и его должность (если у видео есть автор)
                // .dummy

                // Доп. информация по видео (краткое содержание)
                // .dummy

                // Проверяется блок с остальными видео
                .checkVideoBlocksIsNotEmpty()

                // "Проверяется содержание для видео/описания видео"
                .checkVideoBlocksContent()

                // "Проверяется кнопка рубрикатора видеосеминаров присутсвует"
                .checkAllVideosButtonIsPresent()

                //"Проверяется кнопка Мое избранное присутсвует"
                .checkMyFavoritesRubricatorButtonIsPresent()

                // "Проверяется кнопка онлайн консультанта 'Помощник' присутсвует"
                .checkHelperButtonIsPresent()

                .logout();
    }

    private void uss_523_test() {
        loginUss()
                .navigateToVideoPage()

                // Большое превью (ссылка на видео)
                .checkNewVideoBlock()

                // Название видео (ссылка на видео)
                .checkNewVideoName()

                // ИФ автора видео и его должность (если у видео есть автор)
                // .dummy

                // Доп. информация по видео (краткое содержание)
                // .dummy

                // Проверяется блок с остальными видео
                .checkVideoBlocksIsNotEmpty()

                // "Проверяется формат блока видео"
                .checkVideoBlockFormat()

                // "Проверяется кнопка рубрикатора видеосеминаров присутсвует"
                .checkVideoRubricatorButtonIsPresent()

                //"Проверяется кнопка Мое избранное присутсвует"
                .checkMyFavoritesRubricatorButtonIsPresent()

                // "Проверяется кнопка онлайн консультанта 'Помощник' присутсвует"
                .checkHelperButtonIsPresent()

                .logout();
    }

    private void fss_523_test() {
        loginFss()
                .navigateToVideoPage()
                // Большое превью (ссылка на видео)
                .checkNewVideoBlock()

                // Название видео (ссылка на видео)
                .checkNewVideoName()

                // ИФ автора видео и его должность (если у видео есть автор)
                // .dummy

                // Доп. информация по видео (краткое содержание)
                // .dummy

                // Проверяется блок с остальными видео
                .checkVideoBlocksIsNotEmpty()

                // "Проверяется формат блока видео"
                .checkVideoBlockFormat()

                // "Проверяется кнопка рубрикатора видеосеминаров присутствует"
                .checkVideoRubricatorButtonIsPresent()

                //"Проверяется кнопка Мое избранное присутсвует"
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

}

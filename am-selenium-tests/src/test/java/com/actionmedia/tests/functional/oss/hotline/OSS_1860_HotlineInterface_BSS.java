package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 26/09/2016.
 */
public class OSS_1860_HotlineInterface_BSS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1860", testCaseVersion = "1")
    public void oss_1860_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение Горячей линии БСС КУ");
        bss_commercial();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение Горячей линии БСС БУ");
        bss_commercial();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение Горячей линии БСС ВИП");
        bss_vip();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение Горячей линии БСС УСН");
        bss_usn();
    }

    private void bss_commercial() {
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextFormIsPresent()
                .checkOnlinePlaceholderText("Задайте Ваш вопрос онлайн-помощнику здесь. Он в течение нескольких" +
                        " минут подберет в Системе нужный материал. Пожалуйста, не покидайте сайт, пока Вам не ответят")
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .clickPersonalTab()
                .checkButtonTabOnlineIsPresent()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Главбух\n" +
                        "Подробный ответ в течение 24 часов. В рабочие дни.")

                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }

    private void bss_vip() {
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsPresent()
                .checkTextFormIsPresent()
                .checkOnlinePlaceholderText("Задайте Ваш вопрос онлайн-помощнику здесь. Он в течение нескольких" +
                        " минут подберет в Системе нужный материал. Пожалуйста, не покидайте сайт, пока Вам не ответят")
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .clickPersonalTab()
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsPresent()
                .checkVIPLabelOnTabWriting()
                .checkExpertInfoPhotoIsPresent()
                .checkExpertInfoFullNameIsPresent()
                .checkExpertInfoPositionIsPresent()
                .checkExpertInfoPhoneNumberIsPresent()
                .checkExpertInfoEmailIsPresent()
                .checkTextOnTabWriting("Ваш персональный эксперт\n" +
                        "Количество вопросов неограниченно. Ответ в течение 24 часов.")
                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .clickAuthorsTab()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsPresent()
                .checkPhotoAuthorsOnFromAuthors()
                .checkTextOnTabFromAuthors("Консультация со специалистами\n" +
                        "министерств и ведомств\n" +
                        "Один вопрос в месяц. Ответ в течение 10 дней")
                .checkVIPLabelOnTabFromAuthors()
                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()
                .checkTextFormIsPresent()

                .logout();
    }

    private void bss_usn() {
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Главбух")
                .checkTabsMenuIsNotPresent()
                .checkOnlinePlaceholderText("Задайте Ваш вопрос эксперту здесь")
                .checkGlassesIsVisible()
                .checkTextTabForUSN()
                .checkTextFormIsPresent()
                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()

                .logout();
    }
}

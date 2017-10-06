package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 13/03/16.
 */
public class OSS_415_HotlineInterface extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-415", testCaseVersion = "4")
    public void oss_415_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки БСС КУ");
        bss_commercial();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки БСС ВИП");
        bss_vip();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Интерфейс экспертной поддержки БСС УСН");
        bss_usn();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки КСС КУ");
        kss_commercial();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки КСС ВИП");
        kss_vip();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ЮСС КУ");
        uss_commercial();
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
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Главбух\n" +
                        "Подробный ответ в течение 24 часов. В рабочие дни.")

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
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkVIPLabelOnTabWriting()
                .checkExpertInfoPhotoIsPresent()
                .checkExpertInfoFullNameIsPresent()
                .checkExpertInfoPositionIsPresent()
                .checkExpertInfoPhoneNumberIsPresent()
                .checkExpertInfoEmailIsPresent()
                .checkTextOnTabWriting("Ваш персональный эксперт\n" +
                        "Количество вопросов неограниченно. Ответ в течение 24 часов.")

                .clickAuthorsTab()
                .checkPhotoAuthorsOnFromAuthors()
                .checkTextOnTabFromAuthors("Консультация со специалистами\n" +
                        "министерств и ведомств\n" +
                        "Один вопрос в месяц. Ответ в течение 10 дней.")
                .checkVIPLabelOnTabFromAuthors()

                .logout();
    }

    private void bss_usn() {
        loginBss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Консультация экспертов Системы Главбух")
                .checkTabsMenuIsNotPresent()
                .checkGlassesIsVisible()
                .checkTextTabForUSN()
                .checkTextFormIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()

                .logout();
    }

    private void kss_commercial() {
        loginKss()
                .navigateToAnswersPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextFormIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Быстрый ответ в чате. Круглосуточно по будням.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Кадры")

                .logout();
    }

    private void kss_vip() {
        loginKss()
                .navigateToAnswersPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsPresent()
                .checkTextFormIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Быстрый ответ в чате. Круглосуточно по будням.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkVIPLabelOnTabWriting()
                .checkExpertInfoPhotoIsPresent()
                .checkExpertInfoFullNameIsPresent()
                .checkExpertInfoPositionIsPresent()
                .checkExpertInfoPhoneNumberIsPresent()
                .checkExpertInfoEmailIsNotPresent()
                .checkTextOnTabWriting("Ваш персональный эксперт\n" +
                        "Письменный ответ с подборкой материалов Системы. В течение 24 часов.")

                .clickAuthorsTab()
                .checkPhotoAuthorsOnFromAuthors()
                .checkTextOnTabFromAuthors("Консультация\n" +
                        "с авторами системы\n" +
                        "Один вопрос в месяц. Ответ в течение 10 дней.")
                .checkVIPLabelOnTabFromAuthors()

                .logout();
    }

    private void uss_commercial() {
        loginUss()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextFormIsPresent()
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни.")
                .checkLinkExpertsWorkingRules()

                .clickPersonalTab()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов «Системы Юрист»")

                .logout();
    }
}

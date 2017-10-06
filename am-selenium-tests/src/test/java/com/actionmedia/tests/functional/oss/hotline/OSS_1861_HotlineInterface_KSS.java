package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 28/09/2016.
 */
public class OSS_1861_HotlineInterface_KSS extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1861", testCaseVersion = "1")
    public void oss_1861_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки КСС КУ");
        kss_commercial();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Интерфейс экспертной поддержки КСС ВИП");
        kss_vip();
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
                        "Один вопрос в месяц. Ответ в течение 10 дней")
                .checkVIPLabelOnTabFromAuthors()

                .logout();
    }
}

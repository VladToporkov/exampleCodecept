package com.actionmedia.tests.functional.oss.hotline;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by popovpavel on 29/09/2016.
 */
public class OSS_1863_HotlineInterface_GF extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1863", testCaseVersion = "1")
    public void oss_1863_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Интерфейс экспертной поддержки ГФ КУ");
        test_commercial();
    }

    private void test_commercial() {
        loginGF()
                .navigateToRecomendPage()
                .clickAskExpertLink()
                .checkTitleGetAnswerIsPresent("Получить ответ:")
                .checkButtonTabOnlineIsPresent()
                .checkButtonTabWritingIsPresent()
                .checkButtonTabFromAuthorsIsNotPresent()
                .checkTextFormIsPresent()
                .checkOnlinePlaceholderText("Задайте Ваш вопрос онлайн-помощнику здесь. Он в течение нескольких" +
                        " минут подберет в Системе нужный материал. Пожалуйста, не покидайте сайт, пока Вам не ответят")
                .checkSendWindowsIsEnabled()
                .checkSendButtonIsEnabled()
                .checkStickerIsPresent()
                .checkTextOnTabOnline("Моментальный ответ онлайн-помощника\n" +
                        "Если не нужен письменный ответ. Круглосуточно в рабочие дни, с 9 до 18 по выходным.")
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .clickPersonalTab()
                .checkButtonTabOnlineIsPresent()
                .checkSendWindowsIsEnabled()
                .checkGlassesIsVisible()
                .checkTextOnTabWriting("Письменные консультации\n" +
                        "от экспертов Системы Госфинансы\n" +
                        "Подробный ответ в течение 24 часов. В рабочие дни.")

                .checkStickerIsPresent()
                .checkLinkExpertsWorkingRules()
                .checkExpertsAnswersArePresent()

                .logout();
    }
}

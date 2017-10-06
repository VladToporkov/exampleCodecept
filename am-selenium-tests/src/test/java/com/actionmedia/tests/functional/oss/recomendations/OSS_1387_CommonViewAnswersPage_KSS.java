package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_1387_CommonViewAnswersPage_KSS extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все ответы";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1387", testCaseVersion = "1")
    public void oss_1387_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации КСС КУ");
        test();

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Проверяется Общее отображение раздела Рекомендации КСС БУ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации КСС ВИП");
        test();

        report("Проверяется Общее отображение раздела Рекомендации КСС Неавторизованный");
        test_without_login();
    }

    private void test() {
        loginKss()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkEstimatorsWidgetIsPresent()
                .checkWizardsWidgetIsPresent()
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToKssWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkEstimatorsWidgetIsPresent()
                .checkWizardsWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()

                .logout();
    }
}

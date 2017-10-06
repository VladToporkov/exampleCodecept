package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_1389_CommonViewRecomendationPage_USS extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1389", testCaseVersion = "1")
    public void oss_1389_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации ЮСС КУ");
        test();

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Проверяется Общее отображение раздела Рекомендации ЮСС БУ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("uss.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации ЮСС ВИП");
        test();

        report("Проверяется Общее отображение раздела Рекомендации ЮСС Неавторизованный");
        test_without_login();
    }

    private void test() {
        loginUss()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
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
        enterToUssWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkWizardsWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()
                .checkAssistantButtonIsPresent()

                .logout();
    }
}

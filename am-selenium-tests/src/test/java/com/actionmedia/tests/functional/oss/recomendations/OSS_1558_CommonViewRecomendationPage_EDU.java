package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 01/07/16.
 */
public class OSS_1558_CommonViewRecomendationPage_EDU extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1558", testCaseVersion = "3")
    public void oss_1558_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации ОБР КУ");
        test_opt();

        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        report("Проверяется Общее отображение раздела Рекомендации ОБР МИНИ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации ОБР ВИП");
        test_vip();

        report("Проверяется Общее отображение раздела Рекомендации ОБР ВИП Без аутентификации");
        test_without_login();
    }

    private void test() {
        loginEdu()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsNotPresent() //not present
                .checkMagazinesWidgetIsNotPresent() //not present
                .checkConstructorWidgetIsNotPresent() //not present
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_vip() {
        loginEdu()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkConstructorWidgetIsPresent()
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_opt() {
        loginEdu()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkMagazinesWidgetIsNotPresent() //not present
                .checkConstructorWidgetIsPresent() //not present
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToEduWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //not present
                .checkConstructorWidgetIsPresent() //not present
                .checkFavoritesWidgetIsNotPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()

                .logout();
    }
}

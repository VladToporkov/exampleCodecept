package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_1557_CommonViewRecomendationPage_EHS extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1557", testCaseVersion = "1")
    public void oss_1557_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации ОТ КУ");
        test_opt_vip();

        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        report("Проверяется Общее отображение раздела Рекомендации ОТ МИНИ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации ОТ ВИП");
        test_opt_vip();

        report("Проверяется Общее отображение раздела Рекомендации ОТ Неавторизованный");
        test_without_login();
    }

    private void test() {
        loginOT()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkSchoolIsNotPresent() //not present
                .checkFormsWidgetIsPresent()
                .checkMagazinesWidgetIsNotPresent() //not present
                .checkHandbookWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsNotPresent() //not present
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_opt_vip() {
        loginOT()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkSchoolIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //only for vip
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToOtWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkSchoolIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //only for vip
                .checkFavoritesWidgetIsNotPresent() //not present
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent() //not present

                .logout();
    }
}

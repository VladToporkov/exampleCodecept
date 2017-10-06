package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 28/06/16.
 */
public class OSS_1908_CommonViewRecomendationPage_UMD extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1908", testCaseVersion = "3")
    public void oss_1908_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации УМД КУ");
        test();

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Общее отображение раздела Рекомендации УМД МИНИ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации УМД ВИП");
        test_vip();

        test_without_login();
    }

    private void test() {
        loginUmd()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkMagazinesWidgetIsNotPresent() //not present
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_vip() {
        loginUmd()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //only for vip
                .checkVideoWidgetIsPresent()
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToUmdWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //only for vip
                .checkVideoWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent() //not present
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent() //not present

                .logout();
    }
}

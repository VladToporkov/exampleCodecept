package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_1907_CommonViewRecomendationPage_Cult extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1907", testCaseVersion = "3")
    public void oss_1907_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации КУЛЬТ КУ");
        test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации КУЛЬТ ВИП");
        test_vip();

        test_without_login();
    }

    private void test() {
        loginCult()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkVideoWidgetIsNotPresent() //not present
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
        loginCult()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent() //only for vip
                .checkVideoWidgetIsPresent() //only for vip
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToCultWithoutLogin()
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
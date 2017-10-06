package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 01/07/16.
 */
public class OSS_1545_CommonViewRecomendationPage_GF extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1545", testCaseVersion = "1")
    public void oss_1545_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации БСС КУ");
        test_ku_vip();

        report("Проверяется Общее отображение раздела Рекомендации БСС Неавторизованный");
        test_without_login();
    }

    private void test_ku_vip() {
        loginGF()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSchoolWidgetIsPresent() //for ku and vip
                .checkMagazinesWidgetIsPresent()
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
        enterToGFWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSchoolWidgetIsPresent() //for ku and vip
                .checkMagazinesWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()

                .logout();
    }
}

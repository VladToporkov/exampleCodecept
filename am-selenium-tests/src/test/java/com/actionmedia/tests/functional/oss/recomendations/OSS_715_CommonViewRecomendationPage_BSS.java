package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_715_CommonViewRecomendationPage_BSS extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все рекомендации";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-715", testCaseVersion = "1")
    public void oss_715_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации БСС КУ");
        test_ku_vip();

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Общее отображение раздела Рекомендации БСС БУ");
        test_ku_vip();

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Проверяется Общее отображение раздела Рекомендации БСС УСН");
        test_ku_vip();

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Общее отображение раздела Рекомендации БСС ВИП");
        test_ku_vip();

        report("Проверяется Общее отображение раздела Рекомендации БСС Неавторизованный");
        test_without_login();
    }

    private void test_ku_vip() {
        loginBss()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSchoolWidgetIsPresent() //for ku and vip
                .checkMagazinesWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkReportsWidgetIsPresent()
                .checkFavoritesWidgetIsPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkFormsWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkSchoolWidgetIsPresent() //for ku and vip
                .checkMagazinesWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkReportsWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent()
                .checkWorkingDaysWidgetIsPresent()
                .checkWeekendDaysWidgetIsPresent()
                .checkNewsBlockIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()

                .logout();
    }
}

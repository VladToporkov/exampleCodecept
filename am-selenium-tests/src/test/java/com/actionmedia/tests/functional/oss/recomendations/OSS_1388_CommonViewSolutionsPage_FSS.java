package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 30/06/16.
 */
public class OSS_1388_CommonViewSolutionsPage_FSS extends AbstractDomainTest {

    private static String RUBRICATOR_NAME = "Все решения";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1388", testCaseVersion = "1")
    public void oss_1388_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение раздела Рекомендации ФСС КУ");
        test();

        report("Проверяется Общее отображение раздела Рекомендации ФСС Неавторизованный");
        test_without_login();
    }

    private void test() {
        loginFss()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkSchoolWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkFavoritesWidgetIsPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }

    private void test_without_login() {
        enterToFssWithoutLogin()
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkFormsWidgetIsPresent()
                .checkLawBaseWidgetIsPresent()
                .checkMagazinesWidgetIsPresent()
                .checkVideoWidgetIsPresent()
                .checkHandbookWidgetIsPresent()
                .checkSchoolWidgetIsPresent()
                .checkSeminarsWidgetIsPresent()
                .checkFavoritesWidgetIsNotPresent()
                .checkRubricatorButtonIsPresent(RUBRICATOR_NAME)
                .checkMyFavoritesRubricatorButtonIsNotPresent()

                .logout();
    }
}

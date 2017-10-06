package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/07/16.
 */
public class OSS_1397_WizardWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1397", testCaseVersion = "1")
    public void oss_1397_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Мастера ЮСС КУ");
        test();

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Проверяется Блоки Рекомендаций: Виджет Мастера ЮСС БУ");
        test();
    }

    private void test() {
        loginUss()
                .navigateToRecomendPage()
                .checkWizardWidgetIsPresent()
                .checkWizardWidgetFiveLinksArePresent()
                .checkWizardWidgetHasTitle()
                .checkWizardWidgetSolutionsCountIsPresent()

                .clickOnWizardWidgetFirstSolution()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnWizardWidgetSecondSolution()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnWizardWidgetThirdSolution()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnWizardWidgetFourthSolution()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnWizardWidgetFifthSolution()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnWizardWidgetClickOnTitle()
                .checkServicesTabIsSelected()

                .logout();
    }
}

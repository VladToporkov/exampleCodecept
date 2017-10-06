package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/07/16.
 */
public class OSS_733_ServicesWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-733", testCaseVersion = "1")
    public void oss_733_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Сервисы ОБР КУ");
        test();
    }

    private void test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkServicesWidgetThreeLinksArePresent()
                .checkServicesWidgetTitleIsPresent()

                .clickOnServicesWidgetFinanceLink()
                .checkDocumentIsOpened()

                .navigateToSolutionsPage()
                .clickOnServicesWidgetBudgetLink()
                .checkDocumentIsOpened()

                .navigateToSolutionsPage()
                .clickOnServicesWidgetExcelLink()
                .checkDocumentIsOpened()

                .navigateToSolutionsPage()
                .clickOnServicesWidgetTitleLink()
                .checkServicesTabIsSelected()

                .logout();
    }
}
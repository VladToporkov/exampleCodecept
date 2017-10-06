package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/07/16.
 */
public class OSS_1079_EstimatorsWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1079", testCaseVersion = "2")
    public void oss_1079_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Расчетчики КСС КУ");
        test();
    }

    private void test() {
        loginKss()
                .navigateToRecomendPage()
                .checkEstimatorsWidgetIsPresent()
                .checkEstimatorsWidgetLinksArePresent()
                .checkEstimatorsCountIsPresent()

                .clickOnEstimatorWidgetFirstEstimatorLink()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickOnEstimatorWidgetSecondEstimatorLink()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickOnEstimatorWidgetThirdEstimatorLink()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickOnEstimatorWidgetFourthEstimatorLink()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickOnEstimatorWidgetFifthEstimatorLink()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickOnEstimatorsWidgetTitle()
                .checkServicesTabIsSelected()

                .logout();
    }
}


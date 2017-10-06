package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_506_FssPromoOverallDisplay extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-506", testCaseVersion = "1")
    public void oss_506_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общее отображение страницы Промо ФСС КУ");
        fss_506_test();
    }

    private void fss_506_test() {
        loginFss()
                .navigateToPromoPage()

                .checkPromoPageDisplayed()

                .checkPromoPageLogoDisplayed()

                .checkNumberDisplayed()

                .checkTitleDisplayed()

                .checkAnswerDisplayed()

                .checkDemoButtonDisplayed()

                .checkSiteFeaturesDisplayed()

                .checkServicesDisplayed()

                .checkCourtDisplayed()

                .checkRecommendationsDisplayed()

                .checkFormsDisplayed()

                .checkBazaDisplayed()

                .checkMailDisplayed()

                .checkQuestionsDisplayed()

                .checkTrialDisplayed()

                .checkFooterDisplayed()

                .checkSideNavDisplayed();

        getFssBasePage()
                .logout();
    }
}
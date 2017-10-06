package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.noProduction;
import static com.actionmedia.autotest.Group.smoke;

public class OSS_505_UssPromoOverallDisplay extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-505", testCaseVersion = "2")
    public void oss_505_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общее отображение страницы Промо ЮСС КУ");
        uss_505_test();
    }

    private void uss_505_test() {
        loginUss()
                .navigateToPromoPage()

                .checkPromoPageDisplayed()

                .checkPromoPageLogoDisplayed()

                .checkNumberDisplayed()

                .checkLinksDisplayed()

                .checkTitleDisplayed()

                .checkAnswerDisplayed()

                .checkDemoButtonDisplayed()

                .checkSiteFeaturesDisplayed()

                .checkServicesDisplayed()

                .checkCourtDisplayed()

                .checkRecommendationsDisplayed()

                .checkBazaDisplayed()

                .checkMailDisplayed()

                .checkOpinionsDisplayed()

                .checkReviewsDisplayed()

                .checkQuestionsDisplayed()

                .checkTrialDisplayed()

                .checkFooterDisplayed()

                .checkSideNavDisplayed();

        getUssBasePage()
                .logout();
    }
}

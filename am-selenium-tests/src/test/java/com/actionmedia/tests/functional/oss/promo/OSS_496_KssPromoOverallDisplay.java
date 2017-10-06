package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_496_KssPromoOverallDisplay extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-496", testCaseVersion = "1")
    public void oss_496_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общее отображение Промо КСС КУ");
        kss_496_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общее отображение Промо КСС БУ");
        kss_496_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение Промо КСС ВИП");
        kss_496_test();
    }

    private void kss_496_test() {
        loginKss()
                .navigateToPromoPage()

                .checkPromoPageDisplayed()

                .checkPromoPageLogoDisplayed()

                .checkNumberDisplayed()

                .checkLinksDisplayed()

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

        getKssBasePage()
                .logout();
    }
}

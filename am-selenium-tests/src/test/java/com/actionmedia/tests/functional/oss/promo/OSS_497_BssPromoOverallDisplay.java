package com.actionmedia.tests.functional.oss.promo;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

public class OSS_497_BssPromoOverallDisplay extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-497", testCaseVersion = "1")
    public void oss_497_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общее отображение страницы Промо БСС КУ");
        bss_497_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общее отображение страницы Промо БСС ВИП");
        bss_497_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общее отображение страницы Промо БСС УПР");
        bss_497_test();
    }

    private void bss_497_test() {
        loginBss()
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

                .checkOtchetDisplayed()

                .checkCourtDisplayed()

                .checkRecommendationsDisplayed()

                .checkLawBaseDisplayed()

                .checkMailDisplayed()

                .checkVideoDisplayed()

                .checkOpinionsDisplayed()

                .checkBlockOpinionsIsPresent()

                .checkReviewsDisplayed()

                .checkQuestionsDisplayed()

                .checkTrialDisplayed()

                .checkFooterDisplayed()

                .checkSideNavDisplayed();

        getBssBasePage()
                .logout();
    }
}

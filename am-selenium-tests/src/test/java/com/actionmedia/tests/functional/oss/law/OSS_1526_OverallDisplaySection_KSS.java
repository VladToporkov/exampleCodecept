package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1526_OverallDisplaySection_KSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1526", testCaseVersion = "1")
    public void oss_1526_test() {
        //kss
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется раздел Правовая база КСС КУ");
        kss_1526_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Правовая база КСС ВИП");
        kss_1526_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется раздел Правовая база КСС БУ");
        kss_1526_test();
    }

    private void kss_1526_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkProfStandartsBlockIsPresent()
                .checkJudgmentBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkLaborDisputesIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodexRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}

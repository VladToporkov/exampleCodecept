package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_264_OverallDisplaySection extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-264", testCaseVersion = "1")
    public void oss_264_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется раздел Правовая база БСС КУ");
        bss_264_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Правовая база БСС ВИП");
        bss_264_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется раздел Правовая база БСС УПР");
        bss_264_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется раздел Правовая база БСС БУ");
        loginBss()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkBudgetKodeksBlockIsPresent()
                .checkTaxKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkJudgmentBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodeksBudgetRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void bss_264_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkTaxKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkJudgmentBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodeksRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}

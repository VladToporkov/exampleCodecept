package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1635_OverallDisplaySection_EHS extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1635", testCaseVersion = "1")
    public void oss_1635_test() {
        //ehs
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется раздел Правовая база ОТ КУ");
        ehs_1635_test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Правовая база ОТ ВИП");
        ehs_1635_test_vip();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется раздел Правовая база ОТ БАЗ");
        ehs_1635_test();
    }

    private void ehs_1635_test() {
        loginOT()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkFederalLawsBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkIndustryDocsBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkRubricatorButtonIsPresent("Законы и правила")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

    private void ehs_1635_test_vip() {
        loginOT()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkFederalLawsBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkIndustrialSafetyBlockIsPresent()
                .checkIndustryDocsBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkRubricatorButtonIsPresent("Законы и правила")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }

}
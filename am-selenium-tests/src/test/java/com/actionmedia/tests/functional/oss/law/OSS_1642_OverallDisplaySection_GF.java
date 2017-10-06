package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1642_OverallDisplaySection_GF extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1642", testCaseVersion = "1")
    public void oss_1642_test() {
        //gf
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется раздел Правовая база ГФ КУ");
        gf_1642_test();
    }

    private void gf_1642_test() {
        loginGF()
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

}


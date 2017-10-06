package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1528_OverallDisplaySection_FSS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1528", testCaseVersion = "1")
    public void oss_1528_test() {
        //fss
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется раздел Правовая база ФСС КУ");
        fss_1528_test();
    }

    private void fss_1528_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkTaxKodeksBlockIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkJudgmentBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodexRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}

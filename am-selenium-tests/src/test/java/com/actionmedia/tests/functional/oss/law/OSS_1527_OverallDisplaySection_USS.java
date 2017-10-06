package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1527_OverallDisplaySection_USS extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1527", testCaseVersion = "1")
    public void oss_1527_test() {
        //uss
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется раздел Правовая база ЮСС КУ");
        uss_1527_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется раздел Правовая база ЮСС ВИП");
        uss_1527_test();
    }

    private void uss_1527_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkCivilKodeksBlockIsPresent()
                .checkTaxKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodexRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAssistantButtonIsPresent()
                .logout();
    }
}

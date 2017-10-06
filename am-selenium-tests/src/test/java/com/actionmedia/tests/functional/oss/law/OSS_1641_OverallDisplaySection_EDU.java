package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1641_OverallDisplaySection_EDU extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1641", testCaseVersion = "1")
    public void oss_1641_test() {
        //edu
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется раздел Правовая база ОБР КУ");
        edu_1641_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Правовая база ОБР ВИП");
        edu_1641_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется раздел Правовая база ОБР БАЗ");
        edu_1641_test();
    }

    private void edu_1641_test() {
        loginEdu()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkLaborKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkIndustryDocsBlockIsPresent()
                .checkStandartsBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkAllKodeksBudgetRubricatorButtonIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .logout();
    }
}

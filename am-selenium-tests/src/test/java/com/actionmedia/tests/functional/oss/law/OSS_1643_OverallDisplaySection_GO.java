package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 24/05/16.
 */
public class OSS_1643_OverallDisplaySection_GO extends AbstractDomainTest {

    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-1643", testCaseVersion = "1")
    public void oss_1643_test() {
        //go
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется раздел Правовая база ГЗ КУ");
        go_1643_test();

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Правовая база ГЗ ВИП");
        go_1643_test();

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется раздел Правовая база ГЗ БАЗ");
        go_1643_test();
    }

    private void go_1643_test() {
        loginGo()
                .navigateToLawBasePage()
                .checkSectionTitleIsPresent()
                .checkCivilKodeksBlockIsPresent()
                .checkOtherKodeksBlockIsPresent()
                .checkLegislationBlockIsPresent()
                .checkJudgmentBlockIsPresent()
                .checkRegionBlockIsPresent()
                .checkMainDocsBlockIsPresent()
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkRubricatorButtonIsPresent("Основные акты")
                .logout();
    }
}
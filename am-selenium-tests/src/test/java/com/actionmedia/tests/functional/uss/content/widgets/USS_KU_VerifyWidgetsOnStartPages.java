package com.actionmedia.tests.functional.uss.content.widgets;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class USS_KU_VerifyWidgetsOnStartPages extends AbstractDomainTest {

    @Test
    @LoginAs(key = "uss.user.commercial")
    public void uss_ku_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkYellowPlateWidget()
                .checkContentInLawBaseWidgetIsPresent()
                .checkFormsWidget()
                .checkMagazinesWidget()
                .checkContractsWidget()
                .checkVideosWidget()
                .checkDictionaryWidget()
                .checkWizardsWidget()
                .checkBannerWidget()
                .checkNewsWidget()
                .logout();
    }
}

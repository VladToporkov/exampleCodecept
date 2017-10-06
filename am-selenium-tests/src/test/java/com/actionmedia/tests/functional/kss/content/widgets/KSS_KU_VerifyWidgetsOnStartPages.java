package com.actionmedia.tests.functional.kss.content.widgets;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class KSS_KU_VerifyWidgetsOnStartPages extends AbstractDomainTest {

    @Test
    @LoginAs(key = "kss.user.commercial")
    public void kss_ku_test() {
        loginKss()
                .navigateToAnswersPage()
                .checkYellowPlateWidget()
                .checkContentInLawBaseWidgetIsPresent()
                .checkFormsWidget()
                .checkMagazinesWidget()
                .checkVideosWidget()
                .checkDictionaryWidget()
                .checkWizardsWidget()
                .checkBannerWidget()
                .checkNewsWidget()
                .logout();
    }
}

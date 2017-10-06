package com.actionmedia.tests.functional.bss.content.widgets;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class BSS_KU_VerifyWidgetsOnStartPage extends AbstractDomainTest {

    @Test
    @LoginAs(key = "bss.user.commercial")
    public void bss_ku_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkYellowPlateWidget()
                .checkContentInLawBaseWidgetIsPresent()
                .checkFormsWidget()
                .checkMagazinesWidget()
                .checkDictionaryWidget()
                .checkVideosWidget()
                .checkNewsWidget()
                .logout();
    }
}

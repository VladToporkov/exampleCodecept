package com.actionmedia.tests.functional.uss.content.widgets;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

/**
 * User: n.tyukavkin
 * Date: 09.02.14
 * Time: 15:48
 */
public class USS_VIP_VerifyWidgetsOnStartPages extends AbstractDomainTest {

    @Test
    @LoginAs(key = "uss.user.vip")
    @Version(section = "doc")
    public void uss_doc_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkYellowPlateWidget()
                .checkContentInLawBaseWidgetIsPresent()
                .checkFormsWidget()
                .checkMagazinesWidget()
                .checkVideosWidget()
                .checkDictionaryWidget()
                .checkWizardsWidget()
                .checkNewsWidget()
                .logout();
    }
}

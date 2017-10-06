package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 12.12.13
 * Time: 12:08
 */
public class BSS_10_VerifyLawBaseBlock extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-10", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_10_test() {
        loginBss()
                .navigateToRecomendPage()
                .checkLawBaseWidgetIsPresent()
                .checkLawBaseWidgetTitleIsPresent()
                .checkKodeksOrderInLawBaseBlock()
                .checkLawBaseWidgetSearchInputIsPresent()
                .checkLawBaseWidgetNewDocumentCounterIsPresent()

                .checkLawBaseWidgetLinksCodes()
                .clickLawBaseWidgetLinkTitle()
                .checkDefaultStateLawBasePage()
                .logout();
    }
}

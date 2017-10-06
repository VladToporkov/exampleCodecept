package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

public class BSS_28_VerifyAboutSystemPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-28", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_28_test() {
        loginBss()
                .clickAboutSystemLink()

                .checkPageScroll()

                .clickRandomAuthorPhoto()
                .checkAuthorPopUpIsPresent()

                .clickBuyTab()
                .checkBuyTabIsSelected()
                .checkBuyTabIsOpened()
                .checkBuyContentIsPresent()

                .clickPresentationTab()
                .checkPresentationTabIsSelected()
                .checkPresentationTabIsOpened()
                .checkPresentationContentIsPresent()

                .clickTryTrialTab()
                .checkTryTrialTabIsSelected()
                .checkTryTrialTabIsOpened()
                .checkTryTrialContentIsPresent();
    }
}

package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

public class USS_VerifyAboutSystemPage extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .clickAboutSystemLink()

                .checkPageScroll()

                .clickBuyTab()
                .checkBuyTabIsSelected()
                .checkBuyTabIsOpened()
                .checkBuyContentIsPresent()

                .clickOrderCallTab()
                .checkOrderCallTabIsSelected()
                .checkOrderCallTabIsOpened()
                .checkOrderCallContentIsPresent()

                .clickTryTrialTab()
                .checkTryTrialTabIsSelected()
                .checkTryTrialTabIsOpened()
                .checkTryTrialContentIsPresent()
                .logout();
    }
}

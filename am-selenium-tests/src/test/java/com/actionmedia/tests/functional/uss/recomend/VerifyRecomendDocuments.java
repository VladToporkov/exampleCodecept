package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.10.13
 * Time: 11:56
 */
public class VerifyRecomendDocuments extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkInfoBarWidget()
                .checkScrolling()
                .checkPrintButtonIsPresent()
                .checkWordButtonIsPresent()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()
                .clickMailButton()
                .checkInCut()
                .logout();
    }
}

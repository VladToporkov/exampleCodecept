package com.actionmedia.tests.functional.bss.services;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.04.2014
 * Time: 16:57
 */
public class BSS_140_VerifyCalculator extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-150", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_140_test() {
        loginBss()
                .navigateToServicesPage()

                .clickRubricatorButton()
                .clickCalculatorSection()
                .clickCalculatorByNumber(1)
                .inputAllFieldInCalculator()
                .clickCalculateButton()
                .checkErrorsAreNotPresent()
                .checkBillIsPresent()

                .clickRubricatorButton()
                .clickCalculatorSection()
                .clickCalculatorByNumber(2)
                .inputAllFieldInCalculator()
                .clickCalculateButton()
                .inputPower("100")
                .inputDateRegistration("01-01-2010")
                .clickCalculateButton()
                .checkErrorsAreNotPresent()
                .checkBillIsPresent()

                .clickRubricatorButton()
                .clickCalculatorSection()
                .clickCalculatorByNumber(3)
                .inputAllFieldInCalculator()
                .clickCalculateButton()
                .checkErrorsAreNotPresent()
                .checkBillIsPresent()

                .logout();
    }
}

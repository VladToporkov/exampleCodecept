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
public class BSS_143_VerifyWizards extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-143", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_143_test() {
        loginBss()
                .navigateToServicesPage()
                .clickRandomWizard()
                .checkDocumentIsNotEmpty()

                .clickRubricatorButton()
                .clickRandomWizard()
                .clickRandomArticle()
                .checkDocumentIsNotEmpty()

                .clickRandomQuestionInWizardOnStepOne()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepTwo()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepThree()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepFour()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepFive()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepSix()
                .checkPetalsCountIsChanged()
                .clickRandomQuestionInWizardOnStepSeven()
                .checkPetalsCountIsChanged()
                .logout();
    }
}

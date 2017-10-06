package com.actionmedia.tests.functional.bss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 23.04.2014
 * Time: 12:29
 */
public class BSS_156_VerifySendLinkForm extends AbstractDomainTest {

    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "BSS-156", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_156_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()

                .navigateToFormsPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMailButtonIsNotPresent()

                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMailButtonIsNotPresent()

                .navigateToMagazinesPage()
                .clickRubricatorButton()
                .clickRandomMagazine()
                .clickRandomArticle()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()

                .clickRubricatorButton()
                .clickRandomBook()
                .clickRandomArticle()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()

                .navigateToVideoPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkMailButtonIsNotPresent()

                .navigateToServicesPage()
                .clickRubricatorButton()
                .clickRandomWizard()
                .clickRandomArticle()
                .checkMailButtonIsPresent()
                .clickMailButton()
                .checkMailFormIsPresent()
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 10.04.2014
 * Time: 16:22
 */
public class USS_199_VerifyMainHeader extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-199", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_199_test() {
        loginUss()
                .navigateToFormsPage()
                .checkFormsTabIsSelected()
                .navigateToRecomendPage()
                .checkRecomendTabIsSelected()
                .checkSectionOrderInMainHeader()
                .checkLogoIsPresent()
                .checkBalloonPhraseIsPresent()
                .checkAskExpertButtonIsPresent()
                .checkAboutSystemButtonIsPresent()
                .checkProfileButtonIsPresent()

                .navigateToDictionaryPage()
                .clickLogoButton()
                .checkDefaultStateRecomendPage()

                .checkPhraseIsChangedAfterClick()

                .navigateToLawBasePage()
                .checkLawBaseTabIsSelected()
                .navigateToFormsPage()
                .checkFormsTabIsSelected()
                .navigateToDictionaryPage()
                .checkDictionaryTabIsSelected()
                .navigateToMagazinesPage()
                .checkMagazineTabIsSelected()
                .navigateToVideoPage()
                .checkVideoTabIsSelected()
                .navigateToServicesPage()
                .checkServicesTabIsSelected()

                .clickAskExpertLink()
                .checkSendWindowsIsEnabled()

                .clickProfileLink()
                .checkProfilePageIsOpened()

                .clickAboutSystemLink()
                .checkAboutSystemPageIsOpened()
                .returnToMainPage()

                .checkMainHeaderHasDefaultSize()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .checkMainHeaderHasMinSize()

                .clickMoreButton()
                .checkMainHeaderHasMaxSize()

                .clickMoreButton()
                .checkMainHeaderHasMinSize()
                .logout();
    }
}

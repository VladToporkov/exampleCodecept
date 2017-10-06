package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 02.12.13
 * Time: 17:46
 */
public class KSS_64_VerifyKodeksDocument extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-64", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_64_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkExtendedSearchFormButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkApplicationsWidgetIsPresent()
                .checkInfoBarWidgetIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkMailButtonInKodeksIsPresent()
                .checkReferencesBallIsPresent()
                .checkSoderIsPresent()
                .checkRubricatorButtonIsPresent("Все кодексы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

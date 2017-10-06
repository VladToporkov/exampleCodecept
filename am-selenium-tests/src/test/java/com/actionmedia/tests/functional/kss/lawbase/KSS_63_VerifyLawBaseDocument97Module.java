package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 12:10
 */
public class KSS_63_VerifyLawBaseDocument97Module extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-63", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_63_test() {
        String documentUrl = getFullDocumentUrlByKey("kss.97.module");
        loginKss()
                .navigateToLawBasePage()
                .openDocumentByUrl(documentUrl)
                .checkDocumentIsOpened()
                .checkExtendedSearchFormButtonIsPresent()
                .checkDocumentVersionIsPresent()
                .checkHelpWidgetIsPresent()
                .checkApplicationsWidgetIsPresent()
                .checkInfoBarWidgetIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все кодексы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

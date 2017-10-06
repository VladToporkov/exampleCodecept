package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 12:10
 */
public class KSS_62_VerifyLawBaseDocument99Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-62", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_62_test() {
        String documentUrl = getFullDocumentUrlByKey("kss.99.module");
        loginKss()
                .navigateToLawBasePage()
                .openDocumentByUrl(documentUrl)
                .checkDocumentIsOpened()
                .checkExtendedSearchFormButtonIsPresent()
                .checkHelpWidgetIsPresent()
                .checkApplicationsWidgetIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkPrintButtonInKodeksIsPresent()
                .checkMailButtonInKodeksIsPresent()
                .checkRubricatorButtonIsPresent("Все кодексы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

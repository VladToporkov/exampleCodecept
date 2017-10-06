package com.actionmedia.tests.functional.kss.answers;

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
public class KSS_55_VerifyAnswersDocument131Module extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-55", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_55_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByUrl(getDocumentUrlByKey("kss.131.module"))
                .checkDocumentIsOpened()
                .checkDocumentVersionIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

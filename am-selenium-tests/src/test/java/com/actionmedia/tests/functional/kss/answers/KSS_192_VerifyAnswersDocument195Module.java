package com.actionmedia.tests.functional.kss.answers;

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
public class KSS_192_VerifyAnswersDocument195Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-192", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_192_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId("#/document/195/10025")
                .checkDocumentIsOpened()
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

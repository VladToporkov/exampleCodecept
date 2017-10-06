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
public class KSS_47_VerifyAnswersDocument130Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-47", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_47_test() {
        loginKss()
                .navigateToAnswersPage()
                .openModuleByNumber("130")
                .checkDocumentIsOpened()
                .checkHelpWidgetIsPresent()
                .checkSearchInTextWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkMailButtonIsPresent()
                .checkSoderIsPresent()
                .checkRubricatorButtonIsPresent("Все ответы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

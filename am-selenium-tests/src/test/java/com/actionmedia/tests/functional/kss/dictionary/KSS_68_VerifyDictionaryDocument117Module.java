package com.actionmedia.tests.functional.kss.dictionary;

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
public class KSS_68_VerifyDictionaryDocument117Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-68", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_68_test() {
        loginKss()
                .navigateToDictionaryPage()
                .openModuleByNumber("117")
                .checkDocumentIsOpened()
                .checkSearchInTextWidgetIsPresent()
                .checkInfoBarWidgetIsPresent()
                .checkWordButtonIsPresent()
                .checkPrintButtonIsPresent()
                .checkRubricatorButtonIsPresent("Весь справочник")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.forms;

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
public class KSS_66_VerifyFormsDocument118Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-66", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_66_test() {
        loginKss()
                .navigateToFormsPage()
                .openModuleByNumber("118")
                .checkDocumentIsOpened()
                .checkDocumentVersionIsPresent()
                .checkInfoBarWidgetIsPresent()
                .checkPrintButtonIsPresent()
                .checkDownloadFormButtonIsPresent()
                .checkDownloadExampleButtonIsPresent()
                .checkCommentsArePresentOld()
                .checkRubricatorButtonIsPresent("Все формы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .logout();
    }
}

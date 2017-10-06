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
public class KSS_67_VerifyFormsDocument140Module extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-67", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_67_test() {
        loginKss()
                .navigateToFormsPage()
                .openDocumentByModuleIdAndDocId("#/document/140/420")
                .checkDocumentIsOpened()
                .checkInfoBarWidgetIsPresent()
                .checkPrintButtonIsPresent()
                .checkDownloadFormButtonIsPresent()
                .checkRubricatorButtonIsPresent("Все формы")
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkAddToFavoritesButtonsForDocumentArePresent()
                .checkFormsPreview()
                .logout();
    }
}

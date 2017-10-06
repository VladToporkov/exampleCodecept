package com.actionmedia.tests.functional.kss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 12:10
 */
public class KSS_189_VerifyFormsDocument121Module extends AbstractDomainTest {

    @Test(groups = {smoke, inTesting})
    @TestLink(testCaseId = "KSS-189", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_189_test() {
        String documentUrl = getFullDocumentUrlByKey("kss.121.module");
        loginKss()
                .navigateToFormsPage()
                .openDocumentByUrl(documentUrl)
                .checkDocumentIsOpened()
                .checkDocumentVersionIsPresent()
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

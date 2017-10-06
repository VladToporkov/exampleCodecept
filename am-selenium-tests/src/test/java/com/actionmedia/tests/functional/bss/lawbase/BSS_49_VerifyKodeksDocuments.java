package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 17.10.13
 * Time: 14:48
 */
public class BSS_49_VerifyKodeksDocuments extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-49", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_49_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .checkInfoBarWidgetWork()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkMailButtonInKodeksIsPresent()

                .checkScrolling()
                .checkStickyHeaderScrolling()
                .checkTableOfContents()

                .checkReferencesForChapter()
                .checkReferencesForArticle()
                .checkReferencesForParagraph()

                .checkLinksFromNotebookForChapter()
                .checkLinksFromNotebookForArticle()
                .checkLinksFromNotebookForParagraph()

                .checkEditLinksForChapter()
                .checkEditLinksForArticle()
                .checkEditLinksForParagraph()
                .logout();
    }
}

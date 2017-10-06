package com.actionmedia.tests.functional.uss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 17.10.13
 * Time: 14:48
 */
public class USS_115_VerifyKodeksDocuments extends AbstractDomainTest {

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "USS-115", testCaseVersion = "1")
    @LoginAs(key = "uss.user.commercial")
    public void uss_115_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .scrollAllDocument()
                .checkInfoBarWidgetWork()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkMailButtonInKodeksIsPresent()

                .checkScrolling()
                .checkStickyHeader()
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

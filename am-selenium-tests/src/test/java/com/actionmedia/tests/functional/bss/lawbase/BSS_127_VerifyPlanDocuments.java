package com.actionmedia.tests.functional.bss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 21.10.13
 * Time: 9:45
 */
public class BSS_127_VerifyPlanDocuments extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-127", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_127_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomPBU()
                .clickRandomArticle()
                .scrollAllDocument()

                .checkInfoBarWidgetWork()
                .checkPrintButtonInKodeksIsPresent()
                .checkWordButtonInKodeksIsPresent()
                .checkMailButtonInKodeksIsPresent()
                .clickMailButtonInKodeks()
                .checkMailFormIsPresent()
                .clickMailButtonInKodeks()

                .checkTableOfContentsForPlan()

                .checkReferencesForChapter()
                .checkReferencesForArticle()
                .checkReferencesForParagraph()
                .checkLinksFromNotebookForChapter()
                .checkLinksFromNotebookForArticle()
                .checkLinksFromNotebookForParagraph()
                .logout();
    }
}

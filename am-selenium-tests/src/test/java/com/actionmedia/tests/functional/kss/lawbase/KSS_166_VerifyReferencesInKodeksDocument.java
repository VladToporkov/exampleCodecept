package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.04.2014
 * Time: 16:16
 */
public class KSS_166_VerifyReferencesInKodeksDocument extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-166", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_166_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomKodeks()
                .clickRandomArticle()
                .scrollAllDocument()

                .checkReferencesForChapter()
                .checkReferencesForArticle()
                .checkReferencesForParagraph()

                .checkLinksFromNotebookForChapter()
                .checkLinksFromNotebookForArticle()
                .checkLinksFromNotebookForParagraph()
                .logout();
    }
}

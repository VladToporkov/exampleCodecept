package com.actionmedia.tests.functional.kss.search.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 18:02
 */
public class KSS_109_VerifySearchOnFormsBlock extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-109", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_109_test() {
        loginKss()
                .navigateToAnswersPage()

                .checkSearchBoxInFormsBlockIsPresent()

                .checkTextInputInSearchBoxOnForms()

                .checkSubmitButtonOnSearchBoxInFormsBlock(QUERY)

                .inputTextInSearchBoxOnFormsBlock(QUERY)
                .checkHintsIsPresentOnFormsBlock()
                .clickHintWithJumpOnFormsBlock()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .inputTextInSearchBoxOnFormsBlock(QUERY)
                .clickRandomHintOnFormsBlock()
                .checkSearchResultOnFormsPageIsOpened()
                .logout();
    }
}

package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 11:37
 */
public class FSS_107_VerifySearchBoxOnSolutionPage extends AbstractDomainTest {

    private static final String QUERY_1 = "форма";
    private static final String QUERY_2 = "з";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-107", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_107_test() {
        loginFss()
                .navigateToSolutionsPage()
                .checkSearchBoxPresentOnSolutionsPage()
                .checkTextInputInSearchBox()
                .checkSearchButtonFunctionalityOnSearchBox(QUERY_1)

                .inputTextInSearchBox(QUERY_1)
                .checkHintsWithJumpIsPresent()
                .clickHintWithJump()
                .checkDocumentIsOpened()

                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY_2)
                .checkHintsIsPresent()
                .clickHint()
                .checkSearchResultIsPresent(false);
    }
}

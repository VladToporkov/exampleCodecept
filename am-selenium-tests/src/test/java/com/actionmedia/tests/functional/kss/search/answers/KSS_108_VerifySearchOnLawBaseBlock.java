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
public class KSS_108_VerifySearchOnLawBaseBlock extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-108", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_108_test() {
        loginKss()
                .navigateToAnswersPage()

                .checkSearchBoxInLawBaseBlockIsPresent()

                .checkTextInputInSearchBoxOnLawBase()

                .checkSubmitButtonOnSearchBoxInLawBaseBlock(QUERY)

                .inputTextInSearchBoxOnLawBaseBlock(QUERY)
                .checkHintsIsPresentOnLawBaseBlock()
                .clickHintWithJumpOnLawBaseBlock()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .inputTextInSearchBoxOnLawBaseBlock(QUERY)
                .clickRandomHintOnLawBaseBlock()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .logout();
    }
}

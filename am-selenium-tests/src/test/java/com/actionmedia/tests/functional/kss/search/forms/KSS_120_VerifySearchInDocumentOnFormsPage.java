package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_120_VerifySearchInDocumentOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-120", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_120_test() {
        loginKss()
                .navigateToFormsPage()
                .clickRandomDocumentLink()

                .checkSearchBoxPresentOnFormsPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomDocumentLink()

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnFormsPage()
                .checkDocumentIsOpened()

                .navigateToFormsPage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnFormsPage()
                .checkSearchResultOnFormsPageIsOpened()
                .logout();
    }
}

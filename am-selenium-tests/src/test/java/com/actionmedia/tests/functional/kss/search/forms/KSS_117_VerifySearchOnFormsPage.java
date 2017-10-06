package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_117_VerifySearchOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-117", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_117_test() {
        loginKss()
                .navigateToFormsPage()

                .checkSearchBoxPresentOnFormsPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnFormsPage()
                .checkDocumentIsOpened()

                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnFormsPage()
                .checkSearchResultOnFormsPageIsOpened()
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 31.10.13
 * Time: 11:14
 */
public class VerifySearchInDocumentOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
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

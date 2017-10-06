package com.actionmedia.tests.functional.uss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class VerifySearchOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
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

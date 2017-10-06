package com.actionmedia.tests.functional.uss.search.wizards;

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
public class VerifySearchInDocumentOnWizardsPage extends AbstractDomainTest {

    private static final String QUERY = "договор";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToWizardsPage()
                .clickRandomDocumentLink()

                .checkSearchBoxPresentOnWizardsPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomDocumentLink()

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnWizardsPage()
                .checkDocumentIsOpened()

                .navigateToWizardsPage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnWizardsPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .logout();
    }
}

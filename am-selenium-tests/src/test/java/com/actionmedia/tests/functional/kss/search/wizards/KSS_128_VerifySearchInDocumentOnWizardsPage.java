package com.actionmedia.tests.functional.kss.search.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_128_VerifySearchInDocumentOnWizardsPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-128", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_128_test() {
        loginKss()
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
                .inputTextInSearchBox("отпуск")
                .clickRandomHintOnWizardsPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.search.wizards;

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
public class KSS_127_VerifySearchOnWizardsPage extends AbstractDomainTest {

    private static final String QUERY_1 = "закон";
    private static final String QUERY_2 = "отпуск";

//    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-127", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_127_test() {
        loginKss()
                .navigateToWizardsPage()

                .checkSearchBoxPresentOnWizardsPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY_1)

                .inputTextInSearchBox(QUERY_1)
                .checkHintsIsPresent()
                .clickHintWithJumpOnWizardsPage()
                .checkDocumentIsOpened()

                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY_2)
                .clickRandomHintOnWizardsPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .logout();
    }
}

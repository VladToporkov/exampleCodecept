package com.actionmedia.tests.functional.uss.search.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchQualityWizardsPage extends AbstractDomainTest {

    private static final String QUERY = "по собственному желанию";
    private static final String EXPECTED_RESULT = "Оформление увольнения по собственному желанию";

    //    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT)
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.search.wizards;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_129_VerifySearchQualityWizardsPage extends AbstractDomainTest {

    private static final String QUERY = "по собственному желанию";
    private static final String EXPECTED_RESULT = "Оформление увольнения по собственному желанию";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-129", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_129_test() {
        loginKss()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT)
                .logout();
    }
}

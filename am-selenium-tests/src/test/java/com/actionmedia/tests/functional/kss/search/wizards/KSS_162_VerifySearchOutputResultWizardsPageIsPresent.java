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
public class KSS_162_VerifySearchOutputResultWizardsPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "отпуск";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-162", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_162_test() {
        loginKss()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .checkShowRelevanceLinkIsPresent()
                .checkRelevanceLinkWorks()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)
                .logout();
    }
}

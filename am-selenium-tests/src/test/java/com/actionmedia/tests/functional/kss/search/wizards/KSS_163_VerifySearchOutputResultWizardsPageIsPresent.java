package com.actionmedia.tests.functional.kss.search.wizards;

import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_163_VerifySearchOutputResultWizardsPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "отпуск";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-163", testCaseVersion = "1")
    public void kss_163_test() {
        enterToKssWithoutLogin()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)
                .logout();
    }
}

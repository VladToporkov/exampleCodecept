package com.actionmedia.tests.functional.kss.search.magazines;

import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_159_VerifySearchOutputResultMagazinesPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "главный бухгалтер";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-159", testCaseVersion = "1")
    public void kss_159_test() {
        enterToKssWithoutLogin()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)

                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

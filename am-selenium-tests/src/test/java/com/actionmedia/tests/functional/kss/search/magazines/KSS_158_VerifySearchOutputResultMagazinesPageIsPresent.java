package com.actionmedia.tests.functional.kss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_158_VerifySearchOutputResultMagazinesPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "главный бухгалтер";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-158", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_158_test() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkShowRelevanceLinkIsPresent()
                .checkRelevanceLinkWorks()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)

                .checkSearchQueryIsHighlightedInDocument(QUERY)

                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

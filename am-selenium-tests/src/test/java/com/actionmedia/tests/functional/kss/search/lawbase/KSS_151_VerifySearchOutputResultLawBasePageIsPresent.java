package com.actionmedia.tests.functional.kss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_151_VerifySearchOutputResultLawBasePageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "ограничения на трудоустройство";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-151", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_151_test() {
        loginKss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
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

package com.actionmedia.tests.functional.kss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_156_VerifySearchOutputResultDictionaryPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "прием на работу";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-156", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_156_test() {
        loginKss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
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

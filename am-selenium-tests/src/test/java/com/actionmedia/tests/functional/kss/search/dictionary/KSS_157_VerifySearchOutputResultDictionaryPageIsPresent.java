package com.actionmedia.tests.functional.kss.search.dictionary;

import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_157_VerifySearchOutputResultDictionaryPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "прием на работу";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-157", testCaseVersion = "1")
    public void kss_157_test() {
        enterToKssWithoutLogin()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)

                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

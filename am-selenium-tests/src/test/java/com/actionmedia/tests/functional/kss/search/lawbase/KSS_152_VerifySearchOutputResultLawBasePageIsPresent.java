package com.actionmedia.tests.functional.kss.search.lawbase;

import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_152_VerifySearchOutputResultLawBasePageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "ограничения на трудоустройство";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-152", testCaseVersion = "1")
    public void kss_152_test() {
        enterToKssWithoutLogin()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)

                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

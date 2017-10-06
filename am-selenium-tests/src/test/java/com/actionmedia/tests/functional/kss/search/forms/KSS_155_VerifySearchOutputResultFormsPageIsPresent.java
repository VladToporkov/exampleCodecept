package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_155_VerifySearchOutputResultFormsPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "должностная инструкция";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-155", testCaseVersion = "1")
    public void kss_155_test() {
        enterToKssWithoutLogin()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()

                .checkSearchQueryIsHighlighted(QUERY)

                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

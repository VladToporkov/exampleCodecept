package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_154_VerifySearchOutputResultFormsPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "должностная инструкция";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-154", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_154_test() {
        loginKss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
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

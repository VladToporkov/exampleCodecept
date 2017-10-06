package com.actionmedia.tests.functional.kss.search.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_149_VerifySearchOutputResultAnswerPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "ограничения на трудоустройство";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-149", testCaseVersion = "1")
    @LoginAs(key = "kss.user.expert")
    public void kss_149_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()
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

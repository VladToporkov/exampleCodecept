package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 09:48
 */
public class FSS_187_VerifySearchOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "закон о трансфертном ценообразовании";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-187", testCaseVersion = "1")
    @LoginAs(key = "fss.user.expert")
    public void fss_187_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkSearchBoxPresentOnLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)

                .checkSearchFiltersArePresent()

                .checkRandomLinksOnSearchResultPage()

                .checkWordFromQueryIsHighlighted(QUERY)
                .checkWordFromQueryIsHighlightedInDocument(QUERY)

                .checkScrollingOnSearchResultPage()
                .checkSearchResultsAreNotRepeated()

                .checkSearchWithStandardCheckboxIsPresent()
                .checkShowRelevanceLinkCheckboxIsPresent()
                .checkSearchTypesArePresent()

                .clickShowRelevanceLink()
                .checkRelevanceAreDisplayed();
    }
}

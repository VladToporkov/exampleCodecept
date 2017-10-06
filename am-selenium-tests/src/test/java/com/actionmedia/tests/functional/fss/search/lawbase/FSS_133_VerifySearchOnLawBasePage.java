package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 15.11.13
 * Time: 09:48
 */
public class FSS_133_VerifySearchOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "закон о трансфертном ценообразовании";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-133", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_133_test() {
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
                .checkSearchResultsAreNotRepeated();
    }
}

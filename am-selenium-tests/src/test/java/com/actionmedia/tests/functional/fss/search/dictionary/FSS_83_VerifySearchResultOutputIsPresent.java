package com.actionmedia.tests.functional.fss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 14:05
 */
public class FSS_83_VerifySearchResultOutputIsPresent extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-83", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_83_test() {
        loginFss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkSearchFiltersArePresent()

                .checkRandomLinksOnSearchResultPage()

                .checkWordFromQueryIsHighlighted(QUERY)
                .checkWordFromQueryIsHighlightedInDocument(QUERY)

                .checkScrollingOnSearchResultPage()
                .checkSearchResultsAreNotRepeated();
    }
}

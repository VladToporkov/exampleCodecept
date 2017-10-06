package com.actionmedia.tests.functional.fss.search.magazines;

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
public class FSS_137_VerifySearchResultOutputIsPresent extends AbstractDomainTest {

    private static final String QUERY = "главбух";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-137", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_137_test() {
        loginFss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkSearchFiltersArePresent()

                .checkRandomLinksOnSearchResultPage()

                .checkWordFromQueryIsHighlighted(QUERY)
                .checkWordFromQueryIsHighlightedInDocument(QUERY)

                .checkScrollingOnSearchResultPage()
                .checkSearchResultsAreNotRepeated();
    }
}

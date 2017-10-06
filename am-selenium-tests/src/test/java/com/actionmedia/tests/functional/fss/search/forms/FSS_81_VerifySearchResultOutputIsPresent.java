package com.actionmedia.tests.functional.fss.search.forms;

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
public class FSS_81_VerifySearchResultOutputIsPresent extends AbstractDomainTest {

    private static final String QUERY = "регламент бюджетирования";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-81", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_81_test() {
        loginFss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnFormsPageIsOpened()
                .checkSearchFiltersArePresent()

                .checkRandomLinksOnSearchResultPage()

                .checkWordFromQueryIsHighlighted(QUERY)
                .checkWordFromQueryIsHighlightedInDocument(QUERY)

                .checkScrollingOnSearchResultPage()
                .checkSearchResultsAreNotRepeated();
    }
}

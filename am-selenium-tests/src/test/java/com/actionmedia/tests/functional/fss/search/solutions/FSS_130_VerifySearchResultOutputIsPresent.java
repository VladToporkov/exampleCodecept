package com.actionmedia.tests.functional.fss.search.solutions;

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
public class FSS_130_VerifySearchResultOutputIsPresent extends AbstractDomainTest {

    private static final String QUERY = "бюджетное учреждение";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-130", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_130_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnSolutionsPageIsOpened()
                .checkSearchFiltersArePresent()

                .checkRandomLinksOnSearchResultPage()

                .checkWordFromQueryIsHighlighted(QUERY)
                .checkWordFromQueryIsHighlightedInDocument(QUERY)

                .checkScrollingOnSearchResultPage()
                .checkSearchResultsAreNotRepeated();
    }
}

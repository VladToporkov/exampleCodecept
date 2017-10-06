package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 13:51
 */
public class BSS_41_VerifySearchInDictionary extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-41", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_41_test() {
        loginBss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()

                .checkLinksFromSearchResultPage()
                .checkSearchQueryIsHighlighted(QUERY)
                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

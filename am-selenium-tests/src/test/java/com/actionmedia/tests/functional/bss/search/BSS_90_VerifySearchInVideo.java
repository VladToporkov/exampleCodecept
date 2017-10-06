package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 08.07.2014
 * Time: 00:51
 */
public class BSS_90_VerifySearchInVideo extends AbstractDomainTest {

    private static final String QUERY = "документ";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-90", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_90_test() {
        loginBss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnVideosPageIsOpened()

                .checkLinksFromSearchResultPage()
                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

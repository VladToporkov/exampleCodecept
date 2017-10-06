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
 * Time: 14:43
 */
public class BSS_206_VerifySearchResultIsNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqweqweqwe";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-206", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_206_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsNotPresent()

                .checkLinksOnTypo()
                .logout();
    }
}

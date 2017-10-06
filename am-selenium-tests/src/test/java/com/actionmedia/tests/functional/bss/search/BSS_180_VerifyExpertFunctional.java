package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 25.04.2014
 * Time: 15:14
 */
public class BSS_180_VerifyExpertFunctional extends AbstractDomainTest {

    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "BSS-180", testCaseVersion = "3")
    @LoginAs(key = "bss.user.expert")
    public void bss_180_test() {
        loginBss()
                .navigateToRecomendPage()
                .inputTextInSearchBox("4-фсс")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()
                .checkNumberAroundSearchResultItemIsPresent()
                .checkNumbersAroundSearchResultAreSortedAscending()
                .checkSearchTypeAroundSearchResultItemIsPresent()

                .checkShowRelevanceLinkIsPresent()
                .checkSearchWithStandardQueryCheckBoxIsPresent()
                .checkSearchWithStandardQueryCheckBoxIsSelected()

                .clickShowRelevanceLink()
                .checkRelevanceArePresent()
                .logout();
    }
}

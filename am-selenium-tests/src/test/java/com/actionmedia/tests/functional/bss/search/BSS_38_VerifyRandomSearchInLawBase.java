package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 07.07.2014
 * Time: 23:51
 */
public class BSS_38_VerifyRandomSearchInLawBase extends AbstractDomainTest {

    private static final String QUERY = "закон об образовании";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-38", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_38_test() {
        loginBss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .checkStatusFilterSelectedByName("Все статусы")
                .checkDepartmentFilterSelectedByName("Все документы")
                .checkSearchResultItemList()

                .checkLinksFromSearchResultPage()
                .checkScrollingSearchResult()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

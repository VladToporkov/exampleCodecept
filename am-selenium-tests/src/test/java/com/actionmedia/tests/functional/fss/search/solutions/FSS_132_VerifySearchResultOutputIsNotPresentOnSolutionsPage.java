package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 18.11.13
 * Time: 14:05
 */
public class FSS_132_VerifySearchResultOutputIsNotPresentOnSolutionsPage extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-132", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_132_test() {
        loginFss()
                .navigateToSolutionsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnSolutionsPageIsNotPresent()

                .clickRubricatorLink()
                .checkRubricatorIsOpened()
                .closeAndNavigateToSearchResultPage()

                .checkRandomLinksFromPopularBlock();
    }
}

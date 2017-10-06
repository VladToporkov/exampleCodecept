package com.actionmedia.tests.functional.fss.search.video;

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
public class FSS_141_VerifySearchResultOutputIsNotPresentOnVideoPage extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-141", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_141_test() {
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnVideoPageIsNotPresent()

                .clickRubricatorLink()
                .checkRubricatorIsOpened()
                .closeAndNavigateToSearchResultPage()

                .checkRandomLinksFromPopularBlock();
    }
}

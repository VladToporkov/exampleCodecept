package com.actionmedia.tests.functional.kss.search.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_126_VerifySearchOutputResultVideosPageIsNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-126", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_126_test() {
        loginKss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnVideosPageIsNotPresent()

                .checkLinksOnTypo()
                .logout();
    }
}

package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_135_VerifySearchOutputResultFormsPageIsNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-135", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_135_test() {
        loginKss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsNotPresent()

                .checkLinksOnTypo()
                .logout();
    }
}

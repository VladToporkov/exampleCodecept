package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.annotations.Version;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.06.2014
 * Time: 13:51
 */
public class BSS_43_VerifySearchInServices extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "BSS-43", testCaseVersion = "1")
    @LoginAs(key = "bss.user.vip")
    @Version(section = "vip")
    public void bss_43_test() {
        loginBss()
                .navigateToServicesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnServicesPageIsOpened()

                .checkLinksFromSearchResultPage()
                .checkSearchResultAreNotRepeated()
                .logout();
    }
}

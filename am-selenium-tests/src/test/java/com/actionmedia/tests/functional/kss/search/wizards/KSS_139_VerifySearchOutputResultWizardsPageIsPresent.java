package com.actionmedia.tests.functional.kss.search.wizards;

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
public class KSS_139_VerifySearchOutputResultWizardsPageIsPresent extends AbstractDomainTest {

    private static final String QUERY = "отпуск";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-139", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_139_test() {
        loginKss()
                .navigateToWizardsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnWizardsPageIsOpened()
                .checkShowRelevanceLinkIsAbsent()
                .checkRelevanceIsAbsent()

                .checkLinksFromSearchResultPage()
                .logout();
    }
}

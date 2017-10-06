package com.actionmedia.tests.functional.kss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 20.09.13
 * Time: 11:38
 */
public class KSS_18_VerifyLawBaseNewsBlock extends AbstractDomainTest {

    private static final String QUERY = "1";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "KSS-18", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_18_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkLegislationBlockLinksDisplayed()

                .inputTextInSearchBoxOnLegislationBlock(QUERY)
                .checkHintsIsPresentOnLegislationBlock()
                .clickHintOnLegislationBlock()
                .checkSearchResultOnLawBasePageIsOpened(true)

                .navigateToLawBasePage()
                .inputTextInSearchBoxOnLegislationBlock(QUERY)
                .clickSearchButtonOnLegislationBlock()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .logout();
    }
}

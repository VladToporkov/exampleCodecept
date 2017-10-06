package com.actionmedia.tests.functional.fss.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 09.12.13
 * Time: 11:43
 */
public class FSS_168_VerifyRightPanelInLawBaseDocument extends AbstractDomainTest {

    @Test(groups = {smoke, inDevelopment})
    @TestLink(testCaseId = "FSS-168", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_168_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromKodeksRubricator()

                .checkLinksFromCollapsedSoderTab()

                .checkLinksFromExpandedSoderTab();
    }
}

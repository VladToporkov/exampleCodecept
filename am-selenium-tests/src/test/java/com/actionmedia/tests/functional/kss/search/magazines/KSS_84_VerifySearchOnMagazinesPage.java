package com.actionmedia.tests.functional.kss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_84_VerifySearchOnMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-84", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_84_test() {
        loginKss()
                .navigateToMagazinesPage()

                .checkSearchBoxIsPresentOnMagazinePage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnMagazinesPage()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnMagazinesPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .logout();
    }
}

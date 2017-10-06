package com.actionmedia.tests.functional.kss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_122_VerifySearchInDocumentOnMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-122", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_122_test() {
        loginKss()
                .navigateToMagazinesPage()
                .clickRandomMagazineLink()

                .checkSearchBoxIsPresentOnMagazinePage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomMagazineLink()

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnMagazinesPage()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickRandomMagazineLink()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnMagazinesPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .logout();
    }
}

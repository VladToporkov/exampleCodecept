package com.actionmedia.tests.functional.uss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class VerifySearchInDocumentOnMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "статья";
    private static final String HINT_QUERY = "ж";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToMagazinesPage()
                .clickRandomMagazineLink()

                .checkSearchBoxIsPresentOnMagazinePage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomMagazineLink()

                .inputTextInSearchBox(HINT_QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnMagazinesPage()
                .checkDocumentIsOpened()

                .navigateToMagazinesPage()
                .clickRandomMagazineLink()
                .inputTextInSearchBox(HINT_QUERY)
                .clickRandomHintOnMagazinesPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .logout();
    }
}

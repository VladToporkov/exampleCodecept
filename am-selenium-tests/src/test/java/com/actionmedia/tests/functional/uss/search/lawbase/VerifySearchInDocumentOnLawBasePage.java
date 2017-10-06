package com.actionmedia.tests.functional.uss.search.lawbase;

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
public class VerifySearchInDocumentOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickRandomDocumentLink()

                .checkSearchBoxPresentOnLawBasePage()
                .checkSearchInTextElementIsPresentOnLawBasePage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomDocumentLink()

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnYellowPlate()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnYellowPlate()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .logout();
    }
}

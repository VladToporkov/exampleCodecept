package com.actionmedia.tests.functional.uss.search.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 18:02
 */
public class VerifySearchOnRecomendPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToRecomendPage()
                .checkSearchBoxIsPresentOnRecomendPage()
                .checkTextInputInSearchBox()
                .checkSearchButtonFunctionalityOnSearchBox(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresentOnYellowPlate()
                .clickHintWithJumpOnYellowPlate()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnYellowPlate()
                .checkSearchResultOnRecomendPageIsOpened()
                .logout();
    }
}

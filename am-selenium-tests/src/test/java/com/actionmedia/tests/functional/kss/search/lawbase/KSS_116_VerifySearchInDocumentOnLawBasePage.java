package com.actionmedia.tests.functional.kss.search.lawbase;

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
public class KSS_116_VerifySearchInDocumentOnLawBasePage extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-116", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_116_test() {
        loginKss()
//                .navigateToLawBasePage()
//                .clickRandomDocumentLink()
//
//                .checkSearchBoxPresentOnLawBasePage()
//                .checkSearchInTextWidgetIsPresent()
//
//                .checkTextInputInSearchBox()
//
//                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
//                .clickRandomDocumentLink()
//
//                .inputTextInSearchBox(QUERY)
//                .checkHintsIsPresent()
//                .clickHintWithJumpOnYellowPlate()
//                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox("закон")
                .clickRandomHintOnYellowPlate()
                .checkSearchResultOnLawBasePageIsOpened(true)
                .logout();
    }
}

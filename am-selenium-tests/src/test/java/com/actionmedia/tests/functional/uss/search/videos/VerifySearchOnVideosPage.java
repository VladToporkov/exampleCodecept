package com.actionmedia.tests.functional.uss.search.videos;

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
public class VerifySearchOnVideosPage extends AbstractDomainTest {

    private static final String QUERY = "кодекс";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToVideoPage()

                .checkSearchBoxOnVideoPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnVideoPage()
                .checkDocumentIsOpened()

                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnVideoPage()
                .checkSearchResultOnVideosPageIsOpened()
                .logout();
    }
}

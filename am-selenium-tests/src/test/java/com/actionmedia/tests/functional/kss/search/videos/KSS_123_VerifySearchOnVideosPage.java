package com.actionmedia.tests.functional.kss.search.videos;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_123_VerifySearchOnVideosPage extends AbstractDomainTest {

    private static final String QUERY = "кодекс";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-123", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_123_test() {
        loginKss()
                .navigateToVideoPage()

                .checkSearchBoxOnVideoPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnVideoPage()
                .checkDocumentIsOpened()
                .logout();
    }
}

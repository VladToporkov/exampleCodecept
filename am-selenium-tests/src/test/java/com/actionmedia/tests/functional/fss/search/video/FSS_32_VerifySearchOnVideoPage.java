package com.actionmedia.tests.functional.fss.search.video;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.11.13
 * Time: 16:48
 */
public class FSS_32_VerifySearchOnVideoPage extends AbstractDomainTest {

    private static final String QUERY = "оценка проектов";
    private static final String VIDEO = "Практика оценки инвестиционных проектов";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-32", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_32_test() {
        loginFss()
                .navigateToVideoPage()
                .checkSearchBoxPresentOnVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnVideoPageIsOpened()
                .checkImageLoaded()
                .checkDocumentWithTextIsPresent(VIDEO);
    }
}

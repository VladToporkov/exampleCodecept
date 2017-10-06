package com.actionmedia.tests.functional.fss.search.video;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 13:25
 */
public class FSS_125_VerifySearchQualityOnVideoPage extends AbstractDomainTest {

    private static final String QUERY = "оценка проектов";
    private static final String DOCUMENT = "Практика оценки инвестиционных проектов";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-125", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_125_test() {
        loginFss()
                .navigateToVideoPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnVideoPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT);
    }
}

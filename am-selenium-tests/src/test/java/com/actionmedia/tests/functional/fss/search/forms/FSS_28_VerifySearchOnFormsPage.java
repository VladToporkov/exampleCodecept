package com.actionmedia.tests.functional.fss.search.forms;

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
public class FSS_28_VerifySearchOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "управленческая отчетность";
    private static final String DOCUMENT = "Положение об управленческой отчетности";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "FSS-28", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_28_test() {
        loginFss()
                .navigateToFormsPage()
                .checkSearchBoxPresentOnFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnFormsPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT);
    }
}

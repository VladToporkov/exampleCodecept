package com.actionmedia.tests.functional.fss.search.forms;

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
public class FSS_80_VerifySearchQualityOnFormsPage extends AbstractDomainTest {

    private static final String QUERY = "управленческая отчетность";
    private static final String DOCUMENT_1 = "Положение об управленческой отчетности";
    private static final String DOCUMENT_2 = "Положение об управленческой отчетности группы компаний «Альфа»";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-80", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_80_test() {
        loginFss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultOnFormsPageIsOpened()
                .checkDocumentWithTextIsPresent(DOCUMENT_1)
                .checkDocumentWithTextIsPresent(DOCUMENT_2);
    }
}

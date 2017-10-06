package com.actionmedia.tests.functional.kss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_80_VerifySearchQualityFormsPage extends AbstractDomainTest {

    private static final String QUERY = "по собственному желанию";
    private static final String EXPECTED_RESULT_1 = "Заявление сотрудника об увольнении по собственному желанию";
    private static final String EXPECTED_RESULT_2 = "Заявление сотрудника об увольнении по собственному желанию в связи с выходом на пенсию";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-80", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_80_test() {
        loginKss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT_1)
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT_2)
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.search.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchQualityFormsPage extends AbstractDomainTest {

    private static final String QUERY = "по собственному желанию";
    private static final String EXPECTED_RESULT_1 = "Заявление сотрудника об увольнении по собственному желанию";
    private static final String EXPECTED_RESULT_2 = "Заявление сотрудника об увольнении по собственному желанию в связи с выходом на пенсию";

    //    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToFormsPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnFormsPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT_1)
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT_2)
                .logout();
    }
}

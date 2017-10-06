package com.actionmedia.tests.functional.fss.search.lawbase;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 13.05.2014
 * Time: 10:08
 */
public class FSS_186_VerifySearchInResults extends AbstractDomainTest {

    private static final String QUERY_1 = "123";
    private static final String QUERY_2 = "qweqweqweqweqweqwe";
    private static final String QUERY_3 = "налог";
    private static final String QUERY_4 = "12345";
    private static final String QUERY_5 = "закон";
    private static final String QUERY_6 = "О внесении изменений в Закон";

    @Test(groups = {regression, inDevelopment})
    @TestLink(testCaseId = "FSS-186", testCaseVersion = "1")
    @LoginAs(key = "fss.user.commercial")
    public void fss_186_test() {
        loginFss()
                .navigateToLawBasePage()
                .inputTextInSearchBox(QUERY_1)
                .clickSearchButtonFss()
                .checkSearchInResultsCheckBoxIsPresent()
                .checkSearchInResultsCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY_2)
                .clickSearchButtonFss()
                .checkSearchInResultsCheckBoxIsNotPresent()

                .inputTextInSearchBox(QUERY_3)
                .clickSearchButtonFss()
                .checkSearchInResultsCheckBoxIsPresent()
                .checkSearchInResultsCheckBoxIsNotSelected()
                .clickSearchInResultsCheckBox()
                .inputTextInSearchBox(QUERY_4)
                .clickSearchButtonFss()
                .checkSearchInResultsCheckBoxIsPresent()
                .checkSearchInResultsCheckBoxIsNotSelected()

                .inputTextInSearchBox(QUERY_3)
                .clickSearchButtonFss()
                .clickSearchInResultsCheckBox()
                .inputTextInSearchBox(QUERY_5)
                .clickSearchButtonFss()
                .checkSearchResultHeaderContainsText("Область поиска: в найденном по запросу «" + QUERY_3 + "»")
                .checkSearchResultHeaderContainsText("В правовой базе по запросу «" + QUERY_5 + "»")
                .checkSearchResultIsPresent(false)
                .checkWordFromQueryIsHighlighted(QUERY_5)

                .clickExtendedFormButton()
                .inputViewInExtendedByName("Закон")
                .inputRegionInExtendedByName("Москва")
                .clickExtendedSearchButton()
                .inputTextInSearchBox(QUERY_6)
                .clickSearchInResultsCheckBox()
                .clickSearchButtonFss()
//                .checkSearchResultHeaderNotContainsText("Область поиска: в найденном по запросу")
                .checkSearchResultHeaderContainsText("В правовой базе по запросу «" + QUERY_6 + "»");
    }
}

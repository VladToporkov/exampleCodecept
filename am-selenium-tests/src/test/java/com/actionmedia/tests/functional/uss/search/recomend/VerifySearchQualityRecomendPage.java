package com.actionmedia.tests.functional.uss.search.recomend;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchQualityRecomendPage extends AbstractDomainTest {

    private static final String QUALITY_QUERY = "как принять на работу сотрудника-иностранца";
    private static final String QUALITY_EXPECTED_RESULT = "Как оформить прием на работу сотрудника-иностранца";

    private static final String DICTIONARY_QUERY = "производственный календарь январь 2013";
    private static final String DICTIONARY_EXPECTED_RESULT_1 = "Производственный календарь при пятидневной рабочей неделе на 2013 год";
    private static final String DICTIONARY_EXPECTED_RESULT_2 = "Производственный календарь при шестидневной рабочей неделе на 2013 год";

    private static final String TYPO_QUERY = "ext";
    private static final String TYPO_EXPECTED_RESULT = "учет";

    //    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToRecomendPage()
                .inputTextInSearchBox(QUALITY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnRecomendPageIsOpened()
                .checkDocumentWithTextIsPresent(QUALITY_EXPECTED_RESULT)

                .inputTextInSearchBox(DICTIONARY_QUERY)
                .clickSearchButtonOnSearchPage()
                .checkDocumentWithTextIsPresent(DICTIONARY_EXPECTED_RESULT_1)
                .checkDocumentWithTextIsPresent(DICTIONARY_EXPECTED_RESULT_2)

                .inputTextInSearchBox(TYPO_QUERY)
                .clickSearchButtonOnSearchPage()
                .checkTypoWasFixed(TYPO_QUERY, TYPO_EXPECTED_RESULT)
                .checkDocumentWithTextIsPresent(TYPO_EXPECTED_RESULT)
                .logout();
    }
}

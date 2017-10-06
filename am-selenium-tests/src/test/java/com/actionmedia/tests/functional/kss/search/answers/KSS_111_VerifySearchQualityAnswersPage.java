package com.actionmedia.tests.functional.kss.search.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.inDevelopment;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_111_VerifySearchQualityAnswersPage extends AbstractDomainTest {

    private static final String QUALITY_QUERY = "как принять на работу сотрудника-иностранца";
    private static final String QUALITY_EXPECTED_RESULT = "Как оформить прием на работу сотрудника-иностранца";

    private static final String DICTIONARY_QUERY = "производственный календарь январь 2013";
    private static final String DICTIONARY_EXPECTED_RESULT_1 = "Производственный календарь при пятидневной рабочей неделе на 2013 год";
    private static final String DICTIONARY_EXPECTED_RESULT_2 = "Производственный календарь при шестидневной рабочей неделе на 2013 год";

    private static final String TYPO_QUERY = "ext";
    private static final String TYPO_EXPECTED_RESULT = "учет";

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "KSS-111", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_111_test() {
        loginKss()
                .navigateToAnswersPage()
                .inputTextInSearchBox(QUALITY_QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnAnswersPageIsOpened()
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

package com.actionmedia.tests.functional.kss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_82_VerifySearchQualityDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "оформить командировку";
    private static final String EXPECTED_RESULT = "Формы первичных документов для оформления командировки сотрудника";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-82", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_82_test() {
        loginKss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT)
                .logout();
    }
}

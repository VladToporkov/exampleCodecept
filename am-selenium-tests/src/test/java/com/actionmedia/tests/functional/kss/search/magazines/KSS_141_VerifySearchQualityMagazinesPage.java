package com.actionmedia.tests.functional.kss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class KSS_141_VerifySearchQualityMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "мигранты жкх русский язык";
    private static final String EXPECTED_RESULT = "ЖУРНАЛ «ЗАРПЛАТА», № 1, ЯНВАРЬ 2013\n" +
            "Для работы в РФ иностранцы должны знать русский язык";

    @Test(groups = {implemented})
//    @TestLink(testCaseId = "KSS-141", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_141_test() {
        loginKss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT)
                .logout();
    }
}

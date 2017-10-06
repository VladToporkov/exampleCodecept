package com.actionmedia.tests.functional.uss.search.magazines;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchQualityMagazinesPage extends AbstractDomainTest {

    private static final String QUERY = "мигранты жкх русский язык";
    private static final String EXPECTED_RESULT = "ЖУРНАЛ «ЗАРПЛАТА», № 1, ЯНВАРЬ 2013\n" +
            "Для работы в РФ иностранцы должны знать русский язык";

    //    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToMagazinesPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnMagazinesPageIsOpened()
                .checkDocumentWithTextIsPresent(EXPECTED_RESULT)
                .logout();
    }
}

package com.actionmedia.tests.functional.uss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 01.10.13
 * Time: 10:38
 */
public class VerifySearchOutputResultDictionaryPageIsNotPresent extends AbstractDomainTest {

    private static final String QUERY = "qweqweqweqweqweqwe";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonAndNavigateToSearchResultPage()
                .checkSearchResultOnDictionaryPageIsNotPresent()

                .checkLinksOnTypo()
                .logout();
    }
}

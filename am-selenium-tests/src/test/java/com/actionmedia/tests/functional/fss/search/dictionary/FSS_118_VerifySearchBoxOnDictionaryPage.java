package com.actionmedia.tests.functional.fss.search.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.fss.FssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 16:03
 */
public class FSS_118_VerifySearchBoxOnDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-118", testCaseVersion = "1")
    public void fss_118_test() {
        report("Проверяется для неавторизованного пользователя");
        checkSearchBox(enterToFssWithoutLogin());

        report("Проверяется для авторизованного пользователя, без доступов");
        updateLoginAsInfo("bss.user.commercial");
        checkSearchBox(loginFss())
                .logout();

        report("Проверяется для демодоступа");
        updateLoginAsInfo("fss.user.demo");
        checkSearchBox(loginFss())
                .logout();

        report("Проверяется для оплаченного");
        updateLoginAsInfo("fss.user.commercial");
        checkSearchBox(loginFss())
                .logout();

        report("Проверяется для эксперта");
        updateLoginAsInfo("fss.user.expert");
        checkSearchBox(loginFss())
                .logout();
    }

    private FssBasePage checkSearchBox(FssBasePage fssBasePage) {
        return fssBasePage
                .navigateToDictionaryPage()
                .checkSearchBoxPresentOnDictionaryPage()
                .checkTextInputInSearchBox()

                .clickSearchButtonWithEmptySearchBox()
                .checkSearchResultPageIsNotOpened()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultIsPresent(false)

                .navigateToDictionaryPage()
                .inputTextInSearchBox("ко")
                .checkHintsIsPresent()
                .clickHint()
                .checkSearchResultOnDictionaryPageIsOpened()

                .navigateToDictionaryPage()
                .inputTextInSearchBox(QUERY)
                .checkHintsWithJumpIsPresent()
                .clickHintWithJump()
                .checkDocumentIsOpened();
    }
}

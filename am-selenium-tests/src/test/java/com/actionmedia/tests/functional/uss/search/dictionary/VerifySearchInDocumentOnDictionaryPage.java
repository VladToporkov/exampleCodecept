package com.actionmedia.tests.functional.uss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class VerifySearchInDocumentOnDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "административная ответственность";
    private static final String HINT_QUERY = "д";

    @Test(groups = {smoke, implemented})
    @LoginAs(key = "uss.user.commercial")
    public void uss_test() {
        loginUss()
                .navigateToDictionaryPage()
                .clickRandomDocumentLink()

                .checkSearchBoxPresentOnDictionaryPage()
                .checkSearchInTextElementIsPresentOnDictionaryPage()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnSearchBox(QUERY)
                .clickRandomDocumentLink()

                .inputTextInSearchBox(HINT_QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnDictionaryPage()
                .checkDocumentIsOpened()

                .navigateToDictionaryPage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox(HINT_QUERY)
                .clickRandomHintOnDictionaryPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .logout();
    }
}

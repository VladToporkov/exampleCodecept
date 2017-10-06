package com.actionmedia.tests.functional.kss.search.dictionary;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 27.09.13
 * Time: 15:11
 */
public class KSS_121_VerifySearchInDocumentOnDictionaryPage extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-121", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_121_test() {
        loginKss()
                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .checkSearchBoxIsPresentInDocument("Поиск справочной информации")
                .checkSearchInTextWidgetIsPresent()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnDictionaryPage(QUERY)

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresent()
                .clickHintWithJumpOnDictionaryPage()
                .checkDocumentIsOpened()

                .navigateToDictionaryPage()
                .clickRandomDocumentLink()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnDictionaryPage()
                .checkSearchResultOnDictionaryPageIsOpened()
                .logout();
    }
}

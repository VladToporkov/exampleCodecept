package com.actionmedia.tests.functional.bss.search;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 23.10.13
 * Time: 11:17
 */
public class BSS_147_VerifySearchInText extends AbstractDomainTest {

    private static final String QUERY = "документ";

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-147", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_147_test() {
        loginBss()
                .navigateToRecomendPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .clickHeader()
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .navigateToLawBasePage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()

                .navigateToDictionaryPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBoxForSearchInText(QUERY)
                .checkSearchInTextWidgetWork(false)
                .clearSearchBox()
                .logout();
    }
}

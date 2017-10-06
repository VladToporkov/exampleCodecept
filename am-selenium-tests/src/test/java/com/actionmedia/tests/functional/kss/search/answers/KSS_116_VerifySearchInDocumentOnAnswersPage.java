package com.actionmedia.tests.functional.kss.search.answers;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 26.09.13
 * Time: 18:02
 */
public class KSS_116_VerifySearchInDocumentOnAnswersPage extends AbstractDomainTest {

    private static final String QUERY = "статья";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "KSS-116", testCaseVersion = "1")
    @LoginAs(key = "kss.user.commercial")
    public void kss_116_test() {
        loginKss()
                .navigateToAnswersPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .checkSearchBoxIsPresentInDocument("Поиск ответов")
                .checkSearchInTextWidgetIsPresent()

                .checkTextInputInSearchBox()

                .checkSearchButtonFunctionalityOnAnswerPage(QUERY)
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()

                .inputTextInSearchBox(QUERY)
                .checkHintsIsPresentOnYellowPlate()
                .clickHintWithJumpOnYellowPlate()
                .checkDocumentIsOpened()

                .navigateToAnswersPage()
                .clickRubricatorButton()
                .clickRandomItemFromFirstMenu()
                .clickRandomArticle()
                .inputTextInSearchBox(QUERY)
                .clickRandomHintOnYellowPlate()
                .checkSearchResultOnAnswersPageIsOpened()
                .logout();
    }
}

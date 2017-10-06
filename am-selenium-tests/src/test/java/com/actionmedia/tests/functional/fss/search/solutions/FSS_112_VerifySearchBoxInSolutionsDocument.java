package com.actionmedia.tests.functional.fss.search.solutions;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 28.04.2014
 * Time: 16:03
 */
public class FSS_112_VerifySearchBoxInSolutionsDocument extends AbstractDomainTest {

    private static final String QUERY = "форма";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-112", testCaseVersion = "1")
    public void fss_112_test() {
        report("Проверяется для демодоступа");
        updateLoginAsInfo("fss.user.demo");
        checkSearchBox();

        report("Проверяется для оплаченного");
        updateLoginAsInfo("fss.user.commercial");
        checkSearchBox();

        report("Проверяется для эксперта");
        updateLoginAsInfo("fss.user.expert");
        checkSearchBox();
    }

    private void checkSearchBox() {
        loginFss()
                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .checkSearchBoxPresentInSolutionsDocument()
                .checkTextInputInSearchBox()

                .clickSearchButtonWithEmptySearchBox()
                .checkSearchResultPageIsNotOpened()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultIsPresent(false)

                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .inputTextInSearchBox("ко")
                .checkHintsIsPresent()
                .clickHint()
                .checkSearchResultOnSolutionsPageIsOpened()

                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .inputTextInSearchBox("л")
                .checkHintsWithJumpIsPresent()
                .clickHintWithJump()
                .checkDocumentIsOpened()

                .navigateToSolutionsPage()
                .clickRandomSectionInRubricator()
                .clickRandomSubSectionsInRubricator()
                .clickRandomItemFromRubricator()
                .clickClearSearchBoxButton()
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBox("1")
                .checkSearchInTextWidgetWork(false)

                .navigateToSolutionsPage()
                .inputTextInSearchBox("1")
                .clickSearchButtonFss()
                .clickRandomDocument()
                .checkEnableHighlightsButtonIsPresent()
                .checkEnableHighlightsButtonFunctionality()
                .logout();
    }
}

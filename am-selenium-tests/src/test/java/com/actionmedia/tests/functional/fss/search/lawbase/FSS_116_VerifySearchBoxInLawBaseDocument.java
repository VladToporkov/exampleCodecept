package com.actionmedia.tests.functional.fss.search.lawbase;

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
public class FSS_116_VerifySearchBoxInLawBaseDocument extends AbstractDomainTest {

    private static final String QUERY = "закон";

    @Test(groups = {regression, implemented})
    @TestLink(testCaseId = "FSS-116", testCaseVersion = "1")
    public void fss_116_test() {
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
                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromKodeksRubricator()
                .checkSearchBoxPresentInLawBaseDocument()
                .checkTextInputInSearchBox()

                .clickSearchButtonWithEmptySearchBox()
                .checkSearchResultPageIsNotOpened()
                .inputTextInSearchBox(QUERY)
                .clickSearchButtonFss()
                .checkSearchResultIsPresent(false)

                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromKodeksRubricator()
                .inputTextInSearchBox("ко")
                .checkHintsIsPresent()
                .clickHint()
                .checkSearchResultOnLawBasePageIsOpenedBoolean(false)

                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromKodeksRubricator()
                .inputTextInSearchBox("л")
                .checkHintsWithJumpIsPresent()
                .clickHintWithJump()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .clickRandomSectionInRubricator()
                .clickRandomItemFromKodeksRubricator()
                .clickClearSearchBoxButton()
                .checkSearchInTextWidgetIsPresent()
                .inputTextInSearchBox("1")
                .checkSearchInTextWidgetWork(false)

                .navigateToLawBasePage()
                .inputTextInSearchBox("1")
                .clickSearchButtonFss()
                .clickRandomDocument()
                .checkEnableHighlightsButtonIsPresent()
                .checkEnableHighlightsButtonFunctionality()
                .logout();
    }
}

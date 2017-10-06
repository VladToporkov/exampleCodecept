package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/05/16.
 */
public class OSS_1644_FirstKodeksBlock_GF extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1644", testCaseVersion = "1")
    public void oss_1644_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Проверяется раздел Первый блок кодексов ГФ КУ");
        gf_1644_test();
    }

    private void gf_1644_test() {
        loginGF()
                .navigateToLawBasePage()
                .checkBudgetWidgetIsPresent()
                .checkBudgetWidgetTitleIsPresent()
                .checkBudgetWidgetLinksArePresent()

                .checkBudgetWidgetHasEightLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkBudgetWidgetHasSixLinks()
                .checkBudgetWidgetBlockResized()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_LOW, HEIGHT)
                .checkBudgetWidgetHasTwoLinks()
                .checkBudgetWidgetBlockResized()
                .checkBudgetWidgetLinksAreWorked()
                .checkAllWidgetsDontConflictWithEachOther()

                .checkBudgetWidgetLinksAreWorked()

                .checkSearchBudgetWidgetBlockIsPresent()
                .checkBudgetWidgetSearchInputHasName()

                .inputBudgetWidgetSearchQuery(QUERY_TRUE)
                .checkBudgetWidgetSearchResultIsVisible()
                .clickOnBudgetWidgetRandomSearchResult()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputBudgetWidgetSearchQuery(QUERY_TRUE)
                .clickOnBudgetWidgetButtonEnterIntoSearchBox()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputBudgetWidgetSearchQuery(QUERY_FALSE)
                .checkBudgetWidgetSearchResultIsNotVisible()

                .logout();
    }
}
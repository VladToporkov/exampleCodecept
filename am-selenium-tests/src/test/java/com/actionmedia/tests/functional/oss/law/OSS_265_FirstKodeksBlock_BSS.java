package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 17.12.2014.
 */
public class OSS_265_FirstKodeksBlock_BSS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-265", testCaseVersion = "1")
    public void oss_265_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется раздел Первый блок кодексов БСС КУ");
        bss_265_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Первый блок кодексов БСС ВИП");
        bss_265_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется раздел Первый блок кодексов БСС УПР");
        bss_265_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется раздел Первый блок кодексов БСС БУ");
        bss_bu_265_test();
    }

    private void bss_265_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkTaxWidgetIsPresent()
                .checkTaxWidgetTitleIsPresent()
                .checkTaxWidgetLinksArePresent()

                .checkTaxWidgetHasSixLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkTaxWidgetHasSixLinks()
                .checkTaxWidgetBlockResized()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_LOW, HEIGHT)
                .checkTaxWidgetHasTwoLinks()
                .checkTaxWidgetBlockResized()
                .checkTaxWidgetLinksAreWorked()
                .checkAllWidgetsDontConflictWithEachOther()

                .checkTaxWidgetLinksAreWorked()

                .checkSearchTaxWidgetBlockIsPresent()
                .checkTaxWidgetSearchInputHasName()

                .inputTaxWidgetSearchQuery(QUERY_TRUE)
                .checkTaxWidgetSearchResultIsVisible()
                .clickOnTaxWidgetRandomSearchResult()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTaxWidgetSearchQuery(QUERY_TRUE)
                .clickOnTaxWidgetButtonEnterIntoSearchBox()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputTaxWidgetSearchQuery(QUERY_FALSE)
                .checkTaxWidgetSearchResultIsNotVisible()

        .logout();
    }

    private void bss_bu_265_test() {
        loginBss()
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
                .checkBudgetWidgetHasFourLinks()
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

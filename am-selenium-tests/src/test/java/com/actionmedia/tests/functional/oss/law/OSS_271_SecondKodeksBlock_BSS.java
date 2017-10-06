package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 12.01.2015.
 */
public class OSS_271_SecondKodeksBlock_BSS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;

    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-271", testCaseVersion = "2")
    public void oss_271_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Второй блок кодексов раздел Правовая база БСС КУ");
        bss_271_test();

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Второй блок кодексов раздел Правовая база БСС БУ");
        bss_bu_271_test();

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Проверяется Второй блок кодексов раздел Правовая база БСС УСН");
        bss_271_test();

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Второй блок кодексов раздел Правовая база БСС ВИП");
        bss_271_test();
    }

    private void bss_bu_271_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkTaxWidgetIsPresent()
                .checkTaxWidgetTitleIsPresent()
                .checkTaxWidgetLinksArePresent()

                .checkTaxWidgetHasTwoLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkTaxWidgetHasTwoLinks()
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
                .checkTaxWidgetSearchResultIsNotVisible();
    }

    private void bss_271_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkLaborWidgetIsPresent()
                .checkLaborWidgetTitleIsPresent()
                .checkLaborWidgetLinksArePresent()

                .checkLaborWidgetHasFourLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkLaborWidgetHasFourLinks()
                .checkLaborWidgetBlockIsNotChanged()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_LOW, HEIGHT)
                .checkLaborWidgetHasFourLinks()
                .checkLaborWidgetBlockIsNotChanged()
                .checkLaborWidgetLinksAreWorked()
                .checkAllWidgetsDontConflictWithEachOther()

                .checkLaborWidgetLinksAreWorked()

                .checkSearchLaborWidgetBlockIsPresent()
                .checkLaborWidgetSearchInputHasName()

                .inputLaborWidgetSearchQuery(QUERY_TRUE)
                .checkLaborWidgetSearchResultIsVisible()
                .clickOnLaborWidgetRandomSearchResult()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputLaborWidgetSearchQuery(QUERY_TRUE)
                .checkLaborWidgetSearchResultIsVisible()
                .clickOnLaborWidgetButtonEnterIntoSearchBox()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputLaborWidgetSearchQuery(QUERY_FALSE)
                .checkLaborWidgetSearchResultIsNotVisible();
    }
}

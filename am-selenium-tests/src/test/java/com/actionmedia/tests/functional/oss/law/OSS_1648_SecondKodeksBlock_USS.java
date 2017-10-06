package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 31/05/16.
 */
public class OSS_1648_SecondKodeksBlock_USS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;

    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1648", testCaseVersion = "2")
    public void oss_1648_test() {
        //BSS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Второй блок кодексов раздел Правовая база ЮСС КУ");
        uss_1648_test();

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Второй блок кодексов раздел Правовая база ЮСС ВИП");
        uss_1648_test();
    }

    private void uss_1648_test() {
        loginUss()
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
}
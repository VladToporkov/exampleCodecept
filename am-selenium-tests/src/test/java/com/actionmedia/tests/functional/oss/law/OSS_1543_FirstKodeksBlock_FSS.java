package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/05/16.
 */
public class OSS_1543_FirstKodeksBlock_FSS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1543", testCaseVersion = "1")
    public void oss_1543_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется раздел Первый блок кодексов ФСС КУ");
        fss_1543_test();
    }

    private void fss_1543_test() {
        enterToFssWithoutLogin()
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
}
package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 31/05/16.
 */
public class OSS_1649_SecondKodeksBlock_FSS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;

    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1649", testCaseVersion = "2")
    public void oss_1649_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Второй блок кодексов раздел Правовая база ФСС");
        fss_1649_test();
    }

    private void fss_1649_test() {
        loginFss()
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
                .clickOnLaborWidgetButtonEnterIntoSearchBox()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputLaborWidgetSearchQuery(QUERY_FALSE)
                .checkLaborWidgetSearchResultIsNotVisible();
    }
}

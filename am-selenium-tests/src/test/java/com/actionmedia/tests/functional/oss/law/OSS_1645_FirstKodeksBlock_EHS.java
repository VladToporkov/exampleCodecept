package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/05/16.
 */
public class OSS_1645_FirstKodeksBlock_EHS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1645", testCaseVersion = "1")
    public void oss_1645_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется раздел Первый блок кодексов ОТ КУ");
        ehs_1645_test();

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется раздел Первый блок кодексов ОТ БАЗ");
        ehs_1645_test();

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Первый блок кодексов ОТ ВИП");
        ehs_1645_test();
    }

    private void ehs_1645_test() {
        loginOT()
                .navigateToLawBasePage()
                .checkLaborWidgetIsPresent()
                .checkLaborWidgetTitleIsPresent()
                .checkLaborWidgetLinksArePresent()

                .checkLaborWidgetHasTenLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkLaborWidgetHasTenLinks()
                .checkLaborWidgetBlockResized()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_LOW, HEIGHT)
                .checkLaborWidgetHasSixLinks()
                .checkLaborWidgetBlockResized()
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
                .checkLaborWidgetSearchResultIsNotVisible()

                .logout();
    }
}
package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 26/05/16.
 */
public class OSS_1541_FirstKodeksBlock_KSS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1541", testCaseVersion = "1")
    public void oss_1541_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется раздел Первый блок кодексов КСС КУ");
        kss_1541_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется раздел Первый блок кодексов КСС БУ");
        kss_1541_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Первый блок кодексов КСС ВИП");
        kss_1541_test();
    }

    private void kss_1541_test() {
        loginKss()
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
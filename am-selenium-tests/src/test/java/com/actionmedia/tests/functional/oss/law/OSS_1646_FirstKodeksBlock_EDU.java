package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/05/16.
 */
public class OSS_1646_FirstKodeksBlock_EDU extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1646", testCaseVersion = "1")
    public void oss_1646_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется раздел Первый блок кодексов ОТ КУ");
        edu_1646_test();

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется раздел Первый блок кодексов ОТ БАЗ");
        edu_1646_test();

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется раздел Первый блок кодексов ОТ ВИП");
        edu_1646_test();
    }

    private void edu_1646_test() {
        loginEdu()
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

package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 29/05/16.
 */
public class OSS_1542_FirstKodeksBlock_USS extends AbstractDomainTest {

    public static final int WIDTH_MEDIUM = 1270;
    public static final int WIDTH_LOW = 1024;
    public static final int HEIGHT = 800;
    public static final String QUERY_TRUE = "101";
    public static final String QUERY_FALSE = "112311123123";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1542", testCaseVersion = "1")
    public void oss_1542_test() {
        // KSS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется раздел Первый блок кодексов ЮСС КУ");
        uss_1542_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется раздел Первый блок кодексов ЮСС ВИП");
        uss_1542_test();
    }

    private void uss_1542_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkCivilWidgetIsPresent()
                .checkCivilWidgetTitleIsPresent()
                .checkCivilWidgetLinksArePresent()

                .checkWidgetHasFourLinks()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_MEDIUM, HEIGHT)
                .checkWidgetHasFourLinks()
                .checkCivilWidgetBlockResized()
                .checkAllWidgetsDontConflictWithEachOther()

                .setSizeWindows(WIDTH_LOW, HEIGHT)
                .checkWidgetHasFourLinks()
                .checkCivilWidgetBlockResized()
                .checkCivilWidgetLinksAreWorked()
                .checkAllWidgetsDontConflictWithEachOther()

                .checkCivilWidgetLinksAreWorked()

                .checkSearchCivilWidgetBlockIsPresent()
                .checkCivilWidgetSearchInputHasName()

                .inputCivilWidgetSearchQuery(QUERY_TRUE)
                .checkCivilWidgetSearchResultIsVisible()
                .clickOnCivilWidgetRandomSearchResult()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputCivilWidgetSearchQuery(QUERY_TRUE)
                .clickOnCivilWidgetButtonEnterIntoSearchBox()
                .checkDocumentIsOpened()

                .navigateToLawBasePage()
                .inputCivilWidgetSearchQuery(QUERY_FALSE)
                .checkCivilWidgetSearchResultIsNotVisible()

                .logout();
    }
}

package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 06/04/16.
 */
public class OSS_730_HandbookWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-730", testCaseVersion = "1")
    public void oss_730_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник БСС КУ");
        unifiedTest(loginBss());
        test_widget();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ГФ КУ");
        unifiedTest(loginGF());
        gf_test_widget();
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2000", testCaseVersion = "1")
    public void oss_2000_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник УМД ВИП");
        unifiedTest(loginUmd());

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник УМД МИНИ");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1990", testCaseVersion = "1")
    public void oss_1990_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1965", testCaseVersion = "1")
    public void oss_1965_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1958", testCaseVersion = "1")
    public void oss_1958_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1919", testCaseVersion = "1")
    public void oss_1919_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ГЗ ВИП");
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ГЗ МИНИ");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1432", testCaseVersion = "1")
    public void oss_1432_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ФСС КУ");
        unifiedTest(loginFss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1396", testCaseVersion = "1")
    public void oss_1396_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ЮСС ВИП");
        unifiedTest(loginUss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ЮСС БУ");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1582", testCaseVersion = "1")
    public void oss_1582_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ОБР ВИП");
        unifiedTest(loginEdu());

        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ОБР МИНИ");
        unifiedTest(loginEdu());
    }

    private void test_widget() {
        loginBss()

                .navigateToRecomendPage()
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .changeRegion("Керчь")

                .navigateToRecomendPage()
                .clickOnHandbookWidgetInRegionLink()
                .checkDocumentIsOpened()
                .checkDocumentRegionYellowTipFor("Республика Крым")

                .navigateToRecomendPage()
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .changeRegion("Курица")

                .navigateToRecomendPage()
                .clickOnHandbookWidgetInRegionLink()
                .checkDocumentIsOpened()
                .checkDocumentRegionYellowTipFor("Курская область")

                .clickProfileLink()
                .changeCheckboxAutoRegion()
                .navigateToRecomendPage()
                .logout();
    }

    private void gf_test_widget() {
        loginGF()

                .navigateToRecomendPage()
                .checkHandbookWidgetLinkInRegionIsPresent()
                .checkHandbookWidgetChangesIsPresent()

                .clickOnHandbookWidgetRubricLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnHandbookWidgetChangesLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .changeRegion("Керчь")

                .navigateToRecomendPage()
                .clickOnHandbookWidgetInRegionLink()
                .checkDocumentIsOpened()
                .checkDocumentRegionYellowTipFor("Республика Крым")

                .navigateToRecomendPage()
                .clickProfileLink()
                .checkProfilePageIsOpened()
                .changeRegion("Курица")

                .navigateToRecomendPage()
                .clickOnHandbookWidgetInRegionLink()
                .checkDocumentIsOpened()
                .checkDocumentRegionYellowTipFor("Курская область")

                .clickProfileLink()
                .changeCheckboxAutoRegion()
                .navigateToRecomendPage()
                .logout();
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkHandbookWidgetIsPresent()
                .checkHandbookWidgetTitleIsPresent()
                .checkHandbookWidgetDocumentCountIsPresent()
                .checkHandbookWidgetDateTodayIsPresent()
                .checkHandbookWidgetMonthNowIsPresent()
                .checkHandbookWidgetWorkingDaysElementIsPresent()
                .checkHandbookWidgetHolidaysElementIsPresent()
                .checkHandbookWidgetExchangeRatesTitleIsPresent()
                .checkHandbookWidgetDollarRateIsPresent()
                .checkHandbookWidgetEuroRateIsPresent()
                .checkHandbookWidgetMinimunWageTitleIsPresent()
                .checkHandbookWidgetWageIsPresent()
                .checkHandbookWidgetLinkRubricIsPresent()

                .clickOnHandbookWidgetTitle()
                .checkDictionaryTabIsSelected()
                .checkDictionaryBoardIsDisplayed()

                .navigateToRecomendPage()
                .clickOnHandbookWidgetCalendar()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickOnHandbookWidgetExchangeRatesBlock()
                .checkDocumentIsOpened()

                .logout();
    }
}

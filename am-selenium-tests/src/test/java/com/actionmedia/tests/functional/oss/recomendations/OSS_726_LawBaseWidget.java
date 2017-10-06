package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/02/16.
 */
public class OSS_726_LawBaseWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-726", testCaseVersion = "1")
    public void oss_726_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база МЦФЭР ГФ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1578", testCaseVersion = "1")
    public void oss_1578_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ОБР МИНИ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ОБР ВИП");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1391", testCaseVersion = "1")
    public void oss_1391_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ЮСС БУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ЮСС ВИП");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2008", testCaseVersion = "1")
    public void oss_2008_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база УМД ВИП");
        unifiedTest(loginUmd());

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база УМД МИНИ");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1972", testCaseVersion = "1")
    public void oss_1972_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1969", testCaseVersion = "1")
    public void oss_1969_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1954", testCaseVersion = "1")
    public void oss_1954_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1915", testCaseVersion = "1")
    public void oss_1915_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ГЗ ВИП");
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Правовая база ГЗ МИНИ");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1427", testCaseVersion = "1")
    public void oss_1427_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ФСС КУ");
        unifiedTest(loginFss());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        String query = "1";
        page
                .navigateToRecomendPage()
                .checkLawBaseBlockIsPresent()
                .checkLawBaseWidgetTitleIsPresent()
                .checkKodeksOrderInLawBaseBlock()
                .checkLawBaseWidgetSearchInputIsPresent()
                .checkLawBaseWidgetNewDocumentCounterIsPresent()

                .checkLawBaseWidgetLinksCodes()
                .clickLawBaseWidgetLinkTitle()
                .checkMainLawBasePageIsOpened()

                .navigateToRecomendPage()
                .clickLawBaseWidgetLinkNewDocumentCounter()
                .checkMainLawBasePageIsOpened()

                .navigateToRecomendPage()
                .clickLawBaseWidgetLinkEnterIconOntoSearchInput()
                .checkMainLawBasePageIsOpened()

                .navigateToRecomendPage()
                .inputLawBaseWidgetInSearch(query)
                .checkLawBaseWidgetSearchResultsArePresent()

                .clickLawBaseWidgetOnSearchResultsDirectDocument()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .inputLawBaseWidgetInSearch(query)
                .clickLawBaseWidgetSearchResultsRandomHintLink()
                .checkSearchResultOnLawBasePageIsOpened()

                .navigateToRecomendPage()
                .inputLawBaseWidgetInSearch(query)
                .clickLawBaseWidgetIconEnterWithSearchQuery()
                .checkSearchResultOnLawBasePageIsOpened()

                .logout();
    }
}
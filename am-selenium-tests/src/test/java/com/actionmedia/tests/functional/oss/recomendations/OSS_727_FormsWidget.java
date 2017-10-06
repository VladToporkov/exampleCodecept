package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 19/02/16.
 */
public class OSS_727_FormsWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-727", testCaseVersion = "1")
    public void oss_727_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки МЦФЭР ГФ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1579", testCaseVersion = "1")
    public void oss_1579_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ОБР МИНИ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ОБР ВИП");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1392", testCaseVersion = "1")
    public void oss_1392_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ЮСС БУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ЮСС ВИП");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2006", testCaseVersion = "1")
    public void oss_2006_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки УМД ВИП");
        unifiedTest(loginUmd());

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки УМД МИНИ");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1973", testCaseVersion = "1")
    public void oss_1973_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1968", testCaseVersion = "1")
    public void oss_1968_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1955", testCaseVersion = "1")
    public void oss_1955_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1916", testCaseVersion = "1")
    public void oss_1916_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ГЗ ВИП");
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ГЗ МИНИ");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1428", testCaseVersion = "1")
    public void oss_1428_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Формы и бланки ФСС КУ");
        unifiedTest(loginFss());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        String query = "1";
        page
                .navigateToRecomendPage()
                .checkFormsBlockIsPresent()
                .checkFormsWidgetTitleIsPresent()
                .checkFormsBlockIsNotEmpty()
                .checkFormsWidgetSearchInputIsPresent()
                .checkFormsWidgetExamplesFormsIsPresent()

                .clickFormsWidgetRedLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickFormsWidgetGreenLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickFormsWidgetBlueLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickFormsWidgetYellowLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .clickFormsLink()
                .checkDefaultStateFormsPage()

                .navigateToRecomendPage()
                .clickFormsWidgetLinkEnterIconOntoSearchInput()
                .checkDefaultStateFormsPage()

                .navigateToRecomendPage()
                .inputFormsWidgetInSearch(query)
                .checkFormsWidgetSearchResultsArePresent()

                .clickFormsWidgetOnSearchResultsDirectDocument()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .removeAllTrainingHands()
                .inputFormsWidgetInSearch(query)
                .clickFormsWidgetSearchResultsRandomHintLink()
                .checkSearchResultOnFormsPageIsOpened()

                .navigateToRecomendPage()
                .removeAllTrainingHands()
                .inputFormsWidgetInSearch(query)
                .clickFormsWidgetIconEnterWithSearchQuery()
                .checkSearchResultOnFormsPageIsOpened()

                .logout();
    }
}
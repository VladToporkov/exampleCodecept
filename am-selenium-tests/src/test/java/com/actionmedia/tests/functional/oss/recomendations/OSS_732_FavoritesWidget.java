package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 07/04/16.
 */
public class OSS_732_FavoritesWidget extends AbstractDomainTest {

    // {"modid", "docid"}
    private final String[][] fiveDocuments = {
            {"99", "901765862"},
            {"99", "901919946"},
            {"99", "901807664"},
            {"99", "901794413"},
            {"99", "9027690"}};

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-732", testCaseVersion = "1")
    public void oss_732_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ГФ КУ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1590", testCaseVersion = "1")
    public void oss_1590_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ОБР МИНИ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ОБР ВИП");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1398", testCaseVersion = "1")
    public void oss_1398_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ЮСС БУ");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1995", testCaseVersion = "1")
    public void oss_1995_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное УМД ВИП");
        unifiedTest(loginUmd());

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное УМД МИНИ");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1993", testCaseVersion = "1")
    public void oss_1993_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1962", testCaseVersion = "1")
    public void oss_1962_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1961", testCaseVersion = "1")
    public void oss_1961_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1922", testCaseVersion = "1")
    public void oss_1922_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ГЗ ВИП");
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Избранное ГЗ МИНИ");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1434", testCaseVersion = "1")
    public void oss_1434_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Справочник ФСС КУ");
        unifiedTest(loginFss());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .clickMyFavoritesButton()
                .clearAllBookmarks()
                .clickMyFavoritesButton()
                .refreshPage()

                .navigateToRecomendPage()
                .checkFavoritesWidgetIsPresent()
                .checkFavoritesWidgetTitleIsPresent()
                .checkFavoritesWidgetTextFadeIsPresent()

                .addLinksToFavorites(fiveDocuments)

                .refreshPage()
                .checkFavoritesWidgetFiveLinksArePresent()

                .clickOnFavoritesWidgetFirstDocumentLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()

                .clickOnFavoritesWidgetSecondDocumentLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()

                .clickOnFavoritesWidgetThirdDocumentLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()

                .clickOnFavoritesWidgetFourthDocumentLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()

                .clickOnFavoritesWidgetFifthDocumentLink()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()

                .removeAllTrainingHands()

                .clickOnFavoritesWidgetTitleLink()
                .checkFavoritesRubricatorIsPresent()

                .removeDocumentsFromFavorites()
                .logout()

                .navigateToRecomendPage()
                .checkFavoritesWidgetIsNotPresent();
    }
}

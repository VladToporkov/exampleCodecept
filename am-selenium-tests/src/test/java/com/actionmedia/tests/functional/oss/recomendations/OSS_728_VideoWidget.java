package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 21/02/16.
 */
public class OSS_728_VideoWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-728", testCaseVersion = "1")
    public void oss_728_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Видео БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Видео БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео МЦФЭР ГФ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2004", testCaseVersion = "1")
    public void oss_2004_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео УМД ВИП");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1977", testCaseVersion = "1")
    public void oss_1977_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1967", testCaseVersion = "1")
    public void oss_1967_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1956", testCaseVersion = "1")
    public void oss_1956_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1917", testCaseVersion = "1")
    public void oss_1917_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ГЗ ВИП");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1429", testCaseVersion = "1")
    public void oss_1429_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ФСС КУ");
        unifiedTest(loginFss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1393", testCaseVersion = "1")
    public void oss_1393_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginToInfo("vip");
        updateLoginAsInfo("uss.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ЮСС ВИП");
        unifiedTest(loginUss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ЮСС БУ");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1580", testCaseVersion = "1")
    public void oss_1580_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Видео ОБР ВИП");
        unifiedTest(loginEdu());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkVideoWidgetIsPresent()
                .checkVideoWidgetHasNoTitle()
                .checkVideoWidgetScreenshotIsPresent()
                .checkVideoWidgetLink()
                .checkVideoWidgetVideoDuration()

                .clickOnVideoWidgetScreenshot()
                .checkVideoPlayerIsPresent()
                .checkVideoTitleIsPresent()

                .navigateToRecomendPage()
                .clickOnVideoWidgetLink()
                .checkVideoPlayerIsPresent()
                .checkVideoTitleIsPresent()

                .logout();
    }
}

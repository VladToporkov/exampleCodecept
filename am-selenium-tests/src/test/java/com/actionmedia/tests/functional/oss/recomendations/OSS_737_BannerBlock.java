package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 12/04/16.
 */
public class OSS_737_BannerBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-737", testCaseVersion = "1")
    public void oss_737_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Баннер БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Баннер БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Баннер БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Баннер БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Баннер ГФ КУ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2026", testCaseVersion = "1")
    public void oss_2026_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ОБР ВИП");
        unifiedTest(loginEdu());

        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ОБР МИНИ");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1407", testCaseVersion = "1")
    public void oss_1407_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ЮСС БУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ЮСС ВИП");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2031", testCaseVersion = "1")
    public void oss_2031_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер УМД КУ");
        unifiedTest(loginUmd());

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер УМД ВИП");
        unifiedTest(loginUmd());

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер УМД МИНИ");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2030", testCaseVersion = "1")
    public void oss_2030_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2029", testCaseVersion = "1")
    public void oss_2029_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2028", testCaseVersion = "1")
    public void oss_2028_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2027", testCaseVersion = "1")
    public void oss_2027_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ГЗ ВИП");
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ГЗ МИНИ");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1443", testCaseVersion = "1")
    public void oss_1443_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Баннер ФСС КУ");
        unifiedTest(loginFss());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkBannerIsPresent()
                .clickOnBanner()
                .checkDocumentAfterClickingOnBanner()

                .returnToBack()
                .checkBannerTextWithScreenResolution1024px()
                .checkBannerTextWithScreenResolution1280px()
                .checkBannerTextWithScreenResolution1366px()

                .logout();
    }
}

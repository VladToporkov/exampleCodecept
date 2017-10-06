package com.actionmedia.tests.functional.oss.recomendations;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 11/04/16.
 */
public class OSS_734_YellowPanel extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-734", testCaseVersion = "1")
    public void oss_734_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Желтая плашка БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Желтая плашка БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ГФ КУ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1390", testCaseVersion = "1")
    public void oss_1390_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ЮСС БУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ЮСС ВИП");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1426", testCaseVersion = "1")
    public void oss_1426_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ФСС КУ");
        unifiedTest(loginFss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1909", testCaseVersion = "1")
    public void oss_1909_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ГЗ МИНИ");
        unifiedTest(loginGo());

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ГЗ ВИП");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1910", testCaseVersion = "1")
    public void oss_1910_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1912", testCaseVersion = "1")
    public void oss_1912_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1913", testCaseVersion = "1")
    public void oss_1913_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1914", testCaseVersion = "1")
    public void oss_1914_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Желтая плашка УМД КУ");
        unifiedTest(loginUmd());

        updateLoginAsInfo("umd.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Желтая плашка УМД МИНИ");
        unifiedTest(loginUmd());

        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Желтая плашка УМД ВИП");
        unifiedTest(loginUmd());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkYellowPanelIsPresent()
                .checkYellowPanelSearchInputIsPresent()
                .checkYellowPanelSearchInputPlaceholderTextIsPresent()
                .checkYellowPanelTipIsPresent()
                .checkYellowPanelTipQueryIsPresent()
                .checkYellowPanelAnswerIsPresent()
                .checkYellowPanelRubricatorLinksArePresent()

                .checkRubricatorLinksFromYellowPlate()

                .logout();
    }
}

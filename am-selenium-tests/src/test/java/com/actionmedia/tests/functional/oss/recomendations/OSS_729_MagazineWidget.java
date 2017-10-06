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
public class OSS_729_MagazineWidget extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-729", testCaseVersion = "1")
    public void oss_729_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги МЦФЭР ГФ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1581", testCaseVersion = "1")
    public void oss_1581_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ОБР ВИП");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1394", testCaseVersion = "1")
    public void oss_1394_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ЮСС БУ");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2001", testCaseVersion = "1")
    public void oss_2001_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги УМД ВИП");
        unifiedTest(loginUmd());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1989", testCaseVersion = "1")
    public void oss_1989_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1966", testCaseVersion = "1")
    public void oss_1966_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1957", testCaseVersion = "1")
    public void oss_1957_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1918", testCaseVersion = "1")
    public void oss_1918_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ГЗ ВИП");
        unifiedTest(loginGo());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1430", testCaseVersion = "1")
    public void oss_1430_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Журналы и книги ФСС КУ");
        unifiedTest(loginFss());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkMagazinesWidgetIsPresent()
                .checkMagazinesWidgetTitleIsPresent()
                .checkMagazinesWidgetMagazinesCoversIsPresent()
                .checkMagazinesWidgetMagazinesAreNotRepeated()
                .checkMagazinesWidgetRedMarkerIsPresent()
                .checkMagazinesWidgetTextNewMagazineIsPresent()

                .clickOnMagazinesWidgetTitle()
                .checkDefaultStateMagazinesPage()

                .navigateToRecomendPage()
                .clickOnMagazinesWidgetNotice()
                .checkDocumentIsOpened()

                .navigateToRecomendPage()
                .checkMagazinesWidgetMagazinesLinks()

                .checkMagazinesWidgetMagazinesCoversWithVariantResolutions()

                .logout();
    }

}

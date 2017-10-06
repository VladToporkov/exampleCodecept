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
public class OSS_738_NewsBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-738", testCaseVersion = "1")
    public void oss_738_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета БСС КУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Газета БСС БУ");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блоки Рекомендаций: Виджет Газета БСС УСН");
        unifiedTest(loginBss());

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета БСС ВИП");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ГФ КУ");
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1587", testCaseVersion = "2")
    public void oss_1587_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОБР КУ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОБР МИНИ");
        unifiedTest(loginEdu());

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОБР ВИП");
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1573", testCaseVersion = "2")
    public void oss_1573_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОТ КУ");
        unifiedTest(loginOT());

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОТ МИНИ");
        unifiedTest(loginOT());

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ОТ ВИП");
        unifiedTest(loginOT());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1405", testCaseVersion = "1")
    public void oss_1405_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ЮСС КУ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ЮСС МИНИ");
        unifiedTest(loginUss());

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ЮСС ВИП");
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1441", testCaseVersion = "1")
    public void oss_1441_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ФСС КУ");
        unifiedTest(loginFss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1920", testCaseVersion = "2")
    public void oss_1920_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ГЗ КУ");
        unifiedTest(loginGo());

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ГЗ МИНИ");
        unifiedTest(loginOT());

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ГЗ ВИП");
        unifiedTest(loginOT());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1959", testCaseVersion = "2")
    public void oss_1959_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ЭЛПУ КУ");
        unifiedTest(loginElpu());

        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета ЭЛПУ ВИП");
        unifiedTest(loginElpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1964", testCaseVersion = "2")
    public void oss_1964_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КЛПУ КУ");
        unifiedTest(loginKlpu());

        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КЛПУ ВИП");
        unifiedTest(loginKlpu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1991", testCaseVersion = "2")
    public void oss_1991_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КУЛЬТ КУ");
        unifiedTest(loginCult());

        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КУЛЬТ ВИП");
        unifiedTest(loginCult());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1998", testCaseVersion = "2")
    public void oss_1998_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КУЛЬТ КУ");
        unifiedTest(loginUmd());

        updateLoginAsInfo("umd.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КУЛЬТ МИНИ");
        unifiedTest(loginUmd());

        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блоки Рекомендаций: Виджет Газета КУЛЬТ ВИП");
        unifiedTest(loginUmd());
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToRecomendPage()
                .checkNewsBlockFirstBlockTitleIsPresent()
                .checkNewsBlockNewsArePresent()
                .checkNewsBlockTodayTitleIsPresent()
                .checkNewsBlockNewsArePresent()
                .checkNewsBlockTodayTitleIsPresent()
                .checkNewsBlockOnTheWeekTitleIsPresent()
                .checkNewsBlockPerMonthTitleIsPresent()
                .checkNewsBlockRecomendationNewsView()
                .checkNewsBlockNewsWithTypeArePresent()
                .checkNewsBlockLinksAllNewsArePresent()

                .checkNewsBlockNewsLinks()

                .clickOnNewsBlockFirstBlockTitle()
                .checkNewsIsPresent()

                .navigateToRecomendPage()
                .clickOnNewsBlockLinkAllNewsInFirstBlock()
                .checkNewsIsPresent()

                .navigateToRecomendPage()
                .clickOnNewsBlockLinkAllNewsInSecondBlock()
                .checkNewsIsPresent()

                .logout();
    }
}

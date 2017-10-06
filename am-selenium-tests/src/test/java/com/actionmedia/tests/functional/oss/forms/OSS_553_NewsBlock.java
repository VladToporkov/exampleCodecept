package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.IFormsPage;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 22/06/16.
 */
public class OSS_553_NewsBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-553", testCaseVersion = "3")
    public void oss_553_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Тест OSS-553 Новостная лента (Формы) БСС КУ");
        updateLoginAsInfo("bss.user.commercial");
        unifiedTest(loginBss(), "Новое в формах", true);

        report("Тест OSS-553 Новостная лента (Формы) БСС БУ");
        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        unifiedTest(loginBss(), "Новое в формах", true);

        report("Тест OSS-553 Новостная лента (Формы) БСС УСН");
        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        unifiedTest(loginBss(), "Новое в формах", true);

        report("Тест OSS-553 Новостная лента (Формы) БСС ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        unifiedTest(loginBss(), "Новое в формах", true);

        updateSystemInfo(SystemPubs.gf);
        report("Тест OSS-553 Новостная лента (Формы) ГФ");
        updateLoginAsInfo("gf.user.commercial");
        unifiedTest(loginGF(), "Новое в формах", true);

        updateSystemInfo(SystemPubs.kss);
        report("Тест OSS-553 Новостная лента (Формы) КСС КУ");
        updateLoginAsInfo("kss.user.commercial");
        unifiedTest(loginKss(), "Новое в формах", true);

        report("Тест OSS-553 Новостная лента (Формы) КСС БУ");
        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        unifiedTest(loginKss(), "Новое в формах", true);

        report("Тест OSS-553 Новостная лента (Формы) КСС ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        unifiedTest(loginKss(), "Новое в формах", true);

        updateSystemInfo(SystemPubs.uss);
        report("Тест OSS-553 Новостная лента (Формы) ЮСС КУ");
        updateLoginAsInfo("uss.user.commercial");
        unifiedTest(loginUss(), "Новое в формах", true);

        updateSystemInfo(SystemPubs.fss);
        report("Тест OSS-553 Новостная лента (Формы) ФСС КУ");
        updateLoginAsInfo("fss.user.commercial");
        unifiedTest(loginFss(), "Новое в положениях и регламентах", true);

        updateSystemInfo(SystemPubs.ehs);
        report("Тест OSS-553 Новостная лента (Формы) ОТ КУ");
        updateLoginAsInfo("ehs.user.commercial");
        unifiedTest(loginOT(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ОТ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        unifiedTest(loginOT(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ОТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        unifiedTest(loginOT(), "Новое в шаблонах", true);

        updateSystemInfo(SystemPubs.edu);
        report("Тест OSS-553 Новостная лента (Формы) ОБР КУ");
        updateLoginAsInfo("edu.user.commercial");
        unifiedTest(loginEdu(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ОБР МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        unifiedTest(loginEdu(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ОБР ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        unifiedTest(loginEdu(), "Новое в шаблонах", true);

        updateSystemInfo(SystemPubs.elpu);
        report("Тест OSS-553 Новостная лента (Формы) ЭЛПУ КУ");
        updateLoginAsInfo("elpu.user.commercial");
        unifiedTest(loginElpu(), "Новое в формах", false);

        report("Тест OSS-553 Новостная лента (Формы) ЭЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        unifiedTest(loginElpu(), "Новое в формах", false);

        updateSystemInfo(SystemPubs.klpu);
        report("Тест OSS-553 Новостная лента (Формы) КЛПУ КУ");
        updateLoginAsInfo("klpu.user.commercial");
        unifiedTest(loginKlpu(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) КЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        unifiedTest(loginKlpu(), "Новое в шаблонах", true);

        updateSystemInfo(SystemPubs.cult);
        report("Тест OSS-553 Новостная лента (Формы) КУЛЬТ КУ");
        updateLoginAsInfo("cult.user.commercial");
        unifiedTest(loginCult(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) КУЛЬТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        unifiedTest(loginCult(), "Новое в шаблонах", true);

        updateSystemInfo(SystemPubs.go);
        report("Тест OSS-553 Новостная лента (Формы) ГЗ КУ");
        updateLoginAsInfo("go.user.commercial");
        unifiedTest(loginGo(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ГЗ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        unifiedTest(loginGo(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) ГЗ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        unifiedTest(loginGo(), "Новое в шаблонах", true);

        updateSystemInfo(SystemPubs.umd);
        report("Тест OSS-553 Новостная лента (Формы) УМД КУ");
        updateLoginAsInfo("umd.user.commercial");
        unifiedTest(loginUmd(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) УМД МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        unifiedTest(loginUmd(), "Новое в шаблонах", true);

        report("Тест OSS-553 Новостная лента (Формы) УМД ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        unifiedTest(loginUmd(), "Новое в шаблонах", true);
    }

    private <T extends ISystemBasePage> void unifiedTest(T page, String title, boolean isCheckScroll) {
        IFormsPage doc = page
                .navigateToFormsPage()
                .checkNewsBlocksArePresent()
                .checkTitle(title)
                .checkNewsBlocksTitlesArePresent()
                .checkNewsBlocksDatesSortedInDescendingOrder()
                .checkNewsBlocksHaveTitleAndDescription()

                .scrollSeveralTimes(1);
        if (isCheckScroll) {
            doc
                    .checkNewsLoadedAfterScrollingDown()
                    .checkNewsBlocksTitlesArePresent()
                    .checkNewsBlocksDatesSortedInDescendingOrder()
                    .checkNewsBlocksHaveTitleAndDescription();

        }
        doc
                .clickOnRandomLinkFromNewsBlock()
                .checkDocumentIsOpened()

                .logout();
    }
}

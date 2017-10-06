package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 27/06/16.
 */
public class OSS_1911_CommonViewForms extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1911", testCaseVersion = "1")
    public void oss_1911_test() {
        //EHS
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) ОТ КУ");
        unifiedTest(loginOT(), "Все шаблоны");

        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        report("OSS-1911: Общее отображение раздела (Формы) ОТ МИНИ");
        unifiedTest(loginOT(), "Все шаблоны");

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) ОТ ВИП");
        unifiedTest(loginOT(), "Все шаблоны");

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) ОБР КУ");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        report("OSS-1911: Общее отображение раздела (Формы) ОБР МИНИ");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) ОБР ВИП");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        //ELPU
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) ЭЛПУ КУ");
        unifiedTest(loginElpu(), "Все формы");

        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) ЭЛПУ ВИП");
        unifiedTest(loginElpu(), "Все формы");

        //CULT
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) КУЛЬТ КУ");
        unifiedTest(loginCult(), "Все шаблоны");

        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) КУЛЬТ ВИП");
        unifiedTest(loginCult(), "Все шаблоны");

        //KLPU
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) КЛПУ КУ");
        unifiedTest(loginKlpu(), "Все шаблоны");

        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) КЛПУ ВИП");
        unifiedTest(loginKlpu(), "Все шаблоны");

        //GO
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) ГЗ КУ");
        unifiedTest(loginGo(), "Все шаблоны");

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("OSS-1911: Общее отображение раздела (Формы) ГЗ МИНИ");
        unifiedTest(loginGo(), "Все шаблоны");

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) ГЗ ВИП");
        unifiedTest(loginGo(), "Все шаблоны");

        //UMD
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) УМД КУ");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");

        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        report("OSS-1911: Общее отображение раздела (Формы) УМД МИНИ");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");

        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        report("OSS-1911: Общее отображение раздела (Формы) УМД ВИП");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("OSS-1911: Общее отображение раздела (Формы) ГФ КУ");
        unifiedTest(loginGF(), "Все формы");

    }

    private <T extends ISystemBasePage> void unifiedTest(T page, String name) {
        page
                .navigateToFormsPage()
                .checkNewsBlocksArePresent()
                .checkPopularBlockIsPresent()

                .checkRubricatorButtonIsPresent(name)
                .checkMyFavoritesRubricatorButtonIsPresent()

                .logout();
    }
}

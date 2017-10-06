package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 24/06/16.
 */
public class OSS_554_PopularBlockInForms extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-554", testCaseVersion = "3")
    public void oss_554_test() {
        updateSystemInfo(SystemPubs.bss);
        report("Тест OSS-554 Новостная лента (Популярное) БСС КУ");
        updateLoginAsInfo("bss.user.commercial");
        unifiedTest(loginBss());

        report("Тест OSS-554 Новостная лента (Популярное) БСС БУ");
        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        unifiedTest(loginBss());

        report("Тест OSS-554 Новостная лента (Популярное) БСС УСН");
        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        unifiedTest(loginBss());

        report("Тест OSS-554 Новостная лента (Популярное) БСС ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        unifiedTest(loginBss());

        updateSystemInfo(SystemPubs.gf);
        report("Тест OSS-554 Новостная лента (Популярное) ГФ");
        updateLoginAsInfo("gf.user.commercial");
        unifiedTest(loginGF());

        updateSystemInfo(SystemPubs.kss);
        report("Тест OSS-554 Новостная лента (Популярное) КСС КУ");
        updateLoginAsInfo("kss.user.commercial");
        unifiedTest(loginKss());

        report("Тест OSS-554 Новостная лента (Популярное) КСС БУ");
        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        unifiedTest(loginKss());

        report("Тест OSS-554 Новостная лента (Популярное) КСС ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        unifiedTest(loginKss());

        updateSystemInfo(SystemPubs.uss);
        report("Тест OSS-554 Новостная лента (Популярное) ЮСС КУ");
        updateLoginAsInfo("uss.user.commercial");
        unifiedTest(loginUss());

        report("Тест OSS-554 Новостная лента (Популярное) ЮСС ВИП");
        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        unifiedTest(loginUss());

        updateSystemInfo(SystemPubs.fss);
        report("Тест OSS-554 Новостная лента (Популярное) ФСС КУ");
        updateLoginAsInfo("fss.user.commercial");
        unifiedTest(loginFss());

        updateSystemInfo(SystemPubs.ehs);
        report("Тест OSS-554 Новостная лента (Популярное) ОТ КУ");
        updateLoginAsInfo("ehs.user.commercial");
        unifiedTest(loginOT());

        report("Тест OSS-554 Новостная лента (Популярное) ОТ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        unifiedTest(loginOT());

        report("Тест OSS-554 Новостная лента (Популярное) ОТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        unifiedTest(loginOT());

        updateSystemInfo(SystemPubs.edu);
        report("Тест OSS-554 Новостная лента (Популярное) ОБР КУ");
        updateLoginAsInfo("edu.user.commercial");
        unifiedTest(loginEdu());

        report("Тест OSS-554 Новостная лента (Популярное) ОБР МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        unifiedTest(loginEdu());

        report("Тест OSS-554 Новостная лента (Популярное) ОБР ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        unifiedTest(loginEdu());

        updateSystemInfo(SystemPubs.elpu);
        report("Тест OSS-554 Новостная лента (Популярное) ЭЛПУ КУ");
        updateLoginAsInfo("elpu.user.commercial");
        unifiedTest(loginElpu());

        report("Тест OSS-554 Новостная лента (Популярное) ЭЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        unifiedTest(loginElpu());

        updateSystemInfo(SystemPubs.klpu);
        report("Тест OSS-554 Новостная лента (Популярное) КЛПУ КУ");
        updateLoginAsInfo("klpu.user.commercial");
        unifiedTest(loginKlpu());

        report("Тест OSS-554 Новостная лента (Популярное) КЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        unifiedTest(loginKlpu());

        updateSystemInfo(SystemPubs.cult);
        report("Тест OSS-554 Новостная лента (Популярное) КУЛЬТ КУ");
        updateLoginAsInfo("cult.user.commercial");
        unifiedTest(loginCult());

        report("Тест OSS-554 Новостная лента (Популярное) КУЛЬТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        unifiedTest(loginCult());

        updateSystemInfo(SystemPubs.go);
        report("Тест OSS-554 Новостная лента (Популярное) ГЗ КУ");
        updateLoginAsInfo("go.user.commercial");
        unifiedTest(loginGo());

        report("Тест OSS-554 Новостная лента (Популярное) ГЗ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        unifiedTest(loginGo());

        report("Тест OSS-554 Новостная лента (Популярное) ГЗ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        unifiedTest(loginGo());

        updateSystemInfo(SystemPubs.umd);
        report("Тест OSS-554 Новостная лента (Популярное) УМД КУ");
        updateLoginAsInfo("umd.user.commercial");
        unifiedTest(loginUmd());

        report("Тест OSS-554 Новостная лента (Популярное) УМД МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        unifiedTest(loginUmd());

        report("Тест OSS-554 Новостная лента (Популярное) УМД ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        unifiedTest(loginUmd());
    }

    private <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .navigateToFormsPage()
                .checkPopularBlockIsPresent()

                .checkPopularBlockDocumentLinksArePresent()
                .checkPopularBlockMarkersArePresent()

                .clickOnRandomLinkFromPopularBlock()
                .checkDocumentIsOpened()

                .logout();
    }
}

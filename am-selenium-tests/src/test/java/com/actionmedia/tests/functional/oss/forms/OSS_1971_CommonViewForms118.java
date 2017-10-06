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
public class OSS_1971_CommonViewForms118 extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1971", testCaseVersion = "3")
    public void oss_1971_test() {
        updateSystemInfo(SystemPubs.ehs);
        report("OSS-1971:Общее отображение документов (118 модуль) ОТ КУ");
        updateLoginAsInfo("ehs.user.commercial");
        unifiedTest(loginOT(), "Все шаблоны");
        show_examples(); // only for optimum 1otruda.ru

        report("OSS-1971:Общее отображение документов (118 модуль) ОТ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        unifiedTest(loginOT(), "Все шаблоны");
        download_show_example(); //only for mini.1otruda

        report("OSS-1971:Общее отображение документов (118 модуль) ОТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        unifiedTest(loginOT(), "Все шаблоны");

        updateSystemInfo(SystemPubs.gf);
        report("OSS-1971:Общее отображение документов (118 модуль) ГФ КУ");
        updateLoginAsInfo("gf.user.commercial");
        unifiedTest(loginGF(), "Все формы");

        updateSystemInfo(SystemPubs.klpu);
        report("OSS-1971:Общее отображение документов (118 модуль) КЛПУ КУ");
        updateLoginAsInfo("klpu.user.commercial");
        unifiedTest(loginKlpu(), "Все шаблоны");

        report("OSS-1971:Общее отображение документов (118 модуль) КЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("klpu.user.vip");
        unifiedTest(loginKlpu(), "Все шаблоны");

        updateSystemInfo(SystemPubs.elpu);
        report("OSS-1971:Общее отображение документов (118 модуль) ЭЛПУ КУ");
        updateLoginAsInfo("elpu.user.commercial");
        unifiedTest(loginElpu(), "Все формы");

        report("OSS-1971:Общее отображение документов (118 модуль) ЭЛПУ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("elpu.user.vip");
        unifiedTest(loginElpu(), "Все формы");
    }

    private <T extends ISystemBasePage> void unifiedTest(T page, String name) {
        page
                .openDocumentByModuleIdAndDocId("#/document/118/random")
                // проверка общего отображения документа
                .checkCommonView118(name)

                .logout();
    }

    private void download_show_example() {
        loginOT()
                .openDocumentByModuleIdAndDocId("#/document/118/29253")
                .checkDownloadShowExampleLinkIsPresent()
                .logout();
    }

    private void show_examples() {
        loginOT()
                .openDocumentByModuleIdAndDocId("#/document/118/28996")
                .checkDownloadShowExamplesLinkIsPresent()
                .logout();
    }
}

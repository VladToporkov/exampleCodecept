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
public class OSS_1970_CommonViewForms118 extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-1970", testCaseVersion = "2")
    public void oss_1970_test() {
        updateSystemInfo(SystemPubs.edu);
        report("OSS-1970:Общее отображение документов (118 модуль) ОБР КУ");
        updateLoginAsInfo("edu.user.commercial");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        report("OSS-1970:Общее отображение документов (118 модуль) ОБР МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        report("OSS-1970:Общее отображение документов (118 модуль) ОБР ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        unifiedTest(loginEdu(), "Все шаблоны и примеры");

        updateSystemInfo(SystemPubs.go);
        report("OSS-1970:Общее отображение документов (118 модуль) ГЗ КУ");
        updateLoginAsInfo("go.user.commercial");
        unifiedTest(loginGo(), "Все шаблоны");

        report("OSS-1970:Общее отображение документов (118 модуль) ГЗ МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        unifiedTest(loginGo(), "Все шаблоны");

        report("OSS-1970:Общее отображение документов (118 модуль) ГЗ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        unifiedTest(loginGo(), "Все шаблоны");

        updateSystemInfo(SystemPubs.umd);
        report("OSS-1970:Общее отображение документов (118 модуль) УМД КУ");
        updateLoginAsInfo("umd.user.commercial");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");
        show_examples_not_visible();

        report("OSS-1970:Общее отображение документов (118 модуль) УМД МИНИ");
        updateLoginToInfo("mini");
        updateLoginAsInfo("umd.user.mini");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");

        report("OSS-1970:Общее отображение документов (118 модуль) УМД ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("umd.user.vip");
        unifiedTest(loginUmd(), "Все шаблоны и примеры");

        updateSystemInfo(SystemPubs.cult);
        report("OSS-1970:Общее отображение документов (118 модуль) КУЛЬТ КУ");
        updateLoginAsInfo("cult.user.commercial");
        unifiedTest(loginCult(), "Все шаблоны");

        report("OSS-1970:Общее отображение документов (118 модуль) КУЛЬТ ВИП");
        updateLoginToInfo("vip");
        updateLoginAsInfo("cult.user.vip");
        unifiedTest(loginCult(), "Все шаблоны");
    }

    private <T extends ISystemBasePage> void unifiedTest(T page, String name) {
        page
                .openDocumentByModuleIdAndDocId("#/document/118/random")
                // проверка общего отображения документа
                .checkCommonView118(name)

                .logout();
    }

    private void show_examples_not_visible() {
        loginUmd()
                .openDocumentByModuleIdAndDocId("#/document/118/44425")
                .checkDownloadShowExamplesLinkIsNotPresent()
                .checkDownloadShowExampleLinkIsNotPresent()
                .logout();
    }
}

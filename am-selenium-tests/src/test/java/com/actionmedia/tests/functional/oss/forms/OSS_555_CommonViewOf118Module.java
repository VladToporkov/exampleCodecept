package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: a.kulakov
 * Date: 21.04.2015
 * Time: 15:28
 */
public class OSS_555_CommonViewOf118Module extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-555", testCaseVersion = "1")
    public void oss_555_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-555:Общее отображение документов (118 модуль) КСС КУ");
        kss_555_test();

        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-555:Общее отображение документов (118 модуль) БСС КУ");
        bss_555_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-555:Общее отображение документов (118 модуль) ЮСС КУ");
        uss_555_test();
    }

    private void kss_555_test() {
        // http://www.1kadry.ru/#/document/118/24887/
        loginKss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("kss.118.module.24887"))
                // проверка общего отображения документа
                .checkCommonView118("Все формы")

                .logout();
    }

    private void bss_555_test() {
        // http://www.1gl.ru/#/document/118/24561/
        loginBss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("bss.118.module.24561"))
                // проверка общего отображения документа
                .checkCommonView118("Все формы")

                .logout();
    }

    private void uss_555_test() {
        // http://www.1jur.ru/#/document/118/25659/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.118.module.25659"))
                // проверка общего отображения документа
                .checkCommonView118("Все формы")

                .logout();
    }
}

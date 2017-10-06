package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 23.04.2015
 * Time: 14:48
 */
public class OSS_556_CommonViewOf140Module extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-556", testCaseVersion = "1")
    public void oss_556_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-556:Общее отображение документов (140 модуль) КСС КУ");
        kss_556_test();

        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-556:Общее отображение документов (140 модуль) БСС КУ");
        bss_556_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-556:Общее отображение документов (140 модуль) ЮСС КУ");
        uss_556_test();
    }

    private void kss_556_test() {
        // http://www.1kadry.ru/#/document/140/1022/
        loginKss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("kss.140.module.1022"))
                        // проверка общего отображения документа
                .checkCommonView140()

                .logout();
    }

    private void bss_556_test() {
        // http://www.1gl.ru/#/document/140/454/
        loginBss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("bss.140.module.454"))
                        // проверка общего отображения документа
                .checkCommonView140()

                .logout();
    }

    private void uss_556_test() {
        // http://www.1jur.ru/#/document/140/6688/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.140.module.6688"))
                        // проверка общего отображения документа
                .checkCommonView140()

                .logout();
    }
}

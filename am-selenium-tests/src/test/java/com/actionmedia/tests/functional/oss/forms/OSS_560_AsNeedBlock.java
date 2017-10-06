package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 24.04.2015
 * Time: 11:55
 */
public class OSS_560_AsNeedBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-560", testCaseVersion = "1")
    public void oss_560_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-560:Блок 'Когда понадобится:' (Формы) КСС КУ");
        kss_560_test();
        kss_560_test_1();

        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-560:Блок 'Когда понадобится:' (Формы) БСС КУ");
        bss_560_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-560:Блок 'Когда понадобится:' (Формы) ЮСС КУ");
        uss_560_test();
    }

    private void kss_560_test() {
        // http://www.1kadry.ru/#/document/140/17597/
        loginKss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("kss.140.module.17597"))
                        // проверка общего отображения блока
                .checkAsNeedBlock()

                .logout();
    }

    private void kss_560_test_1() {
        // http://www.1kadry.ru/#/document/118/20535/
        loginKss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("kss.118.module.20535"))
                        // проверка общего отображения блока
                .checkAsNeedBlock()

                .logout();
    }

    private void bss_560_test() {
        // http://www.1gl.ru/#/document/118/25848/
        loginBss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("bss.118.module.25848"))
                        // проверка общего отображения документа
                .checkAsNeedBlock()

                .logout();
    }

    private void uss_560_test() {
        // http://www.1jur.ru/#/document/140/18258/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.140.module.18258"))
                        // проверка общего отображения документа
                .checkAsNeedBlock()

                .logout();
    }
}

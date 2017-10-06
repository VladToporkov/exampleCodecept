package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 24.04.2015
 * Time: 13:39
 */
public class OSS_563_FormsComments extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-563", testCaseVersion = "1")
    public void oss_563_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-563:Комментарии (Формы) КСС КУ");
        kss_563_test();

        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-563:Комментарии (Формы) БСС КУ");
        bss_563_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-563:Комментарии (Формы) ЮСС КУ");
        uss_563_test();

        // FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("OSS-563:Комментарии (Формы) ФСС КУ");
        fss_563_test();
    }

    private void kss_563_test() {
        // http://www.1kadry.ru/#/document/118/16414/
        loginKss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("kss.118.module.16414"))
                        // проверка комментариев к формам
                .checkFormComments()

                .logout();
    }

    private void bss_563_test() {
        // http://www.1gl.ru/#/document/118/25100/
        loginBss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("bss.118.module.25100"))
                        // проверка комментариев к формам
                .checkFormComments()

                .logout();
    }

    private void uss_563_test() {
        // http://www.1jur.ru/#/document/118/11291/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.118.module.11291"))
                        // проверка комментариев к формам
                .checkFormComments()

                .logout();
    }

    private void fss_563_test() {
        // http://www.1fd.ru/#/document/191/493/
        loginFss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("fss.191.module.493"))
                        // проверка комментариев к формам
                .checkFormCommentsFss()

                .logout();
    }
}

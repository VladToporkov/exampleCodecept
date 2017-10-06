package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 16.04.2015
 * Time: 15:27
 */
public class OSS_306_VerifyFormsGalery extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-306", testCaseVersion = "1")
    public void oss_306_test() {
        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-306:Галерея (Формы) БСС КУ");
        bss_306_test();

        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-306:Галерея (Формы) КСС КУ");
        kss_306_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-306:Галерея (Формы) ЮСС КУ");
        uss_306_test();
    }

    private void kss_306_test() {
        // http://www.1kadry.ru/#/document/140/16357
        loginKss()
                // зайти в документ
                .openDocumentByModuleIdAndDocId("#/document/140/16357/actual")
                        // При наведении курсора появилась подсказка: "Нажмите для увеличения изображения"
                .checkTitleOfFormImage()
                        // проверка открытия галереи
                .checkFormGaleryOpen()

                .logout();
    }

    private void bss_306_test() {
        // http://www.1gl.ru/#/document/118/26258/
        loginBss()
                // зайти в документ
                .openDocumentByModuleIdAndDocId("#/document/118/26258/actual")
                        // При наведении курсора появилась подсказка: "Нажмите для увеличения изображения"
                .checkTitleOfFormImage()
                        // проверка открытия галереи
                .checkFormGaleryOpen()

                .openDocumentByModuleIdAndDocId("#/document/140/14831/actual")
                // При наведении курсора появилась подсказка: "Нажмите для увеличения изображения"
                .checkTitleOfFormImage()
                // проверка открытия галереи
                .checkFormGaleryOpen()

                .logout();
    }

    private void uss_306_test() {
        // http://www.1jur.ru/#/document/140/671/
        loginUss()
                // зайти в документ
                .openDocumentByModuleIdAndDocId("#/document/140/671/actual")
                        // При наведении курсора появилась подсказка: "Нажмите для увеличения изображения"
                .checkTitleOfFormImage()
                        // проверка открытия галереи
                .checkFormGaleryOpen()

                .logout();
    }
}

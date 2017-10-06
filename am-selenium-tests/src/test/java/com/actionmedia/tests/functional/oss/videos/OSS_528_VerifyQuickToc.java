package com.actionmedia.tests.functional.oss.videos;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: a.kulakov
 * Date: 15.04.2015
 * Time: 12:43
 */
public class OSS_528_VerifyQuickToc extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-528", testCaseVersion = "1")
    public void oss_528_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется OSS-528:Быстрое оглавление (Видео) ЮСС КУ");
        uss_528_test();
        uss_528_test_1();
    }

    private void uss_528_test() {
        // http://doc.1jur.ru/#/document/163/25/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.163.module.25"))
                        // проскролить документ
                .checkQuickTocScroll()
                .logout();
    }

    private void uss_528_test_1() {
        // http://www.1jur.ru/#/document/163/39/
        loginUss()
                // зайти в документ
                .openDocumentByUrl(getDocumentUrlByKey("uss.163.module.39"))
                        // проскролить документ
                .checkQuickTocScroll()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 11.01.16
 * Time: 20:47
 */
public class OSS_542_VerifyAboutBook extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS = "#/document/125/20217/";
    private static final String DOCUMENT_URL_KSS = "#/document/125/20217/";
    private static final String DOCUMENT_URL_USS = "#/document/234/112/";
    private static final String DOCUMENT_URL_FSS = "#/document/234/360/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-542", testCaseVersion = "1")
    public void oss_542_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется О книге БСС КУ");
        oss_542_bss_test();

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется О книге КСС КУ");
        oss_542_kss_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется О книге ЮСС КУ");
        oss_542_uss_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется О книге ФСС КУ");
        oss_542_fss_test();
    }

    private void oss_542_bss_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS)
                .clickAboutBookButton()
                .checkAboutBookBlock()

                .setBrowserSize(1024, 800)
                .checkSizeOfAboutBookBlockIsNotChanged()

                .logout();
    }

    private void oss_542_kss_test() {
        loginKss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS)
                .clickAboutBookButton()
                .checkAboutBookBlock()

                .setBrowserSize(1024, 800)
                .checkSizeOfAboutBookBlockIsNotChanged()

                .logout();
    }

    private void oss_542_uss_test() {
        loginUss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS)
                .clickAboutBookButton()
                .checkAboutBookBlock()

                .setBrowserSize(1024, 800)
                .checkSizeOfAboutBookBlockIsNotChanged()

                .logout();
    }

    private void oss_542_fss_test() {
        loginFss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS)
                .clickAboutBookButton()
                .checkAboutBookBlock()

                .setBrowserSize(1024, 800)
                .checkSizeOfAboutBookBlockIsNotChanged()

                .logout();
    }
}
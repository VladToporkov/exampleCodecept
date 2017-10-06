package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * User: n.tyukavkin
 * Date: 07.12.15
 * Time: 21:47
 */
public class OSS_473_OtherVersions extends AbstractDomainTest {

    private static final String BSS_ACTUAL_DOCUMENT = "#/document/117/19700/";
    private static final String KSS_ACTUAL_DOCUMENT = "#/document/117/17295/";
    private static final String USS_ACTUAL_DOCUMENT = "#/document/117/10674/";
    private static final String FSS_ACTUAL_DOCUMENT = "#/document/176/17/";
    private static final String BSS_EXPIRED_DOCUMENT = "#/document/117/17676/";
    private static final String KSS_EXPIRED_DOCUMENT = "#/document/117/8341/";
    private static final String USS_EXPIRED_DOCUMENT = "#/document/117/10715/";
    private static final String FSS_EXPIRED_DOCUMENT = "#/document/117/16355/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-473", testCaseVersion = "1")
    public void oss_473_test() {
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Информация о редакции (Справочник)... БСС КУ");
        loginBss()
                .openDocumentByModuleIdAndDocId(BSS_ACTUAL_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkOtherVersionsForDictionaryDocumentIsPresent()

                .openDocumentByModuleIdAndDocId(BSS_EXPIRED_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkExpiredVersionsForDictionaryDocumentIsPresent()
                .logout();

        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Информация о редакции (Справочник)... КСС КУ");
        loginKss()
                .openDocumentByModuleIdAndDocId(KSS_ACTUAL_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkOtherVersionsForDictionaryDocumentIsPresent()

                .openDocumentByModuleIdAndDocId(KSS_EXPIRED_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkExpiredVersionsForDictionaryDocumentIsPresent()
                .logout();

        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Информация о редакции (Справочник)... ЮСС КУ");
        loginUss()
                .openDocumentByModuleIdAndDocId(USS_ACTUAL_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkOtherVersionsForDictionaryDocumentIsPresent()

                .openDocumentByModuleIdAndDocId(USS_EXPIRED_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkExpiredVersionsForDictionaryDocumentIsPresent()
                .logout();

        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Информация о редакции (Справочник)... ФСС КУ");
        loginFss()
                .openDocumentByModuleIdAndDocId(FSS_ACTUAL_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkOtherVersionsForDictionaryDocumentIsPresent()

                .openDocumentByModuleIdAndDocId(FSS_EXPIRED_DOCUMENT)
                .checkVersionsBlockForDictionaryDocumentIsPresent()
                .checkExpiredVersionsForDictionaryDocumentIsPresent()
                .logout();
    }
}

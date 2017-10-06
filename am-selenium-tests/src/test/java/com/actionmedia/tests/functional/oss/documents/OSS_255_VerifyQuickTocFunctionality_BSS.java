package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_255_VerifyQuickTocFunctionality_BSS extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/901714421/actual";
    private static final String DOCUMENT_BU = "#/document/99/901714433/actual";
    private static final String DOCUMENT_USN = "#/document/99/901807664/actual";
    private static final String DOCUMENT_VIP = "#/document/99/9027690/actual";

    private static final String REDACTION_KU = "#/document/95/55188";
    private static final String REDACTION_BU = "#/document/95/3021";
    private static final String REDACTION_USN = "#/document/95/55192";
    private static final String REDACTION_VIP = "#/document/95/55150";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-255", testCaseVersion = "3")
    public void oss_255_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) БСС КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        //BSS BU
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Быстрое оглавление (Правовая база) БСС БУ");
        test(DOCUMENT_BU, REDACTION_BU);

        //BSS USN
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Быстрое оглавление (Правовая база) БСС УСН");
        test(DOCUMENT_USN, REDACTION_USN);

        //BSS VIP
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Быстрое оглавление (Правовая база) БСС ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginBss()
                .openDocumentByModuleIdAndDocId(documentId)
                .checkDocumentIsOpened()

                .checkQuickTocHasNumbers()

                .checkScrolling()

                .openDocumentByModuleIdAndDocId(redactionDocument)
                .checkDocumentIsOpened()

                .checkQuickTocHasNumbers()
                .checkQuickTocDoesNotContainItemsReferencesAndLinks()
                .checkScrolling()

                .logout();
    }
}

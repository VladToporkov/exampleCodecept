package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1747_VerifyQuickTocFunctionality_GO extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/901919338/actual";
    private static final String DOCUMENT_BU = "#/document/99/9027690/actual";
    private static final String DOCUMENT_VIP = "#/document/99/901714421/actual";

    private static final String REDACTION_KU = "#/document/95/55150";
    private static final String REDACTION_BU = "#/document/95/55185";
    private static final String REDACTION_VIP = "#/document/95/55188";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1747", testCaseVersion = "3")
    public void oss_1747_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ГЗ КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        updateLoginAsInfo("go.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Быстрое оглавление (Правовая база) ГЗ БАЗ");
        test(DOCUMENT_BU, REDACTION_BU);

        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Быстрое оглавление (Правовая база) ГЗ ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginGo()
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

package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1742_VerifyQuickTocFunctionality_USS extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/9027690/actual";
    private static final String DOCUMENT_VIP = "#/document/99/901714421/actual";

    private static final String REDACTION_KU = "#/document/95/55150";
    private static final String REDACTION_VIP = "#/document/95/55188";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1742", testCaseVersion = "3")
    public void oss_1742_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ЮСС КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Быстрое оглавление (Правовая база) ЮСС ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginUss()
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

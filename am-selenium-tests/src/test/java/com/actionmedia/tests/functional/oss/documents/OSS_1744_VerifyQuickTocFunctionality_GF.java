package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1744_VerifyQuickTocFunctionality_GF extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/901832805/actual";

    private static final String REDACTION_KU = "#/document/95/55176";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1744", testCaseVersion = "3")
    public void oss_1744_test() {
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ГФ КУ");
        test(DOCUMENT_KU, REDACTION_KU);
    }

    private void test(String documentId, String redactionDocument) {
        loginGF()
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

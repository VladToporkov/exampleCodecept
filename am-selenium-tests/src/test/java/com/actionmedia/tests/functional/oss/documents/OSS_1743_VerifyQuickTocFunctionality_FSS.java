package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1743_VerifyQuickTocFunctionality_FSS extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/901807667/actual";

    private static final String REDACTION_KU = "#/document/95/55196";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1743", testCaseVersion = "3")
    public void oss_1743_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ФСС КУ");
        test(DOCUMENT_KU, REDACTION_KU);
    }

    private void test(String documentId, String redactionDocument) {
        loginFss()
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

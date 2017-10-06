package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1746_VerifyQuickTocFunctionality_EDU extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/9015517/actual";
    private static final String DOCUMENT_BU = "#/document/99/902019731/actual";
    private static final String DOCUMENT_VIP = "#/document/99/901807667/actual";

    private static final String REDACTION_KU = "#/document/95/273";
    private static final String REDACTION_BU = "#/document/95/281";
    private static final String REDACTION_VIP = "#/document/95/55196";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1746", testCaseVersion = "3")
    public void oss_1746_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ОБР КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        updateLoginAsInfo("edu.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Быстрое оглавление (Правовая база) ОБР БАЗ");
        test(DOCUMENT_BU, REDACTION_BU);

        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Быстрое оглавление (Правовая база) ОБР ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginEdu()
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

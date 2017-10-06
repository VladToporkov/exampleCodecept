package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1745_VerifyQuickTocFunctionality_EHS extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/901832805/actual";
    private static final String DOCUMENT_BU = "#/document/99/901714421/actual";
    private static final String DOCUMENT_VIP = "#/document/99/9017477/actual";

    private static final String REDACTION_KU = "#/document/95/55176";
    private static final String REDACTION_BU = "#/document/95/55203";
    private static final String REDACTION_VIP = "#/document/95/55196";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1745", testCaseVersion = "3")
    public void oss_1745_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) ОТ КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        updateLoginAsInfo("ehs.user.mini");
        updateLoginToInfo("mini");
        report("Проверяется Быстрое оглавление (Правовая база) ОТ БАЗ");
        test(DOCUMENT_BU, REDACTION_BU);

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Быстрое оглавление (Правовая база) ОТ ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginOT()
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
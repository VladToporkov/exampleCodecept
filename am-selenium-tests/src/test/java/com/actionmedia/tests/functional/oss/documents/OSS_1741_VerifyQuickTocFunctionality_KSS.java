package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 23/05/16.
 */
public class OSS_1741_VerifyQuickTocFunctionality_KSS extends AbstractDomainTest {

    private static final String DOCUMENT_KU = "#/document/99/902019731/actual";
    private static final String DOCUMENT_BU = "#/document/99/901714421/actual";
    private static final String DOCUMENT_VIP = "#/document/99/901807667/actual";

    private static final String REDACTION_KU = "#/document/95/273";
    private static final String REDACTION_BU = "#/document/95/55188";
    private static final String REDACTION_VIP = "#/document/95/55196";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1741", testCaseVersion = "3")
    public void oss_1741_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Быстрое оглавление (Правовая база) КСС КУ");
        test(DOCUMENT_KU, REDACTION_KU);

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Быстрое оглавление (Правовая база) КСС БУ");
        test(DOCUMENT_BU, REDACTION_BU);

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Быстрое оглавление (Правовая база) КСС ВИП");
        test(DOCUMENT_VIP, REDACTION_VIP);
    }

    private void test(String documentId, String redactionDocument) {
        loginKss()
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
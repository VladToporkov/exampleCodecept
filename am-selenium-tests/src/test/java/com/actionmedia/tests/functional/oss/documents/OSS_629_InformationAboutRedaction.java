package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.util.TestUtils;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Pavel on 09/03/16.
 */
public class OSS_629_InformationAboutRedaction extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS_1_KU = "#/document/11/14498/actual";
    private static final String DOCUMENT_URL_BSS_1_BU = "#/document/12/69163/actual";
    private static final String DOCUMENT_URL_BSS_1_USN = "#/document/199/10265/actual";
    private static final String DOCUMENT_URL_BSS_1_VIP = "#/document/86/68599/actual";

    private static final String DOCUMENT_URL_BSS_2_KU = "#/document/111/9940";
    private static final String DOCUMENT_URL_BSS_2_BU = "#/document/12/67594/";
    private static final String DOCUMENT_URL_BSS_2_USN = "#/document/199/10200/";
    private static final String DOCUMENT_URL_BSS_2_VIP = "#/document/86/8770";

    private static final String DOCUMENT_URL_BSS_4_KU = "#/document/184/3683";
    private static final String DOCUMENT_URL_BSS_4_BU = "#/document/184/3683";
    private static final String DOCUMENT_URL_BSS_4_USN = "#/document/184/3732";
    private static final String DOCUMENT_URL_BSS_4_VIP = "#/document/184/3683";

    private static final String DOCUMENT_URL_BSS_5_KU = "#/document/184/2356/";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-629", testCaseVersion = "2")
    public void oss_629_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Информация о редакции БСС КУ");
        stepsFrom1To4(DOCUMENT_URL_BSS_1_KU, DOCUMENT_URL_BSS_2_KU, DOCUMENT_URL_BSS_4_KU);

        step5(); //only for bss commercial

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Проверяется Информация о редакции БСС БУ");
        stepsFrom1To4(DOCUMENT_URL_BSS_1_BU, DOCUMENT_URL_BSS_2_BU, DOCUMENT_URL_BSS_4_BU);

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Проверяется Информация о редакции БСС УСН");
        stepsFrom1To4(DOCUMENT_URL_BSS_1_USN, DOCUMENT_URL_BSS_2_USN, DOCUMENT_URL_BSS_4_USN);

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Проверяется Информация о редакции БСС ВИП");
        stepsFrom1To4(DOCUMENT_URL_BSS_1_VIP, DOCUMENT_URL_BSS_2_VIP, DOCUMENT_URL_BSS_4_VIP);
    }

    private void stepsFrom1To4(String anotherRedactionDoc, String expiredDoc, String redactionFromDoc) {
        loginBss()
                .navigateToRecomendPage()
                .report("Проверяется колонтитул Другие редакции")
                .openDocumentByModuleIdAndDocId(anotherRedactionDoc)
                .checkOtherVersionsForDictionaryDocumentIsPresent()

                .report("Проверяется колонтитул Редакция утратила силу")
                .openDocumentByModuleIdAndDocId(expiredDoc)
                .checkExpiredWarningIsPresent()

                .report("Проверяется колонтитул Редакция не вступила в силу")
                .openDocumentByModuleIdAndDocId(TestUtils.getRandomFutureDocumentWithoutDate())
                .checkFutureWarningIsPresent()

                .report("Проверяется колонтитул Редакция вступает в силу")
                .openDocumentByModuleIdAndDocId(TestUtils.getRandomFutureDocumentWithDate())
                .checkFutureWarningIsPresent()

                .report("Проверяется колонтитул Редакция от")
                .openDocumentByModuleIdAndDocId(redactionFromDoc)
                .checkTextDocumentEditionFromInDocHeader()

                .logout();
    }

    private void step5() {
        loginBss()
                .navigateToRecomendPage()
                .report("Проверяется колонтитул Редакция утратила силу")
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_5_KU)
                .checkExpiredWarningNOTLinkIsPresent()
                .logout();
    }
}

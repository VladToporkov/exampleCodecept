package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 18/01/16.
 */
public class OSS_639_MetaTagsRecomendationDocuments extends AbstractDomainTest {

    private static final String DOCUMENT_URL_BSS_TABLE_OF_CONTENTS_1 = "#/document/111/12450";
    private static final String DOCUMENT_URL_GF_TABLE_OF_CONTENTS = "#/document/11/15560";
    private static final String DOCUMENT_URL_BSS_WITHOUT_CONTENTS_1 = "#/document/11/14171/";
    private static final String DOCUMENT_URL_BSS_WITHOUT_CONTENTS_2 = "#/document/12/67586";//
    private static final String DOCUMENT_URL_BSS_WITHOUT_CONTENTS_3 = "#/document/112/43914";//
    private static final String DOCUMENT_URL_BSS_WITHOUT_CONTENTS_4 = "#/document/170/9598";

    private static final String DOCUMENT_URL_KSS_TABLE_OF_CONTENTS = "#/document/130/50860";
    private static final String DOCUMENT_URL_KSS_WITHOUT_CONTENTS = "#/document/131/77158";

    private static final String DOCUMENT_URL_USS_TABLE_OF_CONTENTS = "#/document/184/2340";
    private static final String DOCUMENT_URL_USS_WITHOUT_CONTENTS = "#/document/131/72545";

    private static final String DOCUMENT_URL_FSS_TABLE_OF_CONTENTS = "#/document/184/3745";
    private static final String DOCUMENT_URL_FSS_WITHOUT_CONTENTS = "#/document/178/2027";

    private static final String DOCUMENT_URL_EHS_TABLE_OF_CONTENTS = "#/document/16/14430";
    private static final String DOCUMENT_URL_EHS_WITHOUT_CONTENTS = "#/document/16/1049";

    private static final String DOCUMENT_URL_EDU_TABLE_OF_CONTENTS_VIP = "#/document/16/2590";
    private static final String DOCUMENT_URL_EDU_WITHOUT_CONTENTS_VIP = "#/document/16/2600";

    private static final String DOCUMENT_URL_GO_TABLE_OF_CONTENTS = "#/document/16/21845";
    private static final String DOCUMENT_URL_GO_WITHOUT_CONTENTS = "#/document/16/6165";

    private static final String DOCUMENT_URL_ELPU_TABLE_OF_CONTENTS = "#/document/16/21827";
    private static final String DOCUMENT_URL_ELPU_WITHOUT_CONTENTS = "#/document/184/5144";

    private static final String DOCUMENT_URL_KLPU_TABLE_OF_CONTENTS = "#/document/16/21722";
    private static final String DOCUMENT_URL_KLPU_WITHOUT_CONTENTS = "#/document/184/4561";

    private static final String DOCUMENT_URL_CULT_TABLE_OF_CONTENTS = "#/document/16/21819";
    private static final String DOCUMENT_URL_CULT_WITHOUT_CONTENTS = "#/document/184/5140";

    private static final String DOCUMENT_URL_UMD_TABLE_OF_CONTENTS = "#/document/111/12450";
    private static final String DOCUMENT_URL_UMD_WITHOUT_CONTENTS = "#/document/170/9598";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-639", testCaseVersion = "1")
    public void oss_639_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description БСС КУ");
        unifiedTest(loginBss(), DOCUMENT_URL_BSS_TABLE_OF_CONTENTS_1, DOCUMENT_URL_BSS_WITHOUT_CONTENTS_1);

        //BSS BU
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Общий функционал документов Мета теги keywords & description БСС БУ");
        bss_bu_test();

        //BSS УСН
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Общий функционал документов Мета теги keywords & description БСС УСН");
        bss_usn_test();

        //BSS ВИП
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общий функционал документов Мета теги keywords & description БСС ВИП");
        bss_vip_test();

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description БСС КУ");
        unifiedTest(loginGF(), DOCUMENT_URL_GF_TABLE_OF_CONTENTS, DOCUMENT_URL_BSS_WITHOUT_CONTENTS_1);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1484", testCaseVersion = "1")
    public void oss_1484_test() {
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description КСС КУ");
        unifiedTest(loginKss(), DOCUMENT_URL_KSS_TABLE_OF_CONTENTS, DOCUMENT_URL_KSS_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1485", testCaseVersion = "1")
    public void oss_1485_test() {
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description ЮСС КУ");
        unifiedTest(loginUss(), DOCUMENT_URL_USS_TABLE_OF_CONTENTS, DOCUMENT_URL_USS_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1486", testCaseVersion = "1")
    public void oss_1486_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description ФСС КУ");
        unifiedTest(loginFss(), DOCUMENT_URL_FSS_TABLE_OF_CONTENTS, DOCUMENT_URL_FSS_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1829", testCaseVersion = "2")
    public void oss_1829_test() {
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description ОТ КУ");
        unifiedTest(loginOT(), DOCUMENT_URL_EHS_TABLE_OF_CONTENTS, DOCUMENT_URL_EHS_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1838", testCaseVersion = "2")
    public void oss_1838_test() {
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Общий функционал документов Мета теги keywords & description ОБР ВИП");
        unifiedTest(loginEdu(), DOCUMENT_URL_EDU_TABLE_OF_CONTENTS_VIP, DOCUMENT_URL_EDU_WITHOUT_CONTENTS_VIP);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2073", testCaseVersion = "2")
    public void oss_2073_test() {
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description ГЗ КУ");
        unifiedTest(loginGo(), DOCUMENT_URL_GO_TABLE_OF_CONTENTS, DOCUMENT_URL_GO_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2074", testCaseVersion = "2")
    public void oss_2074_test() {
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description ЭЛПУ КУ");
        unifiedTest(loginElpu(), DOCUMENT_URL_ELPU_TABLE_OF_CONTENTS, DOCUMENT_URL_ELPU_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2075", testCaseVersion = "2")
    public void oss_2075_test() {
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description КЛПУ КУ");
        unifiedTest(loginKlpu(), DOCUMENT_URL_KLPU_TABLE_OF_CONTENTS, DOCUMENT_URL_KLPU_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2076", testCaseVersion = "2")
    public void oss_2076_test() {
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description КУЛЬТ КУ");
        unifiedTest(loginCult(), DOCUMENT_URL_CULT_TABLE_OF_CONTENTS, DOCUMENT_URL_CULT_WITHOUT_CONTENTS);
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-2077", testCaseVersion = "2")
    public void oss_2077_test() {
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.commercial");
        report("Проверяется Общий функционал документов Мета теги keywords & description УМД КУ");
        unifiedTest(loginUmd(), DOCUMENT_URL_UMD_TABLE_OF_CONTENTS, DOCUMENT_URL_UMD_WITHOUT_CONTENTS);
    }

    private void bss_bu_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_WITHOUT_CONTENTS_2)
                .checkMetaTagsAndSavedDataContent()

                .logout();
    }

    private void bss_usn_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_WITHOUT_CONTENTS_3)
                .checkMetaTagsAndSavedDataContent()

                .logout();
    }

    private void bss_vip_test() {
        loginBss()
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_WITHOUT_CONTENTS_4)
                .checkMetaTagsAndSavedDataContent()

                .logout();
    }

    public <T extends ISystemBasePage> void unifiedTest(T page, String docWithContents, String docWithoutContents) {
        page
                .openDocumentByModuleIdAndDocId(docWithContents)
                .checkMetaTagsAndTableOfContents()

                .openDocumentByModuleIdAndDocId(docWithoutContents)
                .checkMetaTagsAndSavedDataContent()

                .logout()

                .openDocumentByModuleIdAndDocId(docWithoutContents)
                .checkMetaTagsAndSavedDataContent();
    }
}
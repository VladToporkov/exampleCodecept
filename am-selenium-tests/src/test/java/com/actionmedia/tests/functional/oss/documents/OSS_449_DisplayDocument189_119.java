package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.bss.BssBasePage;
import com.actionmedia.pages.cult.CultBasePage;
import com.actionmedia.pages.edu.EduBasePage;
import com.actionmedia.pages.elpu.ElpuBasePage;
import com.actionmedia.pages.fss.FssBasePage;
import com.actionmedia.pages.gf.GFBasePage;
import com.actionmedia.pages.go.GoBasePage;
import com.actionmedia.pages.klpu.KlpuBasePage;
import com.actionmedia.pages.kss.KssBasePage;
import com.actionmedia.pages.ot.OTBasePage;
import com.actionmedia.pages.umd.UmdBasePage;
import com.actionmedia.pages.uss.UssBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * Created by Shman4ik on 26.02.2015.
 */
public class OSS_449_DisplayDocument189_119 extends AbstractDomainTest {

    private static final String BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS = "Все журналы и книги";
    private static final String BUTTON_NAME_ALL_MAGAZINES = "Все журналы";

    private static final String DOCUMENT_URL_KSS_189 = "#/document/189/345302/actual";
    private static final String DOCUMENT_URL_BSS_189 = "#/document/189/350927/actual";
    private static final String DOCUMENT_URL_FSS_189 = "#/document/189/368221/actual";
    private static final String DOCUMENT_URL_GF_189 = "#/document/189/440978/actual";
    private static final String DOCUMENT_URL_OT_189 = "#/document/189/318717/actual";
    private static final String DOCUMENT_URL_EDU_189 = "#/document/189/414567/actual";
    private static final String DOCUMENT_URL_UMD_189 = "#/document/189/459405/actual";
    private static final String DOCUMENT_URL_ELPU_189 = "#/document/189/459390/actual";
    private static final String DOCUMENT_URL_KLPU_189 = "#/document/189/450310/actual";
    private static final String DOCUMENT_URL_GO_189 = "#/document/189/462228/actual";
    private static final String DOCUMENT_URL_CULT_189 = "#/document/189/451026/actual";

    private static final String DOCUMENT_URL_KSS_119 = "#/document/119/39734/actual";
    private static final String DOCUMENT_URL_BSS_119 = "#/document/119/10984/actual";
    private static final String DOCUMENT_URL_USS_119 = "#/document/119/75937/actual";
    private static final String DOCUMENT_URL_FSS_119 = "#/document/119/10985/actual";
    private static final String DOCUMENT_URL_GF_119 = "#/document/119/10984/actual";

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-449", testCaseVersion = "7")
    public void oss_449_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется  Общее отображение документов (189, 119 модуль Журналы) КСС КУ");
        KssBasePage kssBasePage = loginKss();
        kssDocument_189(kssBasePage);
        kssDocument_119(kssBasePage);

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется  Общее отображение документов (189, 119 модуль Журналы) БСС КУ");
        BssBasePage bssBasePage = loginBss();
        bssDocument_189(bssBasePage);
        bssDocument_119(bssBasePage);

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется  Общее отображение документов (189, 119 модуль Журналы) ЮСС КУ");
        UssBasePage ussBasePage = loginUss();
        ussDocument_119(ussBasePage);

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется  Общее отображение документов (189, 119 модуль Журналы) ФСС КУ");
        FssBasePage fssBasePage = loginFss();
        fssDocument_189(fssBasePage);
        fssDocument_119(fssBasePage);

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется  Общее отображение документов (189, 119 модуль Журналы) ГФ КУ");
        GFBasePage gfBasePage = loginGF();
        gfDocument_189(gfBasePage);
        gfDocument_119(gfBasePage);

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) ОБР КУ");
        EduBasePage eduBasePage = loginEdu();
        eduDocument_189(eduBasePage);

        //OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) ОТ КУ");
        OTBasePage otBasePage = loginOT();
        otDocument_189(otBasePage);

        //UMD
        updateSystemInfo(SystemPubs.umd);
        updateLoginAsInfo("umd.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) УМД КУ");
        UmdBasePage umdBasePage = loginUmd();
        umdDocument_189(umdBasePage);

        //ELPU
        updateSystemInfo(SystemPubs.elpu);
        updateLoginAsInfo("elpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) ЭЛПУ КУ");
        ElpuBasePage elpuBasePage = loginElpu();
        elpuDocument_189(elpuBasePage);

        //KLPU
        updateSystemInfo(SystemPubs.klpu);
        updateLoginAsInfo("klpu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) КЛПУ КУ");
        KlpuBasePage klpuBasePage = loginKlpu();
        klpuDocument_189(klpuBasePage);

        //GO
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) ГЗ КУ");
        GoBasePage goBasePage = loginGo();
        goDocument_189(goBasePage);

        //CULT
        updateSystemInfo(SystemPubs.cult);
        updateLoginAsInfo("cult.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется  Общее отображение документов (189) КУЛЬТ КУ");
        CultBasePage cultBasePage = loginCult();
        cultDocument_189(cultBasePage);
    }

    private void kssDocument_189(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_189)
                .checkDisplayNameJournal()
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void kssDocument_119(KssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KSS_119)
                .checkDisplayCover()
                .checkArticleTitle_119()
                .checkDisplayStarsSection()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void bssDocument_189(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_189)
                .checkDisplayNameJournal()
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDispalyTextInJournal()

                .checkInMyFavoritesIcon()
                .checkBrowseIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void bssDocument_119(BssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_BSS_119)
                .checkDisplayCover()
                .checkArticleTitle_119()
                .checkDisplayStarsSection()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void gfDocument_189(GFBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_GF_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();

    }

    private void eduDocument_189(EduBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_EDU_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();

    }

    private void otDocument_189(OTBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_OT_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void cultDocument_189(CultBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_CULT_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void goDocument_189(GoBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_GO_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void klpuDocument_189(KlpuBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_KLPU_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void elpuDocument_189(ElpuBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_ELPU_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void umdDocument_189(UmdBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_UMD_189)
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDisplayTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void gfDocument_119(GFBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_GF_119)
                .checkDisplayCover()
                .checkArticleTitle_119()
                .checkDisplayStarsSection()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void ussDocument_119(UssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_USS_119)

                .checkDisplayCover()
                .checkArticleTitle_119()
                .checkDisplayStarsSection()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }

    private void fssDocument_189(FssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_189)
                .checkDisplayNameJournal()
                .checkPudDateJournal()
                .checkArticleTitle()
                .checkDispalyTextInJournal()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent();
    }

    private void fssDocument_119(FssBasePage page) {
        page
                .openDocumentByModuleIdAndDocId(DOCUMENT_URL_FSS_119)
                .checkDisplayCover()
                .checkArticleTitle_119()
                .checkDisplayStarsSection()

                .checkInMyFavoritesIcon()
                .checkPrintIcon()
                .checkWordButtonIsPresent()
                .checkShareIcon()
                .checkBackwardIcon()
                .checkForwardIcon()

                .checkRubricatorButtonIsPresent(BUTTON_NAME_ALL_MAGAZINES_AND_BOOKS)
                .checkMyFavoritesRubricatorButtonIsPresent()
                .checkSoderButtonIsPresent()
                .logout();
    }
}
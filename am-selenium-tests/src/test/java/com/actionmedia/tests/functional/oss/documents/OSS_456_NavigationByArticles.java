package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;

/**
 * Created by Pavel on 18/04/16.
 */
public class OSS_456_NavigationByArticles extends AbstractDomainTest {

    private static final String BSS_MAGAZINE_160 = "#/document/160/2195567/";
    private static final String BSS_MAGAZINE_126 = "#/document/126/430219/";
    private static final String BSS_MAGAZINE_119 = "#/document/119/10984/";
    private static final String BSS_MAGAZINE_189 = "#/document/189/350927";
    private static final String BSS_MAGAZINE_189_BU = "#/document/189/424020";

    private static final String KSS_MAGAZINE_160 = "#/document/160/2194099/";
    private static final String KSS_MAGAZINE_126 = "#/document/126/337442/";
    private static final String KSS_MAGAZINE_119 = "#/document/119/39735/";
    private static final String KSS_MAGAZINE_189 = "#/document/189/344743/";

    private static final String GF_MAGAZINE_160 = "#/document/160/2200083/";
    private static final String GF_MAGAZINE_126 = "#/document/126/443262/";
    private static final String GF_MAGAZINE_119 = "#/document/119/10984/";
    private static final String GF_MAGAZINE_189 = "#/document/189/440978/";

    private static final String USS_MAGAZINE_160 = "#/document/160/9517/";
    private static final String USS_MAGAZINE_126 = "#/document/126/295130/";
    private static final String USS_MAGAZINE_119 = "#/document/119/75937/";
    private static final String USS_MAGAZINE_189 = "#/document/189/370752/";

    private static final String FSS_MAGAZINE_160 = "#/document/160/2196119/";
    private static final String FSS_MAGAZINE_119 = "#/document/119/10985/";
    private static final String FSS_MAGAZINE_189_1 = "#/document/189/433377/";
    private static final String FSS_MAGAZINE_189_2 = "#/document/189/368221/";

    private static final String OT_MAGAZINE_189 = "#/document/189/433217/";
    private static final String OT_VIP_MAGAZINE_189_1 = "#/document/189/318717/";
    private static final String OT_VIP_MAGAZINE_189_2 = "#/document/189/411746/";

    private static final String EDU_VIP_MAGAZINE_189_1 = "#/document/189/434733/";
    private static final String EDU_VIP_MAGAZINE_189_2 = "#/document/189/442632/";


    @Test(groups = {inTesting})
    @TestLink(testCaseId = "OSS-456", testCaseVersion = "3")
    public void oss_456_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Навигация по статьям БСС КУ");
        bssMagazine(BSS_MAGAZINE_160);
        bssMagazine(BSS_MAGAZINE_126);
        bssMagazine(BSS_MAGAZINE_119);
        bssMagazine(BSS_MAGAZINE_189);

        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Навигация по статьям БСС БУ");
        bssMagazine(BSS_MAGAZINE_189_BU);

        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Навигация по статьям КСС КУ");
        kssMagazine(KSS_MAGAZINE_160);
        kssMagazine(KSS_MAGAZINE_126);
        kssMagazine(KSS_MAGAZINE_119);
        kssMagazine(KSS_MAGAZINE_189);

        //GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Проверяется Навигация по статьям ГФ КУ");
        gfMagazine(GF_MAGAZINE_160);
        gfMagazine(GF_MAGAZINE_126);
        gfMagazine(GF_MAGAZINE_119);
        gfMagazine(GF_MAGAZINE_189);

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Навигация по статьям ЮСС КУ");
        ussMagazine(USS_MAGAZINE_160);
        ussMagazine(USS_MAGAZINE_126);
        ussMagazine(USS_MAGAZINE_119);
        ussMagazine(USS_MAGAZINE_189);

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Навигация по статьям ФСС КУ");
        fssMagazine(FSS_MAGAZINE_160);
        fssMagazine(FSS_MAGAZINE_189_1);
        fssMagazine(FSS_MAGAZINE_119);
        fssMagazine(FSS_MAGAZINE_189_2);

        //OT
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Проверяется Навигация по статьям МЦФЭР ОТ");
        otMagazine(OT_MAGAZINE_189);

        updateLoginAsInfo("ehs.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Навигация по статьям МЦФЭР ОТ");
        otMagazine(OT_VIP_MAGAZINE_189_1);
        otMagazine(OT_VIP_MAGAZINE_189_2);

        //EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Навигация по статьям МЦФЭР ОБР");
        eduMagazine(EDU_VIP_MAGAZINE_189_1);
        eduMagazine(EDU_VIP_MAGAZINE_189_2);
    }

    private void bssMagazine(String document) {
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void kssMagazine(String document) {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void gfMagazine(String document) {
        loginGF()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void ussMagazine(String document) {
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void fssMagazine(String document) {
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void otMagazine(String document) {
        loginOT()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }

    private void eduMagazine(String document) {
        loginEdu()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(document)
                .clickTableOfContentsButton()
                .clickFirstArticleFromTableOfContents()

                .checkPrevButtonInTopIsAbsent()
                .checkPrevButtonInBottomIsAbsent()

                .clickTableOfContentsButton()
                .clickLastArticleFromTableOfContents()

                .checkNextButtonInTopIsAbsent()
                .checkNextButtonInBottomIsAbsent()

                .openDocumentByModuleIdAndDocId(document)

                .checkNextAndPrevButtonsInTopMenuArePresent()
                .checkNextAndPrevButtonsInBottomMenuArePresent()

                .clickOnNextButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnPrevButtonInTopMenu()
                .checkDocumentIsOpened()

                .clickOnNextButtonInBottomMenu()
                .checkDocumentIsOpened()

                .clickOnPreviousButtonInBottomMenu()
                .checkDocumentIsOpened()

                .logout();
    }


}

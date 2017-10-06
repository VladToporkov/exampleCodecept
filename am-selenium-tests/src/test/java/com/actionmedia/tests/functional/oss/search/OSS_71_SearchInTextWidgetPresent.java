package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Pavel on 17/01/16.
 */
public class OSS_71_SearchInTextWidgetPresent extends AbstractDomainTest {

//    http://bss-rt.actiondigital.ru/#/document/189/205712/
//    http://bss-rt.actiondigital.ru/#/document/117/21486/
//    http://bss-rt.actiondigital.ru/#/document/99/902316088/
//    http://bss-rt.actiondigital.ru/#/document/11/13500/
//    http://bss-rt.actiondigital.ru/#/document/184/4759/

//    http://kss-rt.actiondigital.ru/#/document/130/51512/
//    http://kss-rt.actiondigital.ru/#/document/99/901885307/
//    http://kss-rt.actiondigital.ru/#/document/117/19275/
//    http://kss-rt.actiondigital.ru/#/document/189/443247/
//    http://kss-rt.actiondigital.ru/#/document/211/43/

//    http://uss-rt.actiondigital.ru/#/document/165/2670/
//    http://uss-rt.actiondigital.ru/#/document/99/902135756/
//    http://uss-rt.actiondigital.ru/#/document/117/19615/
//    http://uss-rt.actiondigital.ru/#/document/189/452955/
//    http://uss-rt.actiondigital.ru/#/document/184/4937/

//    http://fss-rt.actiondigital.ru/#/document/173/115/
//    http://fss-rt.actiondigital.ru/#/document/99/902316088/
//    http://fss-rt.actiondigital.ru/#/document/189/452206/
//    http://fss-rt.actiondigital.ru/#/document/176/233/

    private static final String BSS_189 = "/#/document/189/205712/";
    private static final String BSS_117 = "/#/document/117/21486/";
    private static final String BSS_99 = "/#/document/99/902316088/";
    private static final String BSS_11 = "/#/document/11/13500/";
    private static final String BSS_184 = "/#/document/184/4759/";

    private static final String KSS_130 = "/#/document/130/51512/";
    private static final String KSS_117 = "/#/document/117/19275/";
    private static final String KSS_99 = "/#/document/99/901885307/";
    private static final String KSS_211 = "/#/document/211/43/";
    private static final String KSS_184 = "/#/document/189/443247/";

    private static final String USS_165 = "/#/document/165/2670/";
    private static final String USS_117 = "/#/document/117/19275/";
    private static final String USS_99 = "/#/document/99/902135756/";
    private static final String USS_184 = "/#/document/184/4937/";
    private static final String USS_189 = "/#/document/189/452955/";

    private static final String FSS_173 = "/#/document/173/115/";
    private static final String FSS_189 = "/#/document/189/452206/";
    private static final String FSS_99 = "/#/document/99/902316088/";
    private static final String FSS_176 = "/#/document/176/233/";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-71", testCaseVersion = "1")
    public void oss_71_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах БСС КУ");
        bss_test();

        //kss
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах КСС КУ");
        kss_test();

        //uss
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах ЮСС КУ");
        uss_test();

        //fss
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется виджет Поиск в тексте в документах ФСС КУ");
        fss_test();
    }

    public void bss_test() {
        loginBss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(BSS_189)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(BSS_117)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(BSS_99)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(BSS_11)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(BSS_184)
                .checkSearchInTextWidgetIsPresent()

                .logout();
    }

    public void kss_test() {
        loginKss()
                .navigateToAnswersPage()
                .openDocumentByModuleIdAndDocId(KSS_130)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(KSS_117)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(KSS_99)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(KSS_211)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(KSS_184)
                .checkSearchInTextWidgetIsPresent()

                .logout();
    }

    public void uss_test() {
        loginUss()
                .navigateToRecomendPage()
                .openDocumentByModuleIdAndDocId(USS_165)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(USS_117)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(USS_99)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(USS_189)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(USS_184)
                .checkSearchInTextWidgetIsPresent()

                .logout();
    }

    public void fss_test() {
        loginFss()
                .navigateToSolutionsPage()
                .openDocumentByModuleIdAndDocId(FSS_173)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(FSS_189)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(FSS_99)
                .checkSearchInTextWidgetIsPresent()

                .openDocumentByModuleIdAndDocId(FSS_176)
                .checkSearchInTextWidgetIsPresent()

                .logout();
    }
}

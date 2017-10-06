package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.interfaces.ISystemBasePage;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Alex Plekhov on 17.05.2016 017.
 * Часть вызовов закомментированы на случай, если такой подход себя не оправдает и нужно будет быстро переделать.
 */
public class OSS_359_1734_1735_1736_1737_1738_1739_1740_AttachmentsIn99 extends AbstractDomainTest {

    private final String documentUrl = "#/document/99/901714421/actual";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-359", testCaseVersion = "2")
    public void oss_359_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Тест ОСС-359: проверка инфорбара Приложения в НПД БСС КУ");
//        bss_359_test();
        unifiedTest(loginBss());

        updateLoginToInfo("vip");
        updateLoginAsInfo("bss.user.vip");
        report("Тест ОСС-359: проверка инфорбара Приложения в НПД БСС ВИП");
//        bss_359_test();
        unifiedTest(loginBss());

        updateLoginToInfo("usn");
        updateLoginAsInfo("bss.user.usn");
        report("Тест ОСС-359: проверка инфорбара Приложения в НПД БСС У");
//        bss_359_test();
        unifiedTest(loginBss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("bss.user.budget");
        report("Тест ОСС-359: проверка инфорбара Приложения в НПД БСС БУ");
//        bss_359_test();
        unifiedTest(loginBss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1734", testCaseVersion = "2")
    public void oss_1734_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Тест ОСС-1734: проверка инфорбара Приложения в НПД КСС КУ");
//        kss_359_test();
        unifiedTest(loginKss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("kss.user.budget");
        report("Тест ОСС-1734: проверка инфорбара Приложения в НПД КСС БУ");
//        kss_359_test();
        unifiedTest(loginKss());

        updateLoginToInfo("vip");
        updateLoginAsInfo("kss.user.vip");
        report("Тест ОСС-1734: проверка инфорбара Приложения в НПД КСС ВИП");
//        kss_359_test();
        unifiedTest(loginKss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1735", testCaseVersion = "2")
    public void oss_1735_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Тест ОСС-1735: проверка инфорбара Приложения в НПД ЮСС КУ");
//        uss_359_test();
        unifiedTest(loginUss());

        updateLoginToInfo("doc");
        updateLoginAsInfo("uss.user.vip");
        report("Тест ОСС-1735: проверка инфорбара Приложения в НПД ЮСС ВИП");
//        uss_359_test();
        unifiedTest(loginUss());

        updateLoginToInfo("budget");
        updateLoginAsInfo("uss.user.budget");
        report("Тест ОСС-1735: проверка инфорбара Приложения в НПД ЮСС БУ");
//        uss_359_test();
        unifiedTest(loginUss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1736", testCaseVersion = "2")
    public void oss_1736_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Тест ОСС-1736: проверка инфорбара Приложения в НПД ФСС");
//        fss_359_test();
        unifiedTest(loginFss());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1738", testCaseVersion = "2")
    public void oss_1738_test() {
        // EHS
        updateSystemInfo(SystemPubs.ehs);
        updateLoginAsInfo("ehs.user.commercial");
        report("Тест ОСС-1738: проверка инфорбара Приложения в НПД ОТ ОПТ");
//        ehs_359_test();
        unifiedTest(loginOT());

        updateLoginToInfo("vip");
        updateLoginAsInfo("ehs.user.vip");
        report("Тест ОСС-1738: проверка инфорбара Приложения в НПД ОТ ВИП");
//        ehs_359_test();
        unifiedTest(loginOT());

        updateLoginToInfo("mini");
        updateLoginAsInfo("ehs.user.mini");
        report("Тест ОСС-1738: проверка инфорбара Приложения в НПД ОТ БАЗ");
//        ehs_359_test();
        unifiedTest(loginOT());

        updateLoginToInfo("budget");
        updateLoginAsInfo("ehs.user.budget");
        report("Тест ОСС-1738: проверка инфорбара Приложения в НПД ОТ БУ");
//        ehs_359_test();
        unifiedTest(loginOT());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1739", testCaseVersion = "2")
    public void oss_1739_test() {
        // EDU
        updateSystemInfo(SystemPubs.edu);
        updateLoginAsInfo("edu.user.commercial");
        report("Тест ОСС-1739: проверка инфорбара Приложения в НПД ОБР ОПТ");
//        edu_359_test();
        unifiedTest(loginEdu());

        updateLoginToInfo("vip");
        updateLoginAsInfo("edu.user.vip");
        report("Тест ОСС-1739: проверка инфорбара Приложения в НПД ОБР ВИП");
//        edu_359_test();
        unifiedTest(loginEdu());

        updateLoginToInfo("mini");
        updateLoginAsInfo("edu.user.mini");
        report("Тест ОСС-1739: проверка инфорбара Приложения в НПД ОБР БАЗ");
//        edu_359_test();
        unifiedTest(loginEdu());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1737", testCaseVersion = "2")
    public void oss_1737_test() {
        // GF
        updateSystemInfo(SystemPubs.gf);
        updateLoginAsInfo("gf.user.commercial");
        report("Тест ОСС-1737: проверка инфорбара Приложения в НПД ГФ");
//        gf_359_test();
        unifiedTest(loginGF());
    }

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-1740", testCaseVersion = "2")
    public void oss_1740_test() {
        // GO
        updateSystemInfo(SystemPubs.go);
        updateLoginAsInfo("go.user.commercial");
        report("Тест ОСС-1740: проверка инфорбара Приложения в НПД ГЗ ОПТ");
//        go_359_test();
        unifiedTest(loginGo());

        updateLoginToInfo("vip");
        updateLoginAsInfo("go.user.vip");
        report("Тест ОСС-1740: проверка инфорбара Приложения в НПД ГЗ ВИП");
//        go_359_test();
        unifiedTest(loginGo());

        updateLoginToInfo("mini");
        updateLoginAsInfo("go.user.mini");
        report("Тест ОСС-1740: проверка инфорбара Приложения в НПД ГЗ БАЗ");
//        go_359_test();
        unifiedTest(loginGo());
    }

    private void bss_359_test() {
        enterToBssWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void kss_359_test() {
        enterToKssWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void uss_359_test() {
        enterToUssWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void fss_359_test() {
        enterToFssWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void ehs_359_test() {
        enterToOtWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void edu_359_test() {
        enterToEduWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void gf_359_test() {
        enterToGFWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    private void go_359_test() {
        enterToGoWithoutLogin()
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable();
    }

    public <T extends ISystemBasePage> void unifiedTest(T page) {
        page
                .openDocumentByModuleIdAndDocId(documentUrl)
                .checkApplicationsWidgetIsPresent()
                .clickOnInfobarApplicationsLink()
                .checkCurrentUrlContainsDocumentUrl("/infobar-attachment/")
                .checkApplicationsTextsArePresent()
                .checkApplicationsExtensionsArePresent()
                .checkAttachedFilesAreAvailable()
                .logout();
    }
}

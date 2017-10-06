package com.actionmedia.tests.functional.oss.law;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 12.01.2015.
 */
public class OSS_270_MainDocsBlock extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-270", testCaseVersion = "1")
    public void oss_270_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется блок 'Главные документы' раздел Правовая база КСС КУ");
        kss_270_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Главные документы' раздел Правовая база КСС БУ");
        kss_270_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Главные документы' раздел Правовая база КСС ВИП");
        kss_270_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется блок 'Главные документы' раздел Правовая база БСС КУ");
        bss_270_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется блок 'Главные документы' раздел Правовая база БСС ВИП");
        bss_270_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется блок 'Главные документы' раздел Правовая база БСС УПР");
        bss_270_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется блок 'Главные документы' раздел Правовая база БСС БУ");
        bss_270_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется блок 'Главные документы' раздел Правовая база ЮСС КУ");
        uss_270_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется блок 'Главные документы' раздел Правовая база ЮСС ДОК");
        uss_270_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется блок 'Главные документы' раздел Правовая база ФСС КУ");
        fss_270_test();
    }


    private void kss_270_test() {
        loginKss()
                .navigateToLawBasePage()
                .checkMainDocsBlockIsPresent()
                .checkMainDocsBlockLinks()
                .checkMainDocsBlockSections()
                .clickNewsPaperHeaderLink()
                .checkLawBaseNewsSection()
                .logout();
    }

    private void bss_270_test() {
        loginBss()
                .navigateToLawBasePage()
                .checkMainDocsBlockIsPresent()
                .checkMainDocsBlockLinks()
                .checkMainDocsBlockSections()
                .clickNewsPaperHeaderLink()
                .checkLawBaseNewsSection()
                .logout();
    }

    private void uss_270_test() {
        loginUss()
                .navigateToLawBasePage()
                .checkMainDocsBlockIsPresent()
                .checkMainDocsBlockLinks()
                .checkMainDocsBlockSections()
                .clickNewsPaperHeaderLink()
                .checkLawBaseNewsSection()
                .logout();
    }

    private void fss_270_test() {
        loginFss()
                .navigateToLawBasePage()
                .checkMainDocsBlockIsPresent()
                .checkMainDocsBlockLinks()
                .checkMainDocsBlockSections()
                .clickNewsPaperHeaderLink()
                .checkLawBaseNewsSection()
                .logout();
    }
}

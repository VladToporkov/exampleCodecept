package com.actionmedia.tests.functional.oss.forms;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.smoke;

/**
 * User: a.kulakov
 * Date: 27.05.2015
 * Time: 13:18
 */
public class OSS_552_CommonViewForms extends AbstractDomainTest {

    @Test(groups = {smoke})
    @TestLink(testCaseId = "OSS-552", testCaseVersion = "1")
    public void oss_552_test() {
        // KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("OSS-552: Общее отображение раздела (Формы) КСС КУ");
        kss_552_test();

        // KSS бюджетный
        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("OSS-552: Общее отображение раздела (Формы) КСС БУ");
        kss_552_test();

        // KSS vip
        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("OSS-552: Общее отображение раздела (Формы) КСС ВИП");
        kss_552_test();

        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("OSS-552: Общее отображение раздела (Формы) БСС КУ");
        bss_552_test();

        // BSS USN
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("OSS-552: Общее отображение раздела (Формы) БСС USN");
        bss_552_test();

        // BSS BU
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("OSS-552: Общее отображение раздела (Формы) БСС БУ");
        bss_552_test();

        // BSS VIP
        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("OSS-552: Общее отображение раздела (Формы) БСС ВИП");
        bss_552_test();

        // USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("OSS-552: Общее отображение раздела (Формы) ЮСС КУ");
        uss_552_test();

        // FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("OSS-552: Общее отображение раздела (Формы) ФСС КУ");
        fss_552_test();
    }

    private void kss_552_test() {
        loginKss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }

    private void bss_552_test() {
        loginBss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }

    private void uss_552_test() {
        loginUss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }

    private void fss_552_test() {
        loginFss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .logout();
    }
}

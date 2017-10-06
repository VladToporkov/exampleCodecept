package com.actionmedia.tests.functional.oss.search;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 03.03.2015
 */
public class OSS_320_SearchMenuDetails extends AbstractDomainTest {

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-320", testCaseVersion = "1")
    public void oss_320_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) КСС КУ");
        kss_320_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Меню поиска по реквизитам (Общее отображение)  КСС БУ");
        kss_320_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) КСС ВИП");
        kss_320_test();

        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) БСС КУ");
        bss_320_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) БСС ВИП");
        bss_320_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) БСС УПР");
        bss_320_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) БСС БУ");
        bss_320_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) ЮСС КУ");
        uss_320_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) ЮСС ДОК");
        uss_320_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Меню поиска по реквизитам (Общее отображение) ФСС КУ");
        fss_320_test();
    }

    private void kss_320_test() {
        loginKss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkSearchMenuDetails()
                .logout();
    }

    private void bss_320_test() {
        loginBss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkSearchMenuDetails()
                .logout();
    }

    private void uss_320_test() {
        loginUss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkSearchMenuDetails()
                .logout();
    }

    private void fss_320_test() {
        loginFss()
                .navigateToLawBasePage()
                .clickExtendedButtonInSearchBox()
                .checkSearchMenuDetails()
                .logout();
    }
}

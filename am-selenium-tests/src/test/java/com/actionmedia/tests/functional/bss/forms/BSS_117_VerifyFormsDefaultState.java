package com.actionmedia.tests.functional.bss.forms;

import com.actionmedia.autotest.annotations.LoginAs;
import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.implemented;
import static com.actionmedia.autotest.Group.smoke;

/**
 * User: n.tyukavkin
 * Date: 14.10.13
 * Time: 10:27
 */
public class BSS_117_VerifyFormsDefaultState extends AbstractDomainTest {

    @Test(groups = {smoke, implemented})
    @TestLink(testCaseId = "BSS-117", testCaseVersion = "1")
    @LoginAs(key = "bss.user.commercial")
    public void bss_ku_117_test() {
        report("Проверяется стартовая раздела Форм для БСС КУ");
        loginBss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .checkNewsBlockScrolling()
                .checkNewsBlockAreNotRepeat()
                .logout();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется стартовая раздела Форм для БСС ВИП");
        loginBss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .checkNewsBlockScrolling()
                .checkNewsBlockAreNotRepeat()
                .logout();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется стартовая раздела Форм для БСС УПР");
        loginBss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .checkNewsBlockScrolling()
                .checkNewsBlockAreNotRepeat()
                .logout();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется стартовая раздела Форм для БСС БУ");
        loginBss()
                .navigateToFormsPage()
                .checkDefaultStateFormsPage()
                .checkNewsBlockScrolling()
                .checkNewsBlockAreNotRepeat()
                .logout();
    }
}

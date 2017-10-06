package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_436_WidgetHelper extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-436", testCaseVersion = "1")
    public void oss_436_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Блок 'Помощники' БСС КУ");
        bss_436_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Блок 'Помощники' БСС ВИП");
        bss_436_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Блок 'Помощники' БСС УПР");
        bss_436_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Блок 'Помощники' БСС БУ");
        bss_436_test();

        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Виджет 'Помощник' ФСС КУ");
        fss_436_test();
    }

    private void bss_436_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkHelperOnDictionaryBoard()
                .logout();

    }

    private void fss_436_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkHelperOnDictionaryBoard()
                .logout();
    }
}

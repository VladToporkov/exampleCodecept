package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 24.02.2015.
 */

public class OSS_427_MROT extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-427", testCaseVersion = "1")
    public void oss_427_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Виджет МРОТ КСС КУ");
        kss_427_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Виджет МРОТ КСС БУ");
        kss_427_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Виджет МРОТ КСС ВИП");
        kss_427_test();

        //BSS
//        updateSystemInfo(SystemPubs.bss);
//        updateLoginAsInfo("bss.user.usn");
//        updateLoginToInfo("usn");
//        report("Проверяется Виджет МРОТ БСС УПР");
//        bss_427_test();
//
//        updateLoginAsInfo("bss.user.budget");
//        updateLoginToInfo("budget");
//        report("Проверяется Виджет МРОТ БСС БУ");
//        bss_427_test();
    }

    public void kss_427_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDisplayMrotOnDictionaryBoard()
                .checkTextMrotOnDictionaryBoard()
                .logout();
    }

    public void bss_427_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDisplayMrotOnDictionaryBoard()
                .checkTextMrotOnDictionaryBoard()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inTesting;
import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_431_WidgetReviews extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-431", testCaseVersion = "1")
    public void OSS_431_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Виджет 'Обзоры' БСС КУ");
        bss_431_test();

        updateLoginAsInfo("bss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Виджет 'Обзоры' БСС ВИП");
        bss_431_test();

        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        report("Проверяется Виджет 'Обзоры' БСС УПР");
        bss_431_test();

        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Виджет 'Обзоры' БСС БУ");
        bss_431_test();
    }

    public void bss_431_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDisplayReviewOnDictionaryBoard()
                .checkReviewOnDictionaryBoard()
                .logout();
    }
}

package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 24.02.2015.
 */

public class OSS_428_PostCards extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-428", testCaseVersion = "1")
    public void oss_428_test() {
        //KSS
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        report("Проверяется Виджет Карточки должностей КСС КУ");
        kss_428_test();

        updateLoginAsInfo("kss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Виджет Карточки должностей КСС БУ");
        kss_428_test();

        updateLoginAsInfo("kss.user.vip");
        updateLoginToInfo("vip");
        report("Проверяется Виджет Карточки должностей КСС ВИП");
        kss_428_test();

    }

    public void kss_428_test() {
        loginKss()
                .navigateToDictionaryPage()
                .checkDisplayPostOnDictionaryBoard()
                .checkPostOnDictionaryBoard()
                .logout();
    }
}

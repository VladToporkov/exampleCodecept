package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_433_WidgetHowToWork extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-433", testCaseVersion = "1")
    public void oss_433_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Виджет 'Как работать с системой юрист' ЮСС КУ");
        uss_433_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Виджет 'Как работать с системой юрист' ЮСС ДОК");
        uss_433_test();
    }

    private void uss_433_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDisplayManualOnDictionaryBoard()
                .checkManualOnDictionaryBoard()
                .logout();
    }
}

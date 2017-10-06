package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 24.02.2015.
 */

public class OSS_430_RefinancingRate extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-430", testCaseVersion = "1")
    public void oss_430_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Виджет 'Ставка рефинансирования' БСС КУ");
        bss_430_test();
    }

    public void bss_430_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDisplayRefinancingRateOnDictionaryBoard()
                .checkRefinancingRateOnDictionaryBoard()
                .logout();
    }
}

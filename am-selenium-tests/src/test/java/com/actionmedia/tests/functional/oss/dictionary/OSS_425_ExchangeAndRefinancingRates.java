package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.inDevelopment;

/**
 * Created by Shman4ik on 24.02.2015.
 */

public class OSS_425_ExchangeAndRefinancingRates extends AbstractDomainTest {

    @Test(groups = {inDevelopment})
    @TestLink(testCaseId = "OSS-425", testCaseVersion = "1")
    public void oss_425_test() {
        // BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.budget");
        updateLoginToInfo("budget");
        report("Проверяется Виджет Курсы валют и ставка рефинансирования БСС БУ");
        bss_425_test();

        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется Виджет Курсы валют и ставка рефинансирования ЮСС КУ");
        uss_425_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется Виджет Курсы валют и ставка рефинансирования ЮСС ДОК");
        uss_425_test();
    }

    private void bss_425_test() {
        loginBss()
                .navigateToDictionaryPage()
                .checkDisplayCurrencyOnDictionaryBoard()
                .checkRefinancingRateOnDictionaryBoard()
                .logout();
    }

    private void uss_425_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDisplayCurrencyOnDictionaryBoard()
                .checkRefinancingRateOnDictionaryBoard()
                .logout();
    }
}

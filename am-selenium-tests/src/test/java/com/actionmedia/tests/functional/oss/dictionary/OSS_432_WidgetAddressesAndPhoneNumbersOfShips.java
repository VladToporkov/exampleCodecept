package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_432_WidgetAddressesAndPhoneNumbersOfShips extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-432", testCaseVersion = "1")
    public void oss_432_test() {
        //USS
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.commercial");
        report("Проверяется виджет 'Адреса и телефоны судов' ЮСС КУ");
        uss_432_test();

        updateLoginAsInfo("uss.user.vip");
        updateLoginToInfo("doc");
        report("Проверяется виджет 'Адреса и телефоны судов' ЮСС ДОК");
        uss_432_test();
    }

    public void uss_432_test() {
        loginUss()
                .navigateToDictionaryPage()
                .checkDisplayAddressOnDictionaryBoard()
                .checkAddressOnDictionaryBoard()
                .logout();
    }
}

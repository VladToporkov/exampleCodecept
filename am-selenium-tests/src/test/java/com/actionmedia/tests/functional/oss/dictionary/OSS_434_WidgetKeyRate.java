package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_434_WidgetKeyRate extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-434", testCaseVersion = "1")
    public void oss_434_test() {
        //FSS
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Виджет \"Ключевая ставка\" ФСС КУ");
        fss_434_test();
    }

    public void fss_434_test() {
        loginFss()
                .navigateToDictionaryPage()
                .checkDisplayKeyRateOnDictionaryBoard()
                .checkKeyRateOnDictionaryBoard()
                .logout();
    }
}

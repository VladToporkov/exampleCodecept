package com.actionmedia.tests.functional.oss.dictionary;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

/**
 * Created by Shman4ik on 25.02.2015.
 */

public class OSS_435_WidgetFormula extends AbstractDomainTest {

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-435", testCaseVersion = "1")
    public void oss_435_test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        report("Проверяется Виджет 'Формула' ФСС КУ");
        loginFss()
                .navigateToDictionaryPage()
                .checkDisplayFormulaOnDictionaryBoard()
                .checkFormulaOnDictionaryBoard()
                .logout();
    }
}

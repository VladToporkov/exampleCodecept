package com.actionmedia.tests.functional.oss.documents;

import com.actionmedia.autotest.annotations.TestLink;
import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

import static com.actionmedia.autotest.Group.regression;

public class OSS_494_DisplayDocument190_CalendarFilters extends AbstractDomainTest {
    public static final String BUTTON_NAME = "Весь справочник";

    @Test(groups = {regression})
    @TestLink(testCaseId = "OSS-494", testCaseVersion = "1")
    public void oss_494_test() {
        //BSS
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.commercial");
        report("Проверяется Фильтры в календаре БСС КУ");
        bssDocument_190();
    }

    private void bssDocument_190(){
        loginBss()
                .navigateToDictionaryPage()

                .checkFactoryCalendar()

                .checkSetupCalendar()

                .checkFiltersCheckbox()

                .checkFilters()

                .checkClearSettings();
    }
}

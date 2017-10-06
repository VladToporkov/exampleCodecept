package com.actionmedia.tests.experimental.warmtest;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

public class BSS_KU_Warm extends AbstractDomainTest {

    @Test
    public void warm_bss_ku() {
        updateSystemInfo(SystemPubs.bss);
        enterToBssWithoutLogin()
                .navigateToRecomendPage()
                .navigateToLawBasePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage();
    }
}

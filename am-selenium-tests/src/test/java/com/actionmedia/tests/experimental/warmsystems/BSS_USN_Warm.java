package com.actionmedia.tests.experimental.warmsystems;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

public class BSS_USN_Warm extends AbstractDomainTest {

    @Test
    public void warm_bss_usn() {
        try {
            test();
        } catch (Throwable e) {
            test();
        }
    }

    private void test() {
        String bssDocumentUrl = getFullDocumentUrlByKey("bss.99.module").split("ru/")[1];
        updateSystemInfo(SystemPubs.bss);
        updateLoginAsInfo("bss.user.usn");
        updateLoginToInfo("usn");
        loginBss()
                .navigateToRecomendPage()
                .navigateToLawBasePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage()

                .openDocumentByModuleIdAndDocId(bssDocumentUrl)

                .navigateToRecomendPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .logout();
    }
}
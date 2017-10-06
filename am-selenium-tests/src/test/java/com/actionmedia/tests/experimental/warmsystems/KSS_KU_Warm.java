package com.actionmedia.tests.experimental.warmsystems;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

public class KSS_KU_Warm extends AbstractDomainTest {

    @Test
    public void warm_kss_ku() {
        try {
            test();
        } catch (Throwable e) {
            test();
        }
    }

    private void test() {
        String kssDocumentUrl = getFullDocumentUrlByKey("kss.99.module").split("ru/")[1];
        updateSystemInfo(SystemPubs.kss);
        updateLoginAsInfo("kss.user.commercial");
        loginKss()
                .navigateToAnswersPage()
                .navigateToLawBasePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage()
                .navigateToEducationPage()
                .navigateToRabotaruPage()

                .openDocumentByModuleIdAndDocId(kssDocumentUrl)

                .navigateToAnswersPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonOnAnswersPage()
                .logout();
    }
}
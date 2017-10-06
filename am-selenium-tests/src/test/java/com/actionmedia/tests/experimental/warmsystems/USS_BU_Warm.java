package com.actionmedia.tests.experimental.warmsystems;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.uss.UssServicesPage;
import org.testng.annotations.Test;

public class USS_BU_Warm extends AbstractDomainTest {

    @Test
    public void warm_uss_bu() {
        try {
            test();
        } catch (Throwable e) {
            test();
        }
    }

    private void test() {
        String ussDocumentUrl = getFullDocumentUrlByKey("uss.99.module").split("ru/")[1];
        updateSystemInfo(SystemPubs.uss);
        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        UssServicesPage ussServicesPage = loginUss()
                .navigateToRecomendPage()
                .navigateToLawBasePage()
                .navigateToLawPracticePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage()
                .returnToBack();

        if (getSettings().isRunWeb13()) {
            ussServicesPage
                    .returnToBack();
        }

        ussServicesPage
                .openDocumentByModuleIdAndDocId(ussDocumentUrl)

                .navigateToRecomendPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .logout();
    }
}

package com.actionmedia.tests.experimental.warmsystems;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import org.testng.annotations.Test;

public class WarmUss extends AbstractDomainTest {

    @Test
    public void warm_uss() {
        try {
            test();
        } catch (Throwable e) {
            test();
        }
    }

    private void test() {
        String ussDocumentUrl = getFullDocumentUrlByKey("uss.99.module").split("ru/")[1];
        updateSystemInfo(SystemPubs.uss);

        updateLoginAsInfo("uss.user.all");
        loginUss()
                .navigateToRecomendPage()
                .navigateToLawBasePage()
                .navigateToLawPracticePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage()

                .openDocumentByModuleIdAndDocId(ussDocumentUrl)

                .navigateToRecomendPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .logout();

        updateLoginAsInfo("uss.user.budget");
        updateLoginToInfo("budget");
        loginUss()
                .navigateToRecomendPage()
                .navigateToLawBasePage()
                .navigateToLawPracticePage()
                .navigateToFormsPage()
                .navigateToDictionaryPage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToServicesPage()
                .returnToMainPage()

                .openDocumentByModuleIdAndDocId(ussDocumentUrl)

                .navigateToRecomendPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .logout();
    }
}

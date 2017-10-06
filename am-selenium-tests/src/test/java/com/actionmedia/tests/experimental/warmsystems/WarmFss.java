package com.actionmedia.tests.experimental.warmsystems;

import com.actionmedia.autotest.utils.SystemPubs;
import com.actionmedia.base.AbstractDomainTest;
import com.actionmedia.pages.fss.FssDictionaryPage;
import org.testng.annotations.Test;

public class WarmFss extends AbstractDomainTest {

    @Test
    public void warm_fss() {
        try {
            test();
        } catch (Throwable e) {
            test();
        }
    }

    private void test() {
        updateSystemInfo(SystemPubs.fss);
        updateLoginAsInfo("fss.user.commercial");
        String fssDocumentUrl = getFullDocumentUrlByKey("fss.99.module").split("ru/")[1];
        FssDictionaryPage fssDictionaryPage = loginFss()
                .navigateToSolutionsPage()
                .navigateToFormsPage()
                .navigateToLawBasePage()
                .navigateToMagazinesPage()
                .navigateToVideoPage()
                .navigateToDictionaryPage();

        if (!getSettings().isRunWeb13()) {
            fssDictionaryPage
                    .navigateToServicesPage();
        }

        fssDictionaryPage
                .openDocumentByModuleIdAndDocId(fssDocumentUrl)

                .navigateToSolutionsPage()
                .inputTextInSearchBox("закон")
                .clickSearchButtonAndNavigateToSearchResultPage()
                .logout();
    }
}
